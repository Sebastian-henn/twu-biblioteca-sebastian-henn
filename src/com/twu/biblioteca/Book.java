package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book(String t, String a, int y) {
        title = t;
        author = a;
        year = y;
        available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean getAvailability() {
        return available;
    }

    public void setAvailable(boolean a) {
        available = a;
    }
}
