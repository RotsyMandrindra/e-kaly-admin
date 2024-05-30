package hei.school.ekaly.repository;

import java.sql.SQLException;

public interface Implementation<T>{
    public T create(T toCreate) throws SQLException;
    }
