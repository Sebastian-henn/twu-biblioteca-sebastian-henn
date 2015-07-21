package com.twu.biblioteca;

public class FakeConsole implements IConsole {
    StringBuilder output = new StringBuilder();
    String input = "";

    public void writeOutput(String output) {
        this.output.append(output);
    }
    public String readInput() {
        return input;
    }

    public String getOutput() {
        return output.toString();
    }
}
