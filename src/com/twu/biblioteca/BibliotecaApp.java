package com.twu.biblioteca;

import java.util.HashMap;

public class BibliotecaApp {

    static Console console = new Console();
    static HashMap<String,User> userList = new HashMap<String, User>();

    public static void main(String[] args) {
        User testUser = new User();
        userList.put(testUser.getLibraryNumber(),testUser);

        Login login = new Login(console,userList);
        User currentUser = null;

        while (currentUser == null) {
            String[] input = login.getLoginDetails();
            currentUser = login.returnTheUser(input[0],input[1]);
        }

        MainMenu menu = new MainMenu(console,currentUser);
        menu.welcomeMessage();
        menu.run();
    }
}
