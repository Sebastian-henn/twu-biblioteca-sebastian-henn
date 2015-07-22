package com.twu.biblioteca;

import java.util.HashMap;


public class Library {

    public HashMap<String,Item> library = new HashMap<String, Item>();

    public Library() {
        library.put("One Hundred Years of Solitude",new Book("One Hundred Years of Solitude","Gabriel Garcia Marquez",1970));
        library.put("Musicophilia",new Book("Musicophilia","Oliver Sacks",2006));
        library.put("The Tao of Physics",new Book("The Tao of Physics","Fritjof Capra",1976));
        library.put("Nature's Blueprint",new Book("Nature's Blueprint","Dan Hooper",2008));
        library.put("The Matrix",new Movie("The Matrix",1999,"The Wachowskis",9));
    }

    public HashMap<String,Item> getLibrary() {
        return library;
    }

    public HashMap<String,Item> getAvailableItems(String itemType)
    {
        HashMap<String,Item> availableItems = new HashMap<String,Item>();
        for (HashMap.Entry<String,Item> item : library.entrySet()) {
            if (item.getValue().getAvailable() && item.getValue().getClass().getSimpleName().equals(itemType)) {
                availableItems.put(item.getKey(),item.getValue());
            }
        }
        return availableItems;
    }

    public HashMap<String,Item> getCheckedOutItems()
    {
        HashMap<String,Item> checkedOutItems = new HashMap<String,Item>();
        for (HashMap.Entry<String,Item> item : library.entrySet()) {
            if (!item.getValue().getAvailable()) {
                checkedOutItems.put(item.getKey(),item.getValue());
            }
        }
        return checkedOutItems;
    }
}
