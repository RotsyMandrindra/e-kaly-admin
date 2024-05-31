package hei.school.ekaly.service;

import hei.school.ekaly.model.Ingredient;
import hei.school.ekaly.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient create(Ingredient toCreate) throws SQLException{
        return ingredientRepository.create(toCreate);
    }

    public Ingredient update(UUID id, Ingredient toUpdate) throws SQLException{
        return ingredientRepository.update(id, toUpdate);
    }

    public List<Ingredient> getAll() throws SQLException{
        return ingredientRepository.getAll();
    }

    public List<Ingredient> getById(UUID id) throws SQLException{
        return ingredientRepository.getById(id);
    }

    public String delete(UUID id) throws SQLException{
        return ingredientRepository.delete(id);
    }
}
