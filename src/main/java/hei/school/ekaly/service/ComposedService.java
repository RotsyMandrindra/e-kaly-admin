package hei.school.ekaly.service;

import hei.school.ekaly.model.Composed;
import hei.school.ekaly.repository.ComposedRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ComposedService {
    @Autowired
    private ComposedRepository composedRepository;

    public Composed create(Composed toCreate) throws SQLException{
        return composedRepository.create(toCreate);
    }

    public Composed update(UUID id, Composed toUpdate) throws SQLException{
        return composedRepository.update(id, toUpdate);
    }

    public List<Composed> getAll() throws SQLException{
        return composedRepository.getAll();
    }

    public List<Composed> getById(UUID id) throws SQLException{
        return composedRepository.getById(id);
    }

    public String delete(UUID id) throws SQLException{
        return composedRepository.delete(id);
    }
}
