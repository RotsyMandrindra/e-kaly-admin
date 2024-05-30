package hei.school.ekaly.service;

import hei.school.ekaly.model.Action;
import hei.school.ekaly.repository.ActionRepository;
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
public class ActionService {
    @Autowired
    private ActionRepository actionRepository;

    public Action create(Action toCreate) throws SQLException{
        return actionRepository.create(toCreate);
    }

    public Action update(UUID id, Action toUpdate) throws SQLException{
        return actionRepository.update(id, toUpdate);
    }

    public List<Action> getAll() throws SQLException{
        return actionRepository.getAll();
    }

    public List<Action> getById(UUID id) throws SQLException{
        return actionRepository.getById(id);
    }

    public String delete(UUID id) throws SQLException{
        return actionRepository.delete(id);
    }
}
