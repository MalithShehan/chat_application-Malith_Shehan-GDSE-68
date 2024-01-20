package lk.ijse.chatApplication.dao.custom.impl;

import lk.ijse.chatApplication.dao.SQLUtil;
import lk.ijse.chatApplication.dao.custom.RegisterDAO;
import lk.ijse.chatApplication.entity.Register;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public boolean save(Register dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO user VALUES (?,?,?)",
        dto.getName(),
        dto.getEmail(),
        dto.getPassword());
    }

    @Override
    public boolean searchUser(String email, String password) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM user WHERE email=? AND password=?", email, password);

        return resultSet.next();

    }
}
