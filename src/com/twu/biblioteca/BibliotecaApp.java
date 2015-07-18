package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.menuSystem();
    }

    public void printWelcomeMessage() {
        System.out.print(HelperMessages.welcomeMessage);
    }

    public void menuSystem() {
        LibrarySystem lib = new LibrarySystem();
        lib.setupMenu();
    }
}
