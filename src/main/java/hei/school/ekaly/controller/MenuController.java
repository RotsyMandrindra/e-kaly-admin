package hei.school.ekaly.controller;

import hei.school.ekaly.model.Menu;
import hei.school.ekaly.service.MenuService;
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
public class MenuController {
    @Autowired
    private MenuService menuService;

@GetMapping("/menus")
public List<Menu> getAll() throws SQLException{
    return menuService.getAll();
}

@GetMapping("/menu/{id}")
    public List<Menu> getById(@PathVariable("id") UUID id) throws SQLException{
    return menuService.getById(id);
}

@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/menu/create")
    public Menu create(@RequestBody Menu toCreate) throws SQLException{
    return menuService.create(toCreate);
}

@PutMapping("/menu/update/{id}")
    public Menu update(@PathVariable("id") UUID id, @RequestBody Menu toUpdate) throws SQLException{
    return menuService.update(id, toUpdate);
}

@DeleteMapping("/menu/delete/{id}")
public String delete(@PathVariable("id") UUID id) throws SQLException{
    return menuService.delete(id);
}
}
