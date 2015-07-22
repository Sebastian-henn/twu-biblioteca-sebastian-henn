package com.twu.biblioteca;


public abstract class Item {
    private boolean available = true;
    private User borrower = null;

    public boolean getAvailable() {
        return available;
    }

    public void checkoutItem(User borrower) {
        this.borrower = borrower;
        available = false;
    }

    public void returnItem() {
        this.borrower = null;
        available = true;
    }

    public User getBorrower() {
        return borrower;
    }

    public abstract String getInformation();

}
