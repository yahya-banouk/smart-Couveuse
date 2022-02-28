package com.example.jfxprjct;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBord implements Initializable {

    @FXML
    private CategoryAxis axeCouv;

    @FXML
    private NumberAxis axeTemp;

    @FXML
    private BarChart<String, Number> barChart;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("visualiserCouveuse");
        series.getData().add(new XYChart.Data<>("desktop",34));
        series.getData().add(new XYChart.Data<>("desktop2",54));
        series.getData().add(new XYChart.Data<>("desktop3",24));
        barChart.getData().add(series);

    }
}
