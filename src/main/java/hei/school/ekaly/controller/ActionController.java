package hei.school.ekaly.controller;

import hei.school.ekaly.model.Action;
import hei.school.ekaly.service.ActionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Controller
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class ActionController {
    @Autowired
    private ActionService actionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/action/create")
    public Action create(@RequestBody Action toCreate) throws SQLException {
        return actionService.create(toCreate);
    }

    @GetMapping("/actions")
    public List<Action> getAll() throws SQLException{
        return actionService.getAll();
    }

    @GetMapping("/action/{id}")
    public List<Action> getById(@PathVariable UUID id) throws SQLException{
        return actionService.getById(id);
    }

    @PutMapping("/action/update/{id}")
    public Action update(@PathVariable UUID id, @RequestBody Action toUpdate) throws SQLException{
        return actionService.update(id, toUpdate);
    }

    @DeleteMapping("/action/delete/{id}")
    public String delete(@PathVariable UUID id) throws SQLException{
        return actionService.delete(id);
    }
}
