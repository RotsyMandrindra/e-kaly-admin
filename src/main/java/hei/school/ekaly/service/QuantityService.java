package hei.school.ekaly.service;

import hei.school.ekaly.model.Quantity;
import hei.school.ekaly.repository.QuantityRepository;
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
public class QuantityService {
    @Autowired
    public QuantityRepository quantityRepository;

    public Quantity create(Quantity toCreate) throws SQLException{
        return quantityRepository.create(toCreate);
    }

    public Quantity update(UUID id, Quantity toUpdate) throws SQLException{
        return quantityRepository.update(id, toUpdate);
    }

    public List<Quantity> getAll() throws SQLException{
        return quantityRepository.getAll();
    }

    public List<Quantity> getById(UUID id) throws SQLException{
        return quantityRepository.getById(id);
    }

    public String delete(UUID id) throws SQLException{
        return quantityRepository.delete(id);
    }
}
