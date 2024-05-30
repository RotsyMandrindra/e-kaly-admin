package hei.school.ekaly.service;

import hei.school.ekaly.model.Restaurant;
import hei.school.ekaly.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    public List<Restaurant> getAll() throws SQLException{
        return restaurantRepository.getAll();
    }
    public List<Restaurant> getById(UUID id) throws SQLException{
        return restaurantRepository.getById(id);
    }
    public Restaurant create(Restaurant toCreate) throws SQLException{
        return restaurantRepository.create(toCreate);
    }
    public Restaurant update(UUID id, Restaurant toUpdate) throws SQLException{
        return restaurantRepository.update(id, toUpdate);
    }
    public String delete(UUID id) throws SQLException{
        return restaurantRepository.delete(id);
    }
}
