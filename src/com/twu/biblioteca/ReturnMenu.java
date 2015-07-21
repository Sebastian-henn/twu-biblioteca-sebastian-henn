package com.twu.biblioteca;

import java.util.HashMap;

public class ReturnMenu {
    IConsole console;

    public ReturnMenu(IConsole console) {
        this.console = console;
        console.writeOutput("Please type in the title of the item you wish to return:");
    }

    public void returnItem(HashMap<String,Item> items, String itemTitle) {
        if (items.containsKey(itemTitle)){
            Item current = items.get(itemTitle);
            if (!current.getAvailable()) {
                current.returnItem();
                console.writeOutput("Thank you for returning the book.");
            } else {
                console.writeOutput("Sorry, that book is currently not checked out");
            }
        } else {
            console.writeOutput("Sorry, that book doesn't exist in this library");
        }
    }



}
