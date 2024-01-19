package lk.ijse.chatApplication.bo.custom.impl;

import lk.ijse.chatApplication.bo.custom.RegisterBO;
import lk.ijse.chatApplication.dao.DAOFactory;
import lk.ijse.chatApplication.dao.custom.RegisterDAO;
import lk.ijse.chatApplication.dto.RegisterDTO;
import lk.ijse.chatApplication.entity.Register;

import java.sql.SQLException;

public class RegisterBOImpl implements RegisterBO {

    RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.REGISTER);
    @Override
    public boolean save(RegisterDTO dto) throws SQLException, ClassNotFoundException {
        return registerDAO.save(new Register(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()
        ));
    }
}
