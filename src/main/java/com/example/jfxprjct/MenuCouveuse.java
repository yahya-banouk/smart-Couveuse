package com.example.jfxprjct;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.scene.control.TableView;
import javafx.util.converter.NumberStringConverter;

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
    private TableColumn<Couveuse, String> dateIncuvationCouv;

    @FXML
    private TableColumn<Couveuse,Integer > humiditeCouv;

    @FXML
    private TableColumn<Couveuse, Integer> idCouv;

    @FXML
    private TableView<Couveuse> tableCouv;

    @FXML
    private TableColumn<Object, Number> temperatureCouv;

    @FXML
    private ImageView updateCouv;

    @FXML
    void BackWindow2(ActionEvent event) throws IOException {
        HelloApplication m = new  HelloApplication();
        m.changeScene("window2_Oeufs_ConnectionCouveuse.fxml");



    }
    @FXML
    void updateCouvMethode() {}
    @FXML
    public  void getall() {
        try (

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("select * from couveuse  ");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int temperature = rs.getInt("temperature");
                int humidite = rs.getInt("humidite");
                String dateIncuvation = rs.getString("datIncuvation");
                couveuseList.add(new Couveuse(id, temperature, humidite, dateIncuvation));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }






    public void BackWindow2() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("window2_Oeufs_ConnectionCouveuse.fxml");
    }
    ObservableList<Couveuse> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        connection= JavaConnection2DB.getConn();
        getall();
        idCouv.setCellValueFactory(new PropertyValueFactory<>("id"));
        temperatureCouv.setCellValueFactory(new PropertyValueFactory<Object, Number>("temperature"));
        humiditeCouv.setCellValueFactory(new PropertyValueFactory<>("humidite"));
        dateIncuvationCouv.setCellValueFactory(new PropertyValueFactory<>("datIncuvation"));

        dateIncuvationCouv.setCellFactory(TextFieldTableCell.forTableColumn());
        temperatureCouv.setCellFactory(TextFieldTableCell.<Object, Number>forTableColumn(new NumberStringConverter()));

        //oblist.addAll(DAOFactory.getPatientDAO().all());

        tableCouv.setItems(couveuseList);
    }

    public void changeDateIncuvation(TableColumn.CellEditEvent<Couveuse, String> couveuseStringCellEditEvent) throws SQLException {
        Couveuse selectedCouveuseLine =tableCouv.getSelectionModel().getSelectedItem();
        selectedCouveuseLine.setDatIncuvation(couveuseStringCellEditEvent.getNewValue().toString());
        connection =JavaConnection2DB.getConn();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from couveuse where id like "+selectedCouveuseLine.getId()+" ;");

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE `couveuse` SET `datIncuvation`= '"+selectedCouveuseLine.getDatIncuvation().toString()+"' WHERE id like "+selectedCouveuseLine.id+" ;");
                System.out.println(preparedStatement1);
                int i = preparedStatement1.executeUpdate();
            }

    }

    public void changeTemperature(TableColumn.CellEditEvent<Couveuse, Integer> couveuseIntegerCellEditEvent) throws SQLException {
        Couveuse selectedCouveuseLine =tableCouv.getSelectionModel().getSelectedItem();
        selectedCouveuseLine.setDatIncuvation(couveuseIntegerCellEditEvent.getNewValue().toString());
        connection =JavaConnection2DB.getConn();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from couveuse where id like "+selectedCouveuseLine.getId()+" ;");

        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next())
        {
            PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE `couveuse` SET `temperature`= "+selectedCouveuseLine.getTemperature()+" WHERE id like "+selectedCouveuseLine.id+" ;");
            System.out.println(preparedStatement1);
            int i = preparedStatement1.executeUpdate();
        }
    }

    public void changeHumidite(TableColumn.CellEditEvent<Couveuse, Integer> couveuseIntegerCellEditEvent) {
    }
}
