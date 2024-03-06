package com.example.keytyper.Models;

public class MistakesParameters {
    private final int mistakesCounter;
    private final int numberOfSecond;

    public MistakesParameters(int mistakesCounter, int numberOfSecond) {
        this.mistakesCounter = mistakesCounter;
        this.numberOfSecond = numberOfSecond;
    }

    public int getMistakesCounter() {
        return mistakesCounter;
    }

    public int getNumberOfSecond() {
        return numberOfSecond;
    }
}
