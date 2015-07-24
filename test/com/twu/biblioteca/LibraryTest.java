package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LibraryTest {

    Library testLibrary = new Library();
    Library testLibrary2;
    HashMap<String, Item> itemList = new HashMap<String, Item>();

    @Before
    public void setUp() {
        itemList.put("test book title",new Book("test book title","test author",2000));
        itemList.put("test movie title",new Movie("test movie title",2001,"test director",1));
        testLibrary2 = new Library(itemList);
    }

    @Test
    public void testDefaultConstructionCreatesFiveItems() {
        assertEquals(testLibrary.getLibrary().size(),5);
    }

    @Test
    public void testDefaultConstructionCreatesFourAvailableBooks() {
        assertEquals(testLibrary.getAvailableItems("Book").size(),4);
    }

    @Test
    public void testDefaultConstructionCreatesOneAvailableMovie() {
        assertEquals(testLibrary.getAvailableItems("Movie").size(),1);
    }

    @Test
    public void testDefaultConstructionCreatesZeroCheckedOutItems() {
        assertEquals(testLibrary.getCheckedOutItems().size(),0);
    }

    @Test
    public void testCustomConstructorCreatesOneBookAndOneMovie() {
        assertEquals(testLibrary2.getAvailableItems("Book").size(),1);
        assertEquals(testLibrary2.getAvailableItems("Movie").size(),1);
    }
}
