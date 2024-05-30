package hei.school.ekaly.controller;

import hei.school.ekaly.model.Restaurant;
import hei.school.ekaly.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RestController
@Controller
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getAll() throws SQLException{
        return restaurantService.getAll();
    }

    @GetMapping("/restaurant/{id}")
    public List<Restaurant> getById(@PathVariable UUID id) throws SQLException{
        return restaurantService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/restaurant/create")
    public Restaurant create(@RequestBody Restaurant toCreate) throws SQLException{
        return restaurantService.create(toCreate);
    }

    @PutMapping("/restaurant/update/{id}")
    public Restaurant update(@PathVariable UUID id, @RequestBody Restaurant toUpdate) throws SQLException{
        return restaurantService.update(id, toUpdate);
    }

    @DeleteMapping("/restaurant/delete/{id}")
    public String delete(@PathVariable UUID id) throws SQLException{
        return restaurantService.delete(id);
    }
}
