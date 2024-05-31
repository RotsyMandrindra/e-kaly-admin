package hei.school.ekaly.repository;

import hei.school.ekaly.model.Composed;
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
public class ComposedRepository implements Implementation<Composed>{
    @Autowired
    private Connection connection;

    @Override
    public Composed create(Composed toCreate) throws SQLException {
        String sql = "INSERT INTO composed (menu_id, ingredient_id, quantity_required) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, toCreate.getMenuId());
            preparedStatement.setObject(2, toCreate.getIngredientId());
            preparedStatement.setDouble(3, toCreate.getQuantityRequired());
            preparedStatement.executeUpdate();
        }
        return toCreate;
    }

    @Override
    public List<Composed> getAll() throws SQLException {
        String sql = "SELECT * FROM composed;";
        List<Composed> composedList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Composed composed = new Composed();
                composed.setMenuId(resultSet.getObject("menu_id", UUID.class));
                composed.setIngredientId(resultSet.getObject("ingredient_id", UUID.class));
                composed.setQuantityRequired(resultSet.getDouble("quantity_required"));
                composedList.add(composed);
            }
        }
        return composedList;
    }
    // à fixer
    @Override
    public List<Composed> getById(UUID id) throws SQLException {
        String sql = "SELECT * FROM composed WHERE menu_id = ? AND ingredient_id = ?;";
        List<Composed> composedList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Composed composed = new Composed();
                composed.setMenuId(resultSet.getObject("menu_id", UUID.class));
                composed.setIngredientId(resultSet.getObject("ingredient_id", UUID.class));
                composed.setQuantityRequired(resultSet.getDouble("quantity_required"));
                composedList.add(composed);
            }
        }
        return composedList;
    }
    //à fixer
    @Override
    public Composed update(UUID id, Composed toUpdate) throws SQLException {
        String sql = "UPDATE composed SET quantity_required = ? WHERE menu_id = ? AND ingredient_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDouble(1, toUpdate.getQuantityRequired());
            preparedStatement.setObject(2, toUpdate.getMenuId());
            preparedStatement.setObject(3, toUpdate.getIngredientId());
            preparedStatement.executeUpdate();
        }
        return toUpdate;
    }
    //à fixer
    @Override
    public String delete(UUID id) throws SQLException {
        String sql = "DELETE FROM composed WHERE menu_id = ? AND ingredient_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        }
        return "Composed deleted successfully!!";
    }
}
