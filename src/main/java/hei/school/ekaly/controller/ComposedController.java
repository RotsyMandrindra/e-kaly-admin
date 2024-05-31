package hei.school.ekaly.controller;

import hei.school.ekaly.model.Composed;
import hei.school.ekaly.service.ComposedService;
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
public class ComposedController {
    @Autowired
    private ComposedService composedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/composed/create")
    public Composed create(@RequestBody Composed toCreate) throws SQLException{
        return composedService.create(toCreate);
    }

    @PutMapping("/composed/update/{id}")
    public Composed update(@PathVariable UUID id, @RequestBody Composed toUpdate) throws SQLException{
        return composedService.update(id, toUpdate);
    }

    @GetMapping("/composedList")
    public List<Composed> getAll() throws SQLException{
        return composedService.getAll();
    }

    @GetMapping("/composed/{id}")
    public List<Composed> getById(@PathVariable UUID id) throws SQLException{
        return composedService.getById(id);
    }

    @DeleteMapping("/composed/delete/{id}")
    public String delete(@PathVariable UUID id) throws SQLException{
        return composedService.delete(id);
    }
}
