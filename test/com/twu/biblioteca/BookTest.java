package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;


public class BookTest {

    String title = "random title";
    String author = "random author";
    int year = 2042;


    @Test
    public void testBookConstructor()
    {
        Book testBook = new Book(title,author,year);
        assertEquals(title,testBook.getTitle());
        assertEquals(author,testBook.getAuthor());
        assertEquals(year, testBook.getYear());
    }

    @Test
    public void testSetAvailable() {
        Book testBook = new Book(title,author,year);
        testBook.setAvailable(false);
        assertFalse(testBook.getAvailability());
        testBook.setAvailable(true);
        assertTrue(testBook.getAvailability());
    }

}
