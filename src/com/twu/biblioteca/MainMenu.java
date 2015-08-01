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
        menuOptions.put(0,new QuitMenu(console,user));
    }

    public void welcomeMessage() {
        console.writeOutput("Welcome to the Bangalore Public Library management system BIBLIOTECA!");
    }

    public void printMenu() {
        console.writeOutput("This is the main menu. Please select one of the following:");
        String menuText = "";
        for (HashMap.Entry<Integer,MenuOption> option : menuOptions.entrySet()) {
            menuText += "["+option.getKey()+"] - "+option.getValue().getNameOfOption()+"\n";
        }
        console.writeOutput(menuText.trim());
    }

    public void run() {
        int selection = -1;
        while (selection != 0) {
            this.printMenu();
            try {
                selection = Integer.parseInt(console.readInput());
                menu(selection);
            } catch (NumberFormatException e) {
                String keys = "";
                for (HashMap.Entry<Integer,MenuOption> option : menuOptions.entrySet()) {
                    keys += "["+option.getKey()+"] ";
                }
                console.writeOutput("Please enter one of the following: "+keys);
            }
        }
    }

    public void menu(int input) {
        menuOptions.get(input).runOption();
    }
}
