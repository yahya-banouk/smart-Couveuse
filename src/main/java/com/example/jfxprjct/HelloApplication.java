package com.example.jfxprjct;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    private static Stage stg ;
    public static int sizeh=400/*550*/;
    public static int sizew=600/*900*/;

    @Override
    public void start(Stage stage) throws IOException {

            stg = stage;

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setResizable(false);

            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Manager-Login");
            stage.setScene(scene);
            stage.show();

    }
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));

        stg.getScene().setRoot(pane);

    }

    public static void main(String[] args) {
        launch();
    }
}
