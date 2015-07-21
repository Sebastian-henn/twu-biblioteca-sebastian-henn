package com.twu.biblioteca;

public class BibliotecaApp {

    static Console console = new Console();
    static MainMenu menu = new MainMenu(console);

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        menu.welcomeMessage();
        menu.run();
    }
}
