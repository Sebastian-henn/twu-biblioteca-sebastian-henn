package com.twu.biblioteca;

public class Book extends Item {
    private String title;
    private String author;
    private int year;
    private boolean available = true;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
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

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getInformation() {
        String spacedTitle = String.format("%-30.30s",this.getTitle());
        String spacedAuthor = String.format("%-30.30s",this.getAuthor());
        String information = String.format("%s | %s | %s",spacedTitle,spacedAuthor,this.getYear());
        return information;
    }
}
