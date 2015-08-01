package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class LibraryTest {
    User testUser = new User("000-0000","testPassword","Test Name","test@email","1800 000 000");
    FakeConsole fakeConsole = new FakeConsole();
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

    @Test
    public void testCheckoutItemDoesntAcceptItemNotInLibrary() {
        testLibrary2.checkoutAnItem(fakeConsole, "item not in library", testUser);
        assertThat(fakeConsole.getOutput(), endsWith("Sorry, that item doesn't exist in this library"));
    }

    @Test
    public void testCheckoutItemAcceptsValidBook() {
        testLibrary2.checkoutAnItem(fakeConsole, "test book title",testUser);
        assertThat(fakeConsole.getOutput(), endsWith("Thank you Test Name! Enjoy the book"));
        assertEquals(0, testLibrary2.getAvailableItems("Book").size());
        assertEquals(1, testLibrary2.getAvailableItems("Movie").size());
    }

    @Test
    public void testCheckoutItemAcceptsValidMovie() {
        testLibrary2.checkoutAnItem(fakeConsole, "test movie title",testUser);
        assertThat(fakeConsole.getOutput(), endsWith("Thank you Test Name! Enjoy the movie"));
        assertEquals(1, testLibrary2.getAvailableItems("Book").size());
        assertEquals(0, testLibrary2.getAvailableItems("Movie").size());
    }

    @Test
    public void testCheckoutItemDoesntAcceptUnavailableItem() {
        testLibrary2.getLibrary().get("test book title").checkoutItem(testUser);
        testLibrary2.checkoutAnItem(fakeConsole, "test book title", testUser);
        assertThat(fakeConsole.getOutput(), endsWith("Sorry, that book is currently checked out"));
    }

    @Test
    public void testCheckoutItemAddsUserCorrectly() {
        testLibrary2.checkoutAnItem(fakeConsole, "test movie title", testUser);
        assertEquals(testUser, testLibrary2.getLibrary().get("test movie title").getBorrower());
    }


    @Test
    public void testReturnItemDoesntAcceptItemNotInLibrary() {
        testLibrary2.returnAnItem(fakeConsole, "book not in library", testUser);
        assertThat(fakeConsole.getOutput(), endsWith("Sorry, that item doesn't exist in this library"));
    }

    @Test
    public void testReturnItemDoesntAcceptItemThatsAvailable() {
        testLibrary2.returnAnItem(fakeConsole, "test movie title", testUser);
        assertThat(fakeConsole.getOutput(), endsWith("Sorry, that movie is currently not checked out"));
    }

    @Test
    public void testReturnItemAcceptsValidItem() {
        testLibrary2.getLibrary().get("test movie title").checkoutItem(testUser);
        testLibrary2.returnAnItem(fakeConsole, "test movie title", testUser);
        assertThat(fakeConsole.getOutput(), endsWith("Thank you for returning the movie, Test Name"));
    }

    @Test
    public void testReturnItemClearsUserAfterSuccessfulReturn() {
        testLibrary2.getLibrary().get("test movie title").checkoutItem(testUser);
        testLibrary2.returnAnItem(fakeConsole, "test movie title", testUser);
        assertEquals(null, testLibrary2.getLibrary().get("test movie title").getBorrower());
    }
}
