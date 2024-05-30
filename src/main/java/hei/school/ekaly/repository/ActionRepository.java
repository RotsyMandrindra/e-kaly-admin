package hei.school.ekaly.repository;

import hei.school.ekaly.model.Action;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.Instant;
import java.util.UUID;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class ActionRepository implements Implementation<Action>{
    @Autowired
    private Connection connection   ;
    @Override
    public Action create(Action toCreate) throws SQLException {

        if (toCreate.getActionId() == null){
            UUID uuid = UUID.randomUUID();
            toCreate.setActionId(uuid);
        }

        if (toCreate.getActionDate() == null){
            Instant currentDate = Instant.now();
            toCreate.setActionDate(currentDate);
        }

        double newStockValue = getCurrentStockValue();
        if ("Supply".equals(toCreate.getActionType())){
            newStockValue += toCreate.getProvidingValue();
        } else if ("Outlet".equals(toCreate.getActionType())) {
            newStockValue -= toCreate.getSellingValue();
        }

        String updateSql = "UPDATE action SET stock_value = ? WHERE action_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)){
            preparedStatement.setDouble(1, newStockValue);
            preparedStatement.setObject(2, toCreate.getActionId());
            preparedStatement.executeUpdate();
        }

        String insertSql = "INSERT INTO action (action_id, action_type, stock_value, selling_value, providing_value, action_date) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setObject(1, toCreate.getActionId());
            preparedStatement.setString(2, toCreate.getActionType());
            preparedStatement.setDouble(3, newStockValue);
            preparedStatement.setDouble(4, toCreate.getSellingValue());
            preparedStatement.setDouble(5, toCreate.getProvidingValue());
            preparedStatement.setTimestamp(6, Timestamp.from(toCreate.getActionDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toCreate;
    }

    private double getCurrentStockValue() throws SQLException {
        String sql = "SELECT stock_value FROM action ORDER BY action_date DESC LIMIT 1;";
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return resultSet.getDouble("stock_value");
            }
        }
        return 0;
    }
}
