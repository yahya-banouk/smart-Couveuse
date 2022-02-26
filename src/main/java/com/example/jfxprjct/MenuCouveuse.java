package com.example.jfxprjct;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.scene.control.TableView;

public class MenuCouveuse implements Initializable {
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Couveuse couveuse = null;


    ObservableList<Couveuse> couveuseList = FXCollections.observableArrayList();

    @FXML
    private Button BackWindow2Button;

    @FXML
    private TableColumn<Couveuse, Date> dateIncuvationCouv;

    @FXML
    private TableColumn<Couveuse,Integer > humiditeCouv;

    @FXML
    private TableColumn<Couveuse, String> idCouv;

    @FXML
    private TableView<Couveuse> tableCouv;

    @FXML
    private TableColumn<Couveuse, Integer> temperatureCouv;

    @FXML
    private ImageView updateCouv;

    @FXML
    void BackWindow2(ActionEvent event) {


    }

    @FXML
    void updateCouvMethode(MouseEvent event) {

    }




    public void BackWindow2() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("window2_Oeufs_ConnectionCouveuse.fxml");
    }
    ObservableList<Couveuse> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        connection= JavaConnection2DB.getConn();
        idCouv.setCellValueFactory(new PropertyValueFactory<>("id"));
        temperatureCouv.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        humiditeCouv.setCellValueFactory(new PropertyValueFactory<>("humidite"));
        dateIncuvationCouv.setCellValueFactory(new PropertyValueFactory<>("datIncuvation"));

        //oblist.addAll(DAOFactory.getPatientDAO().all());

        tableCouv.setItems(oblist);
    }
}
