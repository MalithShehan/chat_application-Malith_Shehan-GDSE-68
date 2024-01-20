package lk.ijse.chatApplication.dao;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO{
    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean searchUser(String email, String password) throws SQLException, ClassNotFoundException;
}
