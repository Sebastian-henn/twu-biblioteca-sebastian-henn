package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class CheckoutMenuTest {

    FakeConsole fakeConsole = new FakeConsole();
    User testUser = new User("000-0000","testPassword","Test Name","test@email","1800 000 000");
    HashMap<String,Item> testLib = new HashMap<String, Item>();
    CheckoutMenu testCheckoutMenu = new CheckoutMenu(fakeConsole,new Library(testLib),testUser);
    Book testBook = new Book("test book title","test author",2000);
    Movie testMovie = new Movie("test movie title",2001,"test director",5);

    @Before
    public void addItemsToTestLibrary() {
        testLib.put(testBook.getTitle(),testBook);
        testLib.put(testMovie.getTitle(),testMovie);
    }

    @Test
    public void testCheckoutMenuPrintsPrompt() {
        testCheckoutMenu.runOption();
        assertThat(fakeConsole.getOutput(), containsString("Please type in the title of the item you wish to check out:"));
    }

    @Test
    public void testCheckoutItemDoesntAcceptItemNotInLibrary() {
        testCheckoutMenu.checkoutItem(testLib, "item not in library",testUser);
        assertThat(fakeConsole.getOutput(),endsWith("Sorry, that item doesn't exist in this library"));
    }

    @Test
    public void testCheckoutItemAcceptsValidBook() {
        testCheckoutMenu.checkoutItem(testLib, "test book title",testUser);
        assertThat(fakeConsole.getOutput(),endsWith("Thank you Test Name! Enjoy the book"));
    }

    @Test
    public void testCheckoutItemAcceptsValidMovie() {
        testCheckoutMenu.checkoutItem(testLib, "test movie title",testUser);
        assertThat(fakeConsole.getOutput(),endsWith("Thank you Test Name! Enjoy the movie"));
    }

    @Test
    public void testCheckoutItemDoesntAcceptUnavailableItem() {
        testLib.get("test book title").checkoutItem(testUser);
        testCheckoutMenu.checkoutItem(testLib, "test book title",testUser);
        assertThat(fakeConsole.getOutput(), endsWith("Sorry, that book is currently checked out"));
    }

    @Test
    public void testCheckoutItemAddsUserCorrectly() {
        testCheckoutMenu.checkoutItem(testLib, "test movie title",testUser);
        assertEquals(testUser, testLib.get("test movie title").getBorrower());
    }
}
