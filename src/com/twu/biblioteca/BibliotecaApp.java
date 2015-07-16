package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp testApp = new BibliotecaApp();
        testApp.printWelcomeMessage();
    }

    public String printWelcomeMessage() {
        String message = "Welcome to the Bangalore Public Library management system BIBLIOTECA!";
        System.out.println(message);
        return message;
    }
}
