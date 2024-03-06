package com.example.keytyper.Views;

import com.example.keytyper.Controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/example/keytyper/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        stage.setTitle("monkeyType");
        stage.setScene(scene);
        ((Controller) fxmlLoader.getController()).setScene(scene);
        ((Controller) fxmlLoader.getController()).setupUI();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}