package com.example.keytyper.Models;

import com.example.keytyper.Controllers.Controller;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class TimerModel implements Runnable{
    private Label label;

    private int seconds;

    private Controller controller;

    private MistakesGraphModel mistakesGraphModel;

    @Override
    public void run() {
        for (int i = seconds; i >=0 ; i--) {

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            int mistakesCounter =  controller.getMistakesCounter();
            int latestTime = i;

            Platform.runLater(()->{
                label.setText(String.valueOf(latestTime));
                mistakesGraphModel.setPointsToGraph(latestTime,mistakesCounter);
            });
        }Platform.runLater(controller::showMistakesGraphic);

    }
    public MistakesGraphModel getMistakesGraphModel(){
        return mistakesGraphModel;
    }

    public void setParameters(Label label,int seconds,Controller controller, MistakesGraphModel mistakesGraphModel){
      this.label=label;
      this.seconds=seconds;
      this.controller=controller;
      this.mistakesGraphModel=mistakesGraphModel;
    }
}
