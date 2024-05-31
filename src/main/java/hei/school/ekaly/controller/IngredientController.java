package hei.school.ekaly.controller;

import hei.school.ekaly.model.Ingredient;
import hei.school.ekaly.service.IngredientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@Controller
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/ingredients")
    public List<Ingredient> getAll() throws SQLException{
        return ingredientService.getAll();
    }

    @GetMapping("/ingredient/{id}")
    public List<Ingredient> getById(@PathVariable UUID id) throws SQLException{
        return ingredientService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/ingredient/create")
    public Ingredient create(@RequestBody Ingredient toCreate) throws SQLException{
        return ingredientService.create(toCreate);
    }

    @PutMapping("/ingredient/update/{id}")
    public Ingredient update(@PathVariable UUID id, @RequestBody Ingredient toUpdate) throws SQLException{
        return ingredientService.update(id, toUpdate);
    }

    @DeleteMapping("/ingredient/delete/{id}")
    public String delete(@PathVariable UUID id) throws SQLException{
        return ingredientService.delete(id);
    }
}
