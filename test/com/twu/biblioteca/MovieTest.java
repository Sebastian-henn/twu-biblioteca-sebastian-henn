package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {

    String title = "random title";
    int year = 2042;
    String director = "random author";
    int rating = 6;

    Movie testMovie = new Movie(title,year,director,rating);

    @Test
    public void testMovieConstructor() {
        assertEquals(title,testMovie.getTitle());
        assertEquals(year,testMovie.getYear());
        assertEquals(director, testMovie.getDirector());
        assertEquals(rating,testMovie.getRating());
    }

    @Test
    public void testSetAvailable() {
        testMovie.setAvailable(false);
        assertFalse(testMovie.getAvailability());
        testMovie.setAvailable(true);
        assertTrue(testMovie.getAvailability());
    }
}