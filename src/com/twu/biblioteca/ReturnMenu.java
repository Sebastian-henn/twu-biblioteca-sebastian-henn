package com.twu.biblioteca;

import java.util.HashMap;

public class ReturnMenu implements MenuOption {
    IConsole console;
    Library lib;
    User user;

    public ReturnMenu(IConsole console,Library lib,User user) {
        this.console = console;
        this.lib = lib;
        this.user = user;
    }

    public void returnItem(HashMap<String,Item> items, String itemTitle,User borrower) {
        if (items.containsKey(itemTitle)){
            Item current = items.get(itemTitle);
            String itemType = current.getClass().getSimpleName().toLowerCase();
            if (!current.getAvailable()) {
                current.returnItem();
                console.writeOutput("Thank you for returning the " + itemType + ", " + borrower.getName());
            } else {
                console.writeOutput("Sorry, that "+itemType+" is currently not checked out");
            }
        } else {
            console.writeOutput("Sorry, that item doesn't exist in this library");
        }
    }

    public void runOption() {
        console.writeOutput("Please type in the title of the item you wish to return:");
        returnItem(lib.getLibrary(), console.readInput(), user);
    }

    public String getNameOfOption() {
        return "Return an Item";
    }
}
