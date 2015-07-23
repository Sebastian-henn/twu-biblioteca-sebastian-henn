package com.twu.biblioteca;

import java.util.HashMap;

public class MainMenu {
    IConsole console;
    User user;
    HashMap<Integer,MenuOption> menuOptions = new HashMap<Integer, MenuOption>();
    Library lib = new Library();

    public MainMenu(IConsole console, User user) {
        this.console = console;
        this.user = user;
        menuOptions.put(1,new PrintAvailableItemsMenu(console,lib));
        menuOptions.put(2,new CheckoutMenu(console,lib,user));
        menuOptions.put(3,new ReturnMenu(console,lib,user));
        menuOptions.put(4, new PrintUserDetailsMenu(console, user));
    }

    public void welcomeMessage() {
        console.writeOutput("\nWelcome to the Bangalore Public Library management system BIBLIOTECA!");
    }

    public void printMenu() {
        console.writeOutput("\nThis is the main menu. Please select one of the following:");
        String menuText = "";
        for (HashMap.Entry<Integer,MenuOption> option : menuOptions.entrySet()) {
            menuText += "["+option.getKey()+"] - "+option.getValue().getNameOfOption()+"\n";
        }
        menuText += "[0] - Quit";
        console.writeOutput(menuText);
    }

    public void run() {
        int selection = -1;
        while (selection != 0) {
            this.printMenu();
            try {
                selection = Integer.parseInt(console.readInput());
                menu(selection);
            } catch (NumberFormatException e) {
                console.writeOutput("Please enter either [1],[2],[3], [4] or [0]");
            }
        }
    }

    public void menu(int input) {


        if (input == 0) {
            console.writeOutput("Thankyou and goodbye!");
        } else {
            menuOptions.get(input).runOption();
        }
    }

}
