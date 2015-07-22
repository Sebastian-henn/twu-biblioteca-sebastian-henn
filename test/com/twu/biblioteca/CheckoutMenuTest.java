package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutMenuTest {
    FakeConsole fakeConsole = new FakeConsole();
    HashMap<String,Item> testLib = new HashMap<String, Item>();
    CheckoutMenu testCheckoutMenu = new CheckoutMenu(fakeConsole);
    Book testBook = new Book("test book title","test author",2000);
    Movie testMovie = new Movie("test movie title",2001,"test director",5);

    @Before
    public void addItemsToTestLibrary() {
        testLib.put("test book title",testBook);
        testLib.put("test movie title",testMovie);
    }

    @Test
    public void testCheckoutMenuPrintsPrompt() {
        assertThat(fakeConsole.getOutput(), containsString("Please type in the title of the item you wish to check out:"));
    }

    @Test
    public void testCheckoutItemDoesntAcceptItemNotInLibrary() {
        testCheckoutMenu.checkoutItem(testLib, "item not in library");
        assertThat(fakeConsole.getOutput(),endsWith("Sorry, that item doesn't exist in this library"));
    }

    @Test
    public void testCheckoutItemAcceptsValidBook() {
        testCheckoutMenu.checkoutItem(testLib, "test book title");
        assertThat(fakeConsole.getOutput(),endsWith("Thank you! Enjoy the book"));
    }

    @Test
    public void testCheckoutItemAcceptsValidMovie() {
        testCheckoutMenu.checkoutItem(testLib, "test movie title");
        assertThat(fakeConsole.getOutput(),endsWith("Thank you! Enjoy the movie"));
    }

    @Test
    public void testCheckoutItemDoesntAcceptUnavailableItem() {
        testLib.get("test book title").checkoutItem();
        testCheckoutMenu.checkoutItem(testLib, "test book title");
        assertThat(fakeConsole.getOutput(), endsWith("Sorry, that book is currently checked out"));
    }
}
