package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console implements IConsole {
    PrintStream output;
    InputStream input;


    public Console() {
        output = System.out;
        input = System.in;
    }

    public void writeOutput(String stringToPrint) {
        output.println(stringToPrint);
    }

    public String readInput() {
        Scanner sc = new Scanner(input);
        return sc.nextLine();
    }
}
