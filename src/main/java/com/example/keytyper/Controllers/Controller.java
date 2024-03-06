package com.example.keytyper.Controllers;

import com.example.keytyper.Models.MistakesGraphModel;
import com.example.keytyper.Models.MistakesParameters;
import com.example.keytyper.Models.TimerModel;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Controller{
    private static final String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. ";

    private final TimerModel timerModel = new TimerModel();

    @FXML
    private TextFlow text;

    @FXML
    private Label timersLabel = new Label();

    @FXML
    private Button timerStartButton = new Button();

    private Scene scene;

    private int i = 0;

    private boolean isTimeStarted;

    private int mistakesCounter;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setupUI(){
        isTimeStarted = false;

        for (char c:str.toCharArray()) {
            Text newText = new Text(String.valueOf(c));
            newText.setFill(Color.GRAY);
            text.getChildren().add(newText);
        }
        scene.addEventFilter(KeyEvent.KEY_PRESSED, this::onKeyTyped);
    }

    public void onKeyTyped(KeyEvent keyEvent) {
        if (isTimeStarted){
            String inputedText = keyEvent.getText();

            if(!inputedText.isEmpty()){
                char currentChar = str.charAt(i);
                char inputedChar = keyEvent.isShiftDown() ? keyEvent.getText().toUpperCase().charAt(0): keyEvent.getText().charAt(0);

                Color currentColor;
                if (inputedChar==currentChar){
                    currentColor=Color.rgb(30,20,22);
                }else {
                    currentColor=Color.RED;
                    mistakesCounter++;
                }

                ((Text) text.getChildren().get(i)).setText(String.valueOf(inputedChar));
                ((Text) text.getChildren().get(i)).setFill(currentColor);

                i++;
            }
        }
    }

    public void buttonStartClick(){
        isTimeStarted = true;
        timerStartButton.setDisable(true);
        timerModel.setParameters(timersLabel,30, this, new MistakesGraphModel());

        Thread thread1 = new Thread(timerModel);
        thread1.start();
    }

    public void showMistakesGraphic(){
        MistakesGraphModel mistakesGraphModel = timerModel.getMistakesGraphModel();
        ArrayList<MistakesParameters> mistakesParametersArrayList = mistakesGraphModel.getGraphPointsArray();

        Stage stage = new Stage();
        stage.setTitle("Mistake's graphic");

        final NumberAxis numberAxisX = new NumberAxis();
        final NumberAxis numberAxisY = new NumberAxis();

        numberAxisX.setLabel("Seconds");
        final LineChart<Number,Number> mistakesGraph = new LineChart<>(numberAxisX,numberAxisY);
        mistakesGraph.setTitle("Graphic of Mistakes");

        XYChart.Series series=new XYChart.Series();
        series.setName("Overlook");

        for (MistakesParameters mist:
                mistakesParametersArrayList) {
            series.getData().add(new XYChart.Data(mist.getNumberOfSecond(), mist.getMistakesCounter()));
        }

        Scene scene = new Scene(mistakesGraph,800,600);
        mistakesGraph.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public int getMistakesCounter(){
        return mistakesCounter;
    }
}