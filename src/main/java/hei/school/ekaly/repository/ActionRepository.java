package hei.school.ekaly.repository;

import hei.school.ekaly.model.Action;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class ActionRepository implements Implementation<Action>{
    @Autowired
    private Connection connection   ;
    @Override
    public Action create(Action toCreate) {

        if (toCreate.getActionId() == null){
            UUID uuid = UUID.randomUUID();
            toCreate.setActionId(uuid);
        }

        if (toCreate.getActionDate() == null){
            Instant currentDate = Instant.now();
            toCreate.setActionDate(currentDate);
        }

        String sql = "INSERT INTO action (action_id, action_type, stock_value, selling_value, providing_value, action_date) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setObject(1, toCreate.getActionId());
            preparedStatement.setString(2, toCreate.getActionType());
            preparedStatement.setDouble(3, toCreate.getStockValue());
            preparedStatement.setDouble(4, toCreate.getSellingValue());
            preparedStatement.setDouble(5, toCreate.getProvidingValue());
            preparedStatement.setTimestamp(6, Timestamp.from(toCreate.getActionDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toCreate;
    }
}
