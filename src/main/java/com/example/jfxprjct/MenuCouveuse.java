package com.example.jfxprjct;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MenuCouveuse {
    @FXML
    private Button BackWindow2Button;
    public void BackWindow2() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("window2_Oeufs_ConnectionCouveuse.fxml");
    }
}
