package hei.school.ekaly.repository;

import hei.school.ekaly.model.Menu;
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
public class MenuRepository implements Implementation<Menu>{
    @Autowired
    private Connection connection;
    @Override
    public Menu create(Menu toCreate) throws SQLException {

        if (toCreate.getMenuId() == null){
            UUID uuid = UUID.randomUUID();
            toCreate.setMenuId(uuid);
        }
        String sql = "INSERT INTO menu (menu_id, menu_name, unit_price, restaurant_id) VALUES (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, toCreate.getMenuId());
            preparedStatement.setString(2, toCreate.getMenuName());
            preparedStatement.setDouble(3, toCreate.getUnitPrice());
            preparedStatement.setObject(4, toCreate.getRestaurantId());
            preparedStatement.executeUpdate();
        }
        return toCreate;
    }

    @Override
    public List<Menu> getAll() throws SQLException {
        List<Menu> menuList = new ArrayList<>();
        String sql = "SELECT * FROM menu;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Menu menu = new Menu();
                menu.setMenuId(resultSet.getObject("menu_id", UUID.class));
                menu.setMenuName(resultSet.getString("menu_name"));
                menu.setUnitPrice(resultSet.getDouble("unit_price"));
                menu.setRestaurantId(resultSet.getObject("restaurant_id", UUID.class));
                menuList.add(menu);
                }
            }
        return menuList;
    }

    @Override
    public List<Menu> getById(UUID id) throws SQLException {
        List<Menu> menuListById = new ArrayList<>();
        String sql =  "SELECT * FROM menu WHERE menu_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Menu menu = new Menu();
                menu.setMenuId(resultSet.getObject("menu_id", UUID.class));
                menu.setMenuName(resultSet.getString("menu_name"));
                menu.setUnitPrice(resultSet.getDouble("unit_price"));
                menu.setRestaurantId(resultSet.getObject("restaurant_id", UUID.class));
            }
        }
        return menuListById;
    }

    @Override
    public Menu update(UUID id, Menu toUpdate) throws SQLException {
        String sql = "UPDATE menu SET menu_name=?, unit_price=?, restaurant_id=? WHERE menu_id=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toUpdate.getMenuName());
            preparedStatement.setDouble(2, toUpdate.getUnitPrice());
            preparedStatement.setObject(3, toUpdate.getRestaurantId());
            preparedStatement.setObject(4, toUpdate.getMenuId());
            preparedStatement.executeUpdate();
        }
        return toUpdate;
    }

    @Override
    public String delete(UUID id) throws SQLException {
        String sql = "DELETE FROM menu WHERE menu_id =?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        }
        return "Menu deleted successfully!!";
    }
}
