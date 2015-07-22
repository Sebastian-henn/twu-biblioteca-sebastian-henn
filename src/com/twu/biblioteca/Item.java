package com.twu.biblioteca;


public abstract class Item {
    private boolean available = true;
    private User borrower = null;

    public boolean getAvailable() {
        return available;
    }

    public void checkoutItem() {
        available = false;
    }

    public void returnItem() {
        available = true;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public User getBorrower() {
        return borrower;
    }

    public abstract String getInformation();

}
