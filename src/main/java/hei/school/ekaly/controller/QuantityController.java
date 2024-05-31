package hei.school.ekaly.controller;

import hei.school.ekaly.model.Quantity;
import hei.school.ekaly.service.QuantityService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RestController
@Controller
@AllArgsConstructor
@NoArgsConstructor
public class QuantityController {
    @Autowired
    private QuantityService quantityService;

    @GetMapping("/quantities")
    public List<Quantity> getAll() throws SQLException{
        return quantityService.getAll();
    }

    @GetMapping("/quantity/{id}")
    public List<Quantity> getById(@PathVariable UUID id) throws SQLException{
        return quantityService.getById(id);
    }

    @PostMapping("/quantity/create")
    public Quantity create(@RequestBody Quantity toCreate) throws SQLException{
        return quantityService.create(toCreate);
    }

    @PutMapping("/quantity/update/{id}")
    public Quantity update(@PathVariable UUID id, @RequestBody Quantity toUpdate) throws SQLException{
        return quantityService.update(id, toUpdate);
    }

    @DeleteMapping("/quantity/delete/{id}")
    public String delete(@PathVariable UUID id) throws SQLException{
        return quantityService.delete(id);
    }
}
