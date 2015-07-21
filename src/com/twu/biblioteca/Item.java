package com.twu.biblioteca;


public abstract class Item {
    private boolean available = true;

    public boolean getAvailable() {
        return available;
    }

    public void checkoutItem() {
        available = false;
    }

    public void returnItem() {
        available = true;
    }

    public abstract String getInformation();

}
