package hei.school.ekaly.repository;

import hei.school.ekaly.model.Ingredient;
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
public class IngredientRepository implements Implementation<Ingredient>{
    @Autowired
    private Connection connection;

    @Override
    public Ingredient create(Ingredient toCreate) throws SQLException {
        if (toCreate.getIngredientId() == null){
            UUID uuid = UUID.randomUUID();
            toCreate.setIngredientId(uuid);
        }
        String sql = "INSERT INTO ingredient (ingredient_id, ingredient_name, unit_price, quantity_id, action_id) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, toCreate.getIngredientId());
            preparedStatement.setString(2, toCreate.getIngredientName());
            preparedStatement.setDouble(3, toCreate.getUnitPrice());
            preparedStatement.setObject(4, toCreate.getQuantityId());
            preparedStatement.setObject(5, toCreate.getActionId());
            preparedStatement.executeUpdate();
        }
        return toCreate;
    }

    @Override
    public List<Ingredient> getAll() throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        String sql = "SELECT * FROM ingredient;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Ingredient ingredient = new Ingredient();
                ingredient.setIngredientId(resultSet.getObject("ingredient_id", UUID.class));
                ingredient.setIngredientName(resultSet.getString("ingredient_name"));
                ingredient.setUnitPrice(resultSet.getDouble("unit_price"));
                ingredient.setQuantityId(resultSet.getObject("quantity_id", UUID.class));
                ingredient.setActionId(resultSet.getObject("action_id", UUID.class));
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    @Override
    public List<Ingredient> getById(UUID id) throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        String sql = "SELECT * FROM ingredient WHERE ingredient_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Ingredient ingredient = new Ingredient();
                ingredient.setIngredientId(resultSet.getObject("ingredient_id", UUID.class));
                ingredient.setIngredientName(resultSet.getString("ingredient_name"));
                ingredient.setUnitPrice(resultSet.getDouble("unit_price"));
                ingredient.setQuantityId(resultSet.getObject("quantity_id", UUID.class));
                ingredient.setActionId(resultSet.getObject("action_id", UUID.class));
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    @Override
    public Ingredient update(UUID id, Ingredient toUpdate) throws SQLException {
        String sql = "UPDATE ingredient SET ingredient_name = ?, unit_price = ?, quantity_id = ?, action_id = ? WHERE ingredient_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toUpdate.getIngredientName());
            preparedStatement.setDouble(2, toUpdate.getUnitPrice());
            preparedStatement.setObject(3, toUpdate.getQuantityId());
            preparedStatement.setObject(4, toUpdate.getActionId());
            preparedStatement.setObject(5, toUpdate.getIngredientId());
        }
        return toUpdate;
    }

    @Override
    public String delete(UUID id) throws SQLException {
        String sql = "DELETE FROM ingredient WHERE ingredient_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        }
        return "Ingredient deleted  successfully!!";
    }
}
