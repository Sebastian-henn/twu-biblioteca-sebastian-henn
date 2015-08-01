package com.twu.biblioteca;

import java.util.HashMap;

public class PrintAvailableItemsMenu implements MenuOption {
    IConsole console;
    Library lib;

    public PrintAvailableItemsMenu(IConsole console, Library lib) {
        this.console = console;
        this.lib = lib;
    }

    public String printAvailableItems(Library library, String itemType) {
        HashMap<String,Item> availableItems = library.getAvailableItems(itemType);
        String message;
        if (availableItems.isEmpty()) {
            message = "No "+itemType+"s Available";
        } else {
            message = itemType+"s Available:";
        }
        for (HashMap.Entry<String,Item> item : availableItems.entrySet()) {
            message += "\n   "+item.getValue().getInformation();
        }
        return message;
    }

    public void runOption() {
        console.writeOutput("These are the list of items available for checkout:");
        console.writeOutput(printAvailableItems(lib, "Book"));
        console.writeOutput(printAvailableItems(lib, "Movie"));
    }

    public String getNameOfOption() {
        return "List Items in Library";
    }
}
