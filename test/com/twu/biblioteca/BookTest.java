package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    String title = "random title";
    String author = "random author";
    int year = 2042;
    Book testBook = new Book(title,author,year);

    @Test
    public void testBookConstructor() {
        assertEquals(title,testBook.getTitle());
        assertEquals(author,testBook.getAuthor());
        assertEquals(year, testBook.getYear());
        assertTrue(testBook.getAvailability());
    }

    @Test
    public void testSetAvailable() {
        testBook.setAvailable(false);
        assertFalse(testBook.getAvailability());
        testBook.setAvailable(true);
        assertTrue(testBook.getAvailability());
    }
}
