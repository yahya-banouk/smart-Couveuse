package com.example.jfxprjct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class AfterLogin {
    @FXML
    private Button logout;

    public void userLogOut() throws IOException {

        HelloApplication m = new   HelloApplication();

        m.changeScene("hello-view.fxml");


    }
}
