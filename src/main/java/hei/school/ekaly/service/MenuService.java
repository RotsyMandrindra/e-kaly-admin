package hei.school.ekaly.service;

import hei.school.ekaly.model.Menu;
import hei.school.ekaly.repository.MenuRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    public Menu create(Menu toCreate) throws SQLException{
        return menuRepository.create(toCreate);
    }
    public List<Menu> getAll() throws SQLException{
        return menuRepository.getAll();
    }
    public List<Menu> getById(UUID id) throws SQLException{
        return menuRepository.getById(id);
    }
    public Menu update(UUID id, Menu toUpdate) throws SQLException{
        return menuRepository.update(id, toUpdate);
    }
    public String delete(UUID id) throws SQLException{
        return menuRepository.delete(id);
    }
}
