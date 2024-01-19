package lk.ijse.chatApplication.bo.custom;

import lk.ijse.chatApplication.bo.SuperBO;
import lk.ijse.chatApplication.dto.RegisterDTO;

import java.sql.SQLException;

public interface RegisterBO extends SuperBO {
    boolean save(RegisterDTO dto) throws SQLException, ClassNotFoundException;
}
