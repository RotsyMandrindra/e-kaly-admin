package hei.school.ekaly.controller;

import hei.school.ekaly.model.Action;
import hei.school.ekaly.service.ActionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

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
}
