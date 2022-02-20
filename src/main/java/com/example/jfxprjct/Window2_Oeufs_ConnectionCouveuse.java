package com.example.jfxprjct;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Window2_Oeufs_ConnectionCouveuse {
    int a =1;
    @FXML
    private Button logoutButton;
    @FXML
    private Button couveuseTabButton ;

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
            PaneInfo.setVisible(true);
            a--;
        }
        else
        {
            PaneInfo.setVisible(false);
            a++;
        }

    }

}
