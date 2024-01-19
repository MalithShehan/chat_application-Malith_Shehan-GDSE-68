package lk.ijse.chatApplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class LoginPageController {

    @FXML
    private AnchorPane Login;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void forgetPasswordBtnOnAction(MouseEvent event) {

    }

    @FXML
    void loginBtnOnAction(ActionEvent event) {

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
