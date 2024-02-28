package com.example.keytyper.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller{
    private static final String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. ";

    @FXML
    public TextFlow text;

    @FXML
    public javafx.scene.layout.VBox VBox;

    private Scene scene;

    private int i = -1;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setupUI(){
        for (char c:str.toCharArray()) {
            Text newText = new Text(String.valueOf(c));
            newText.setFill(Color.GRAY);
            text.getChildren().add(newText);
        }
        scene.addEventFilter(KeyEvent.KEY_PRESSED, this::onKeyTyped);
    }

    public void onKeyTyped(KeyEvent keyEvent) {
        i++;
        ((Text) text.getChildren().get(i)).setText(keyEvent.getText());
        ((Text) text.getChildren().get(i)).setFill(Color.BLACK);
    }
}