package lk.ijse.chatApplication.bo;

import lk.ijse.chatApplication.bo.custom.impl.RegisterBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        REGISTER
    }

    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case REGISTER:
                return new RegisterBOImpl();
            default:
                return null;
        }
    }
}
