package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class ReturnMenuTest {
    User testUser = new User("000-0000","testPassword","Test Name","test@email","1800 000 000");
    Book testBook = new Book("test title","test author",2000);
    FakeConsole testConsole = new FakeConsole();
    HashMap<String,Item> testLib = new HashMap<String, Item>();
    ReturnMenu testReturnMenu = new ReturnMenu(testConsole,new Library(testLib),testUser);

    @Before
    public void addBookToTestLibrary() {
        testLib.put("test title",testBook);
    }

    @Test
    public void testReturnMenuPrintsPrompt() {
        assertThat(testConsole.getOutput(), containsString("Please type in the title of the item you wish to return:"));
    }

    @Test
    public void testReturnItemDoesntAcceptItemNotInLibrary() {
        testReturnMenu.returnItem(testLib, "book not in library",testUser);
        assertThat(testConsole.getOutput(),endsWith("Sorry, that item doesn't exist in this library"));
    }

    @Test
    public void testReturnItemDoesntAcceptItemThatsAvailable() {
        testReturnMenu.returnItem(testLib, "test title",testUser);
        assertThat(testConsole.getOutput(),endsWith("Sorry, that book is currently not checked out"));
    }

    @Test
    public void testReturnItemAcceptsValidItem() {
        testLib.get("test title").checkoutItem(testUser);
        testReturnMenu.returnItem(testLib, "test title",testUser);
        assertThat(testConsole.getOutput(),endsWith("Thank you for returning the book, Test Name"));
    }

    @Test
    public void testReturnItemClearsUserAfterSuccessfulReturn() {
        testLib.get("test title").checkoutItem(testUser);
        testReturnMenu.returnItem(testLib, "test title", testUser);
        assertEquals(null,testLib.get("test title").getBorrower());
    }
}