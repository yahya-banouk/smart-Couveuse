package com.example.jfxprjct;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;


import java.io.IOException;
import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;

public class Login {
    private String usernam;
    private String passwor;

    @FXML
    private Button button ;
    @FXML
    private Label wronglogin ;
    @FXML

    private TextField username ;
    @FXML
    private PasswordField password;
    public void userlogin(ActionEvent event) throws IOException, SQLException, InterruptedException {
        checkLogin();
    }
    private void checkLogin() throws IOException, SQLException, InterruptedException {
        HelloApplication m = new   HelloApplication();
        Connection connection = JavaConnection2DB.getConn();

        Statement stm = connection.createStatement();
        //Statement stmt = BDSingleton.getConn().createStatement();
        ResultSet rs = stm.executeQuery("select username , password from auth ");
        //ResultSet rs = stmt.executeQuery("select * from admin where username like '"+username+"' and password like '"+password+"'");

        while (rs.next())
        {
            usernam = rs.getString("username");
            passwor = rs.getString("password");


        }
        rs.close();
        stm.close();
        if(usernam.isEmpty() || passwor.isEmpty()){
            usernam = "yaaay";
            passwor = "yaaay";
        }




        if (username.getText().toString().equals(usernam) && password.getText().toString().equals(passwor))
        {
            wronglogin.setText("success");
            //Thread.sleep(5000);
            m.changeScene("window2_Oeufs_ConnectionCouveuse.fxml");
        }
        else if (username.getText().isEmpty() && password.getText().isEmpty())
        {
            wronglogin.setText("Please enter your information's");
        }
        else
        {
            wronglogin.setText("wrong password or username");

        }

    }


}
