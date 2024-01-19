package lk.ijse.chatApplication.dao;

import lk.ijse.chatApplication.bo.custom.impl.RegisterBOImpl;
import lk.ijse.chatApplication.dao.custom.impl.RegisterDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ?daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        REGISTER
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case REGISTER:
                return new RegisterDAOImpl()    ;
            default:
                return null;
        }
    }
}
