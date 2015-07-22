package com.twu.biblioteca;

import java.util.HashMap;

public class MainMenu {
    IConsole console;
    User user;
    Library lib = new Library();

    public MainMenu(IConsole console, User user) {
        this.console = console;
        this.user = user;
    }

    public void welcomeMessage() {
        console.writeOutput("Welcome to the Bangalore Public Library management system BIBLIOTECA!");
    }

    public void printMenu() {
        console.writeOutput("This is the main menu. Please select one of the following:");
        console.writeOutput("[1] - List Items in Library");
        console.writeOutput("[2] - Checkout an Item");
        console.writeOutput("[3] - Return an Item");
        console.writeOutput("[4] - Print user information");
        console.writeOutput("[0] - Quit");
    }

    public void run() {
        int selection = -1;
        while (selection != 0) {
            this.printMenu();
            try {
                selection = Integer.parseInt(console.readInput());
                this.doMenu(selection);
            } catch (NumberFormatException e) {
                console.writeOutput("Please enter either [1],[2],[3], [4] or [0]");
            }
        }
    }

    public String printAvailableItems(Library library, String itemType) {
        HashMap<String,Item> availableItems = library.getAvailableItems(itemType);
        String message;
        if (availableItems.isEmpty()) {
            message = "\nNo "+itemType+"s Available";
        } else {
            message = "\n"+itemType+"s Available:";
        }
        for (HashMap.Entry<String,Item> item : availableItems.entrySet()) {
            message += "\n"+item.getValue().getInformation();
        }
        return message;
    }

    public void doMenu(int input) {
        switch (input) {
            case 1:
                console.writeOutput(printAvailableItems(lib, "Book"));
                console.writeOutput(printAvailableItems(lib, "Movie"));
                break;
            case 2:
                CheckoutMenu checkoutMenu = new CheckoutMenu(console);
                checkoutMenu.checkoutItem(lib.getLibrary(),console.readInput(),user);
                break;
            case 3:
                ReturnMenu returnMenu = new ReturnMenu(console);
                returnMenu.returnItem(lib.getLibrary(),console.readInput(),user);
                break;
            case 4:
                console.writeOutput(user.getUserInformation());
                break;
            case 0:
                //quit
                break;
            default:
                console.writeOutput("Please enter either [1],[2],[3], [4] or [0]");
        }
    }
}
