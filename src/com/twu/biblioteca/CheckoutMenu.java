package com.twu.biblioteca;

import java.util.HashMap;

public class CheckoutMenu {
    IConsole console;

    public CheckoutMenu(IConsole console) {
        this.console = console;
        console.writeOutput("Please type in the title of the item you wish to check out:");
    }

    public void checkoutItem(HashMap<String,Item> items, String itemTitle) {
        if (items.containsKey(itemTitle)){
            Item current = items.get(itemTitle);
            if (current.getAvailable()) {
                current.checkoutItem();
                console.writeOutput("Thank you! Enjoy the book");
            } else {
                console.writeOutput("Sorry, that book is currently checked out");
            }
        } else {
            console.writeOutput("Sorry, that book doesn't exist in this library");
        }
    }

}
