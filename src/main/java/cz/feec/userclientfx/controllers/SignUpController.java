/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.feec.userclientfx.controllers;

import cz.feec.userclientfx.entity.User;
import cz.feec.userclientfx.exceptions.ResourceExceptions;
import cz.feec.userclientfx.rest.UserRestApi;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vendy
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField workPositionField;
    @FXML
    private TextField coutryField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField regionField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField houseNumberField;
    @FXML
    private Button signUpButton;
    @FXML
    private Button backButton;

    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void signUpButtonClick(ActionEvent event) throws IOException, ResourceExceptions {
        if (signUp()) {
            stage = (Stage) signUpButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
        }
    }

    @FXML
    private void backButtonClick(ActionEvent event) throws IOException {
        stage = (Stage) signUpButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private boolean signUp() throws ResourceExceptions {
        User user;
        if (emailField.getText() != null && passwordField.getText() != null && ageField.getText() != null && workPositionField != null) {
            user = new User();
            user.setEmail(emailField.getText());
            user.setAge(25);
            user.setPassword(passwordField.getText());
            user.setWorkPosition(workPositionField.getText());
            System.out.println("uživatel naplněn");
            //if (coutryField.getText() != null || cityField.getText() != null || regionField.getText() != null || streetField.getText() != null || houseNumberField.getText() != null) {
            // if (coutryField.getText() != null && cityField.getText() != null && streetField.getText() != null && houseNumberField.getText() != null) {
            //     Address address = new Address();
            //     address.setCountry(coutryField.getText());
            //     address.setCity(cityField.getText());
            //    address.setStreet(streetField.getText());
            //    if (regionField.getText() != null) {
            //        address.setRegion(regionField.getText());
            //    }
            //     address.setHouseNumber(Integer.parseInt(houseNumberField.getText()));
            //     user.setAddress(address);
            //  }
            //}
        } else {
            return false;
        }
        if (user != null) {
            UserRestApi rest = UserRestApi.getRest();
            try {
                if (rest.postUser(user) == 200) {
                    return true;
                }
            } catch (ResourceExceptions.EmailAlreadyExistException e) {
                errorNotification("Email: " + emailField.getText() + " již existuje");
            } catch (ResourceExceptions.BadRequestException e) {
                errorNotification("Špatně zadaný tvar emailu");
            } catch (ResourceExceptions.BadConnectionException e) {
                errorNotification("Nelze se spojit se serverem");
            }
        }
        return false;
    }

    private void errorNotification(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(text);
        alert.show();
    }

}
