package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    Library testLibrary = new Library();

    @Test
    public void testConstructionCreatesFiveItems() {
        assertEquals(testLibrary.getLibrary().size(),5);
    }

    @Test
    public void testConstructionCreatesFourAvailableBooks() {
        assertEquals(testLibrary.getAvailableItems("Book").size(),4);
    }

    @Test
    public void testConstructionCreatesOneAvailableMovie() {
        assertEquals(testLibrary.getAvailableItems("Movie").size(),1);
    }

    @Test
    public void testConstructionCreatesZeroCheckedOutItems() {
        assertEquals(testLibrary.getCheckedOutItems().size(),0);
    }




}
