package com.twu.biblioteca;

public class CheckoutMenu implements MenuOption {
    IConsole console;
    Library lib;
    User user;

    public CheckoutMenu(IConsole console,Library lib,User user) {
        this.console = console;
        this.lib = lib;
        this.user = user;
    }

    public void runOption() {
        console.writeOutput("Please type in the title of the item you wish to check out:");
        lib.checkoutAnItem(console, console.readInput(), user);
    }

    public String getNameOfOption() {
        return "Checkout an Item";
    }
}
