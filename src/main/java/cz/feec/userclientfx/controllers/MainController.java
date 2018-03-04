package cz.feec.userclientfx.controllers;

import cz.feec.userclientfx.LoginUser;
import cz.feec.userclientfx.Tester;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController implements Initializable {

    private LoginUser loginUser;

    @FXML
    private Label loginUserLabel;

    @FXML
    private Label workPositionLabel;

    @FXML
    private Button buttonTest;

    @FXML
    private LineChart<Double, Double> lineChart;

    @FXML
    private Button logoutButton;

    @FXML
    private void handleButtonTestAction(ActionEvent event) {

        lineChart.getData().clear();
        Tester tester = new Tester(loginUser.getId());

        drawData(tester.testByPost(), "POST");
        drawData(tester.testByGet(), "GET");

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
        }else{
            System.out.println("Je to Null");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginUser = LoginUser.getLoginUser();
        loginUserLabel.setText(loginUser.getEmail());
        workPositionLabel.setText(loginUser.getWorkPosition());
        
    }
}
