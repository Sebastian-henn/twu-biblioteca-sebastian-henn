package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class FakeConsole implements IConsole {
    StringBuilder output = new StringBuilder();
    List<String> inputList = new ArrayList<String>();
    String input;
    int position = 0;
    String typeOfTest;

    public FakeConsole() {
        typeOfTest = "unit";
    }

    public FakeConsole(String type) {
        typeOfTest = type;
    }

    public void writeOutput(String output) {
        if (typeOfTest.equals("acceptance test"))
            System.out.println(output);
        this.output.append(output);
    }
    public String readInput() {
        if (typeOfTest.equals("acceptance test")) {
            if (position > inputList.size() - 1) {
                System.out.println("ERROR, NOT ENOUGH COMMANDS!!!");
                System.exit(0);
                return "";
            } else {
                System.out.println("--> " + inputList.get(position));
                return inputList.get(position++);
            }
        } else {
            return input;
        }
    }

    public String getOutput() {
        return output.toString();
    }

    public void setupInputCommand(String command) {
        inputList.add(command);
    }
}