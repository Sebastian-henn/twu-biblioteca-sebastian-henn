package com.twu.biblioteca;

/**
 * Created by Seb on 16/07/2015.
 */



public class Book {
    String name;
    String author;
    int year;
    boolean available;

    public Book(String n, String a, int y) {
        name = n;
        author = a;
        year = y;
        available = true;
    }
}
