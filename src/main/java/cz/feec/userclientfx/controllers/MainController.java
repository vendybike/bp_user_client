package cz.feec.userclientfx.controllers;

import cz.feec.userclientfx.LoginUser;
import cz.feec.userclientfx.RestTester;
import cz.feec.userclientfx.SoapTester;
import cz.feec.userserver.soap.ResourceExceptions_Exception;
import cz.feec.userserver.soap.ResourceNotFoundException_Exception;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController implements Initializable {

    private LoginUser loginUser;

    @FXML
    private Label loginUserLabel;

    @FXML
    private Button buttonTest;

    @FXML
    private LineChart<Double, Double> lineChart;

    @FXML
    private Button logoutButton;

    @FXML
    private ComboBox comboBox;

    @FXML
    private void handleButtonTestAction(ActionEvent event) throws ResourceNotFoundException_Exception {

        lineChart.getData().clear();
        RestTester restTester = new RestTester(loginUser.getId());
        SoapTester soapTester = new SoapTester(loginUser.getId());
        try {
            if (comboBox.getSelectionModel().getSelectedItem().toString() == "GET") {
                drawData(restTester.testByGet(), "REST");
                drawData(soapTester.testByGet(), "SOAP");
            } else if (comboBox.getSelectionModel().getSelectedItem().toString() == "POST") {
                drawData(restTester.testByPost(), "REST");
                drawData(soapTester.testByPost(), "SOAP");
            }
        } catch (NullPointerException e) {
            Alert errorMesage = new Alert(Alert.AlertType.ERROR);
            errorMesage.setContentText("Vyberte METODU pro měření");
            errorMesage.show();
        }

    }

    @FXML
    private void buttonLogoutClick(ActionEvent event) throws IOException {
        loginUser.logoutUser();
        if (LoginUser.getLoginUser() == null) {
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
        }
    }

    private void drawData(List<Double> timesTestedData, String dataNeme) {
        if (timesTestedData != null) {
            int dates = timesTestedData.size();
            XYChart.Series<Double, Double> series1 = new XYChart.Series<Double, Double>();
            series1.setName(dataNeme);

            series1.getData().add(new XYChart.Data("0", timesTestedData.get(0)));
            series1.getData().add(new XYChart.Data("3", timesTestedData.get(4)));
            series1.getData().add(new XYChart.Data("5", timesTestedData.get(7)));
            series1.getData().add(new XYChart.Data("10", timesTestedData.get(9)));
            lineChart.getData().add(series1);
        } else {
            System.out.println("Je to Null");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginUser = LoginUser.getLoginUser();
        loginUserLabel.setText(loginUser.getEmail());

        comboBox.getItems().addAll(
                "GET",
                "POST"
        );
    }
}
