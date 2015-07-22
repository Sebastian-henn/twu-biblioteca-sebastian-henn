package com.twu.biblioteca;

import java.util.HashMap;

public class CheckoutMenu {
    IConsole console;

    public CheckoutMenu(IConsole console) {
        this.console = console;
        console.writeOutput("Please type in the title of the item you wish to check out:");
    }

    public void checkoutItem(HashMap<String,Item> items, String itemTitle, User borrower) {
        if (items.containsKey(itemTitle)){
            Item current = items.get(itemTitle);
            String itemType = current.getClass().getSimpleName().toLowerCase();
            if (current.getAvailable()) {
                current.checkoutItem(borrower);
                console.writeOutput("Thank you "+borrower.getName()+"! Enjoy the "+itemType);
            } else {
                console.writeOutput("Sorry, that "+itemType+" is currently checked out");
            }
        } else {
            console.writeOutput("Sorry, that item doesn't exist in this library");
        }
    }

}
