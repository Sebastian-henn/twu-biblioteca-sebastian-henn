package com.twu.biblioteca;

import java.util.HashMap;

public class CheckoutMenu implements MenuOption {
    IConsole console;
    Library lib;
    User user;

    public CheckoutMenu(IConsole console,Library lib,User user) {
        this.console = console;
        this.lib = lib;
        this.user = user;
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

    public void runOption() {
        console.writeOutput("Please type in the title of the item you wish to check out:");
        checkoutItem(lib.getLibrary(),console.readInput(),user);
    }

    public String getNameOfOption() {
        return "Checkout an Item";
    }
}
