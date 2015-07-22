package com.twu.biblioteca;

import java.util.HashMap;

public class Login {
    IConsole console;
    HashMap<String,User> userList;

    public Login(IConsole console,HashMap<String,User> userList) {
        this.console = console;
        this.userList = userList;
    }

    public String[] getLoginDetails() {
        console.writeOutput("Please enter your Library Number: ");
        String libraryNumber = console.readInput();
        console.writeOutput("Please enter your Password: ");
        String password = console.readInput();
        String[] loginDetails = {libraryNumber,password};
        return loginDetails;
    }

    public boolean isLoginValid(String libraryNumber, String inputPassword) {
        if (userList.containsKey(libraryNumber)) {
            if (userList.get(libraryNumber).authenticatePassword(inputPassword)) {
                console.writeOutput("Log on successful! Welcome, "+userList.get(libraryNumber).getName());
                return true;
            } else {
                console.writeOutput("Password doesn't match a known library number");
                return false;
            }
        } else {
            console.writeOutput("Library number not in database");
            return false;
        }
    }

    public User returnTheUser(String loginLibraryNumber,String loginPassword) {
        if (isLoginValid(loginLibraryNumber,loginPassword)) {
            return userList.get(loginLibraryNumber);
        } else {
            return null;
        }
    }
}
