package com.example.jfxprjct;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashBord implements Initializable {
    ObservableList<Couveuse> couveuseList = FXCollections.observableArrayList();

    @FXML
    private CategoryAxis axeCouv;
   @FXML
    private Button exitaway;
    @FXML
    private CategoryAxis axeCouv1;

    @FXML
    private NumberAxis axeHum;


    @FXML
    private NumberAxis axeTemp;

    @FXML
    private BarChart<String, Number> barChart;
@FXML
    private BarChart<String, Number> barChart1;

   /* public  void getall() {
        try (

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = JavaConnection2DB.getConn().prepareStatement("select * from couveuse  ");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int temperature = rs.getInt("temperature");
                int humidite = rs.getInt("humidite");
                String dateIncuvation = rs.getString("datIncuvation");
                String power = rs.getString("power");
                couveuseList.add(new Couveuse(id, temperature, humidite, dateIncuvation,power));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();

        series.setName("visualiserCouveuse");
        try (

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = JavaConnection2DB.getConn().prepareStatement("select * from couveuse  ");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int temperature = rs.getInt("temperature");
                int humidite = rs.getInt("humidite");
                String dateIncuvation = rs.getString("datIncuvation");
                String power = rs.getString("power");
                couveuseList.add(new Couveuse(id, temperature, humidite, dateIncuvation,power));

                series.getData().add(new XYChart.Data<>(String.valueOf(id),temperature));
                series1.getData().add(new XYChart.Data<>(String.valueOf(id),humidite));

                //series.getData().add(new XYChart.Data<>("desktop2",54));
                //series.getData().add(new XYChart.Data<>("desktop3",24));

            }
            barChart.getData().add(series);
            barChart1.getData().add(series1);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        //


    }

    public void tobackaway(ActionEvent actionEvent) throws IOException {
        HelloApplication m=new HelloApplication();
        m.changeScene("window2_Oeufs_ConnectionCouveuse.fxml");
    }

    public void toexitAway(ActionEvent actionEvent) {
        Stage stage = (Stage) exitaway.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
