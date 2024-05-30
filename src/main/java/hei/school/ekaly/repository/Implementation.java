package hei.school.ekaly.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface Implementation<T>{
    public T create(T toCreate) throws SQLException;
    public List<T> getAll() throws SQLException;
    public List<T> getById(UUID id) throws SQLException;
    public T update(UUID id, T toUpdate) throws SQLException;
    public String delete(UUID id) throws SQLException;
    }
