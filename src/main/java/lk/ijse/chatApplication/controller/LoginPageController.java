package lk.ijse.chatApplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.chatApplication.bo.BOFactory;
import lk.ijse.chatApplication.bo.custom.RegisterBO;
import lk.ijse.chatApplication.dao.DAOFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginPageController {

    @FXML
    private AnchorPane Login;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTER);

    @FXML
    void forgetPasswordBtnOnAction(MouseEvent event) {

    }

    @FXML
    void loginBtnOnAction(ActionEvent event) {
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        try {
            boolean isIn = registerBO.searchUser(email, password);
            if (!isIn) {
                new Alert(Alert.AlertType.WARNING,"Invalid Email or Password").show();
            }
            else {
                Login.getChildren().clear();
                Login.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/chat_page.fxml"))));
            }
            } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void signUpBtnOnAction(MouseEvent event) {
        try {
            Login.getChildren().clear();
            Login.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/register_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
