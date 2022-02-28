package com.example.jfxprjct;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Window2_Oeufs_ConnectionCouveuse {
    int a =1;
    @FXML
    private Button logoutButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button couveuseTabButton ;
    @FXML
    private Button dachboardButton ;

    @FXML
    private Button InfoCouveuse;
    @FXML
    private Pane PaneInfo;

    public void allerAuCouveuse() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("menuCouveuse.fxml");

    }

    public void logOuting() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("hello-view.fxml");
    }
    public void seeInfo() throws IOException
    {
        if(a==1)
        {
            couveuseTabButton.setVisible(false);
            PaneInfo.setVisible(true);

            a--;
        }
        else
        {
            PaneInfo.setVisible(false);
            couveuseTabButton.setVisible(true);
            a++;
        }

    }

    public void allerAuDachBoard() throws IOException {
        HelloApplication  m1 = new HelloApplication();
        m1.changeScene("dashbord.fxml");

    }

    public void exitMethode() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
