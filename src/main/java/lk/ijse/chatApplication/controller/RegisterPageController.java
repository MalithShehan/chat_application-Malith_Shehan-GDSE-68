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
import lk.ijse.chatApplication.dto.RegisterDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterPageController {

    @FXML
    private AnchorPane CreatAnAccount;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword;

    RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTER);

    @FXML
    void backBtnOnAction(ActionEvent event) {
        try {
            CreatAnAccount.getChildren().clear();
            CreatAnAccount.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/login_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void signInBtnOnAction(MouseEvent event) {

    }

    @FXML
    void signUpBtnOnAction(ActionEvent event) {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        try {
            boolean isValidated = validateUser();

            if (isValidated) {
                boolean isSaved = registerBO.save(new RegisterDTO(name, email, password));

                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User Register Successfully").show();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateUser() {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        boolean isNameValidated = Pattern.matches("[A-Za-z]{3,}", name);
        if (!isNameValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid User Name!").show();
            return false;
        }

        boolean isEmailValidated = Pattern.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$", email);
        if (!isEmailValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Email Address!").show();
            return false;
        }

        boolean isPasswordValidated = Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d\\S]{8,}$", password);
        if (!isPasswordValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Password").show();
            return false;
        }
        return true;
    }

}
