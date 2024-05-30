package hei.school.ekaly.repository;

import hei.school.ekaly.model.Restaurant;
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
public class RestaurantRepository implements Implementation<Restaurant>{
    @Autowired
    private Connection connection;

    @Override
    public Restaurant create(Restaurant toCreate) throws SQLException {
        if (toCreate.getRestaurantId() == null){
            UUID uuid = UUID.randomUUID();
            toCreate.setRestaurantId(uuid);
        }

        String sql = "INSERT INTO restaurant (restaurant_id, address) VALUES (?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, toCreate.getRestaurantId());
            preparedStatement.setString(2, toCreate.getAddress());
            preparedStatement.executeUpdate();
        }
        return toCreate;
    }

    @Override
    public List<Restaurant> getAll() throws SQLException {
        String sql = "SELECT * FROM restaurant;";
        List<Restaurant> restaurants = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantId(resultSet.getObject("restaurant_id", UUID.class));
                restaurant.setAddress(resultSet.getString("address"));
                restaurants.add(restaurant);
            }
        }
        return restaurants;
    }

    @Override
    public List<Restaurant> getById(UUID id) throws SQLException {
        List<Restaurant> restaurantById = new ArrayList<>();
        String sql = "SELECT * FROM restaurant WHERE restaurant_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantId(resultSet.getObject("restaurant_id", UUID.class));
                restaurant.setAddress(resultSet.getString("address"));
                restaurantById.add(restaurant);
            }
        }
        return restaurantById;
    }

    @Override
    public Restaurant update(UUID id, Restaurant toUpdate) throws SQLException {
        String sql = "UPDATE restaurant SET address = ? WHERE restaurant_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toUpdate.getAddress());
            preparedStatement.setObject(2, toUpdate.getRestaurantId());
            preparedStatement.executeUpdate();
        }
        return toUpdate;
    }

    @Override
    public String delete(UUID id) throws SQLException {
        String sql = "DELETE FROM restaurant WHERE restaurant_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, id);
        }
        return "Restaurant deleted successfully";
    }
}
