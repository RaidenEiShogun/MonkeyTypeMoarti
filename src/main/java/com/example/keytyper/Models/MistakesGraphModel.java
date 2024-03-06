package com.example.keytyper.Models;

import java.util.ArrayList;

public class MistakesGraphModel extends BaseModel{
    private ArrayList<MistakesParameters> mistakes = new ArrayList<>();

    public ArrayList<MistakesParameters> getGraphPointsArray(){return mistakes;}

    @Override
    public void setPointsToGraph(int numberOfSeconds, int mistakesCounter){
        MistakesParameters mistakesParameters = new MistakesParameters(mistakesCounter,numberOfSeconds);
        mistakes.add(mistakesParameters);
    }
}
