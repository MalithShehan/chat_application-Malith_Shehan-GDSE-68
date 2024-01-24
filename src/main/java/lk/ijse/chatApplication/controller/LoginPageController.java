package lk.ijse.chatApplication.controller;

import com.mysql.cj.log.Log;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginPageController {

    @FXML
    private AnchorPane Login;

    @FXML
    private TextField txtName;

    @FXML
    void loginBtnOnAction(ActionEvent event) {
        try {
            Login.getChildren().clear();
            Login.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/chat_page.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
