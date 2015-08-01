package com.twu.biblioteca;

public class ReturnMenu implements MenuOption {
    IConsole console;
    Library lib;
    User user;

    public ReturnMenu(IConsole console,Library lib,User user) {
        this.console = console;
        this.lib = lib;
        this.user = user;
    }

    public void runOption() {
        console.writeOutput("Please type in the title of the item you wish to return:");
        lib.returnAnItem(console, console.readInput(), user);
    }

    public String getNameOfOption() {
        return "Return an Item";
    }
}
