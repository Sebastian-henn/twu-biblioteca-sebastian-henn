package com.twu.biblioteca;


import java.util.HashMap;

public class MainMenu {
    IConsole console;
    Library lib = new Library();

    public MainMenu(IConsole console) {
        this.console = console;
    }

    public void welcomeMessage() {
        console.writeOutput(HelperMessages.welcomeMessage);
    }

    public void printMenu() {
        console.writeOutput(HelperMessages.menuScreen);
    }

    public void run() {
        int selection = -1;
        while (selection != 0) {
            this.printMenu();
            try {
                selection = Integer.parseInt(console.readInput());
                this.doMenu(selection);
            } catch (NumberFormatException e) {
                console.writeOutput(HelperMessages.invalidInput);
            }
        }
    }

    public void printAvailableItems() {
        HashMap<String,Item> availableItems = lib.getAvailableItems();
        for (HashMap.Entry<String,Item> item : availableItems.entrySet()) {
            console.writeOutput(item.getValue().getInformation());
        }
    }

    public void doMenu(int input) {
        switch (input) {
            case 1:
                this.printAvailableItems();
                break;
            case 2:
                CheckoutMenu checkoutMenu = new CheckoutMenu(console);
                checkoutMenu.checkoutItem(lib.getLibrary(),console.readInput());
                break;
            case 3:
                ReturnMenu returnMenu = new ReturnMenu(console);
                returnMenu.returnItem(lib.getLibrary(),console.readInput());
                break;
            case 0:
                //quit
                break;
            default:
                console.writeOutput(HelperMessages.invalidInput);
        }
    }
}
