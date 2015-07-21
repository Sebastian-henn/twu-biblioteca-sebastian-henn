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
    Book testBook = new Book("test title","test author",2000);

    @Before
    public void addBookToTestLibrary() {
        testLib.put("test title",testBook);
    }

    @Test
    public void testCheckoutMenuPrintsPrompt() {
        assertThat(fakeConsole.getOutput(), containsString("Please type in the title of the item you wish to check out:"));
    }

    @Test
    public void testCheckoutItemDoesntAcceptItemNotInLibrary() {
        testCheckoutMenu.checkoutItem(testLib, "book not in library");
        assertThat(fakeConsole.getOutput(),endsWith("Sorry, that book doesn't exist in this library"));
    }

    @Test
    public void testCheckoutItemAcceptsValidItem() {
        testCheckoutMenu.checkoutItem(testLib, "test title");
        assertThat(fakeConsole.getOutput(),endsWith("Thank you! Enjoy the book"));
    }

    @Test
    public void testCheckoutItemDoesntAcceptUnavailableItem() {
        testLib.get("test title").checkoutItem();
        testCheckoutMenu.checkoutItem(testLib, "test title");
        assertThat(fakeConsole.getOutput(), endsWith("Sorry, that book is currently checked out"));
    }
}
