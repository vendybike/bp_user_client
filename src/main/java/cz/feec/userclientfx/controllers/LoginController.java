/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.feec.userclientfx.controllers;

import cz.feec.userclientfx.LoginUser;
import cz.feec.userclientfx.entity.User;
import cz.feec.userclientfx.rest.UserRestApi;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author vendy
 */
public class LoginController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;

    Stage stage;
    
    UserRestApi connect;

    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void loginButtonClick(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        if (authentizated()) {
            
            stage = (Stage) loginButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
        }
    }

    private boolean authentizated() throws NoSuchAlgorithmException, IOException {
       
       if (passwordField.getText().isEmpty() && emailField.getText().isEmpty()) {
            return false;
        }
        
        UserRestApi rest = UserRestApi.getRest();
        User user = rest.getUser(emailField.getText());
        System.out.println(sha1(passwordField.getText()+emailField.getText()) +" = "+ user.getPassword());
        if(user.getEmail().equals(emailField.getText())){
            if(sha1(passwordField.getText()+emailField.getText()).equals(user.getPassword())){
                LoginUser.loginUser(user);  
                return true;
            }
        }
        return false;
    }
    
    @FXML
    private void signUpButtonClick(ActionEvent event) throws IOException {
        
            stage = (Stage) signUpButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SignUp.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
    }
    
    private String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

}
