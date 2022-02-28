package com.example.jfxprjct;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
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
import javafx.stage.Stage;
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
    private TextField idCov;
    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<Couveuse, String> dateIncuvationCouv;

    @FXML
    private TableColumn<Object, Number> humiditeCouv;

    @FXML
    private TableColumn<Couveuse, Integer> idCouv;

    @FXML
    private TableView<Couveuse> tableCouv;

    @FXML
    private TableColumn<Object, Number> temperatureCouv;
    @FXML
    private TableColumn<Object, String> powerCouv;


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
                String power = rs.getString("power");
                couveuseList.add(new Couveuse(id, temperature, humidite, dateIncuvation,power));
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
        humiditeCouv.setCellValueFactory(new PropertyValueFactory<Object, Number>("humidite"));
        dateIncuvationCouv.setCellValueFactory(new PropertyValueFactory<>("datIncuvation"));
        powerCouv.setCellValueFactory(new PropertyValueFactory<>("power"));

        dateIncuvationCouv.setCellFactory(TextFieldTableCell.forTableColumn());
        temperatureCouv.setCellFactory(TextFieldTableCell.<Object, Number>forTableColumn(new NumberStringConverter()));
        humiditeCouv.setCellFactory(TextFieldTableCell.<Object, Number>forTableColumn(new NumberStringConverter()));

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
        selectedCouveuseLine.setTemperature((int) Long.parseLong(String.valueOf(couveuseIntegerCellEditEvent.getNewValue())));
        connection =JavaConnection2DB.getConn();

            PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE `couveuse` SET `temperature`= "+selectedCouveuseLine.getTemperature()+" WHERE id like "+selectedCouveuseLine.id+" ;");
            System.out.println(preparedStatement1);
            int i = preparedStatement1.executeUpdate();

    }

    public void changeHumidite(TableColumn.CellEditEvent<Couveuse, Integer> couveuseIntegerCellEditEvent) throws SQLException {
        Couveuse selectedCouveuseLine =tableCouv.getSelectionModel().getSelectedItem();
        selectedCouveuseLine.setHumidite((int) Long.parseLong(String.valueOf(couveuseIntegerCellEditEvent.getNewValue())));
        connection =JavaConnection2DB.getConn();

        PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE `couveuse` SET `humidite`= "+selectedCouveuseLine.getHumidite()+" WHERE id like "+selectedCouveuseLine.id+" ;");
        System.out.println(preparedStatement1);
        int i = preparedStatement1.executeUpdate();


    }

    public void startDown(ActionEvent actionEvent) throws SQLException, IOException {
        Connection connection = JavaConnection2DB.getConn();
        if (idCov.getText()!=null)
        {
            PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from `couveuse` where id like "+idCov.getText());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            if(rs.getInt("count(*)")!= 0)
            {
                System.out.println("feeeeenakhay");
                //
                PreparedStatement preparedStatement0 = connection.prepareStatement("select power from `couveuse` where id like "+Integer.parseInt(idCov.getText()));
                System.out.println(preparedStatement0);

                ResultSet rs1 = preparedStatement0.executeQuery();
                System.out.println("feeeeenakhay1");
                //
                rs1.next();
                    String s = rs1.getString("power");
                    if (s.equals("on")) {
                        PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE `couveuse` SET `power`= 'off' WHERE id like " + Integer.parseInt(idCov.getText()) + " ;");
                        System.out.println(preparedStatement1);
                        int i = preparedStatement1.executeUpdate();
                    } else {
                        PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE `couveuse` SET `power`= 'on' WHERE id like " + Integer.parseInt(idCov.getText() )+ " ;");
                        System.out.println(preparedStatement1);
                        int i = preparedStatement1.executeUpdate();
                    }
                    HelloApplication m = new HelloApplication();
                    m.changeScene("menuCouveuse.fxml");


            }
        }
        else
        {

        }



    }

    public void exit(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
