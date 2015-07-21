package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    Library testLibrary = new Library();

    @Test
    public void testConstructionCreatesThreeItems() {
        assertEquals(testLibrary.getLibrary().size(),3);
    }

    @Test
    public void testConstructionCreatesThreeAvailableItems() {
        assertEquals(testLibrary.getAvailableItems().size(),3);
    }

    @Test
    public void testConstructionCreatesZeroCheckedOutItems() {
        assertEquals(testLibrary.getCheckedOutItems().size(),0);
    }




}
