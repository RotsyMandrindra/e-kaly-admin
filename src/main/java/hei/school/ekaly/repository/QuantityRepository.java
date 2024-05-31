package hei.school.ekaly.repository;

import hei.school.ekaly.model.Quantity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository
@AllArgsConstructor
@NoArgsConstructor
public class QuantityRepository implements Implementation<Quantity>{
    @Autowired
    private Connection connection;

    @Override
    public Quantity create(Quantity toCreate) throws SQLException {
        if (toCreate.getQuantityId() == null){
            UUID uuid = UUID.randomUUID();
            toCreate.setQuantityId(uuid);
        }

        String sql = "INSERT INTO quantity (quantity_id, quantity_name) VALUES (?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, toCreate.getQuantityId());
            preparedStatement.setString(2, toCreate.getQuantityName());
            preparedStatement.executeUpdate();
        }
        return toCreate;
    }

    @Override
    public List<Quantity> getAll() throws SQLException {
        String sql = "SELECT * FROM quantity;";
        List<Quantity> quantities = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Quantity quantity = new Quantity();
                quantity.setQuantityId(resultSet.getObject("quantity_id", UUID.class));
                quantity.setQuantityName(resultSet.getString("quantity_name"));
                quantities.add(quantity);
            }
        }
        return quantities;
    }

    @Override
    public List<Quantity> getById(UUID id) throws SQLException {
        String sql = "SELECT * FROM quantity WHERE quantity_id = ?;";
        List<Quantity> quantities = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Quantity quantity = new Quantity();
                quantity.setQuantityId(resultSet.getObject("quantity_id", UUID.class));
                quantity.setQuantityName(resultSet.getString("quantity_name"));
                quantities.add(quantity);
            }
        }
        return quantities;
    }

    @Override
    public Quantity update(UUID id, Quantity toUpdate) throws SQLException {
        String sql = "UPDATE quantity SET quantity_name =? WHERE quantity_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toUpdate.getQuantityName());
            preparedStatement.setObject(2, toUpdate.getQuantityId());
            preparedStatement.executeUpdate();
        }
        return toUpdate;
    }

    @Override
    public String delete(UUID id) throws SQLException {
        String sql = "DELETE FROM quantity WHERE quantity_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, id);
        }
        return "Quantity deleted successfully!!";
    }
}
