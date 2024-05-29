package hei.school.ekaly.service;

import hei.school.ekaly.model.Action;
import hei.school.ekaly.repository.ActionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ActionService {
    @Autowired
    private ActionRepository actionRepository;

    public Action create(Action toCreate) throws SQLException{
        return actionRepository.create(toCreate);
    }
}
