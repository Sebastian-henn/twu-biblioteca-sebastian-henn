package com.twu.biblioteca;

public class Movie extends Item {

    private String title;
    private int year;
    private String director;
    private int rating;

    private boolean available = true;

    public Movie(String title, int year, String director, int rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() { return rating; }

    public boolean getAvailability() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getInformation() {
        String spacedTitle = String.format("%-30.30s",this.getTitle());
        String spacedYear = String.format("%-30.30s",this.getYear());
        String spacedDirector = String.format("%-30.30s",this.getDirector());
        String information = String.format("%s | %s | %s |%s",spacedTitle,spacedYear,spacedDirector,this.getRating());
        return information;
    }
}
