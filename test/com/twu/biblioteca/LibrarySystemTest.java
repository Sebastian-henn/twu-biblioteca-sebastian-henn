package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class LibrarySystemTest {
    private LibrarySystem testLibrarySystem = new LibrarySystem();
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private ByteArrayOutputStream error = new ByteArrayOutputStream();

    @Before
    public void setupPrintstream() {
        System.setOut(new PrintStream(output));
        System.setErr(new PrintStream(error));
    }

    @After
    public void teardownPrintStream() {
        System.setOut(null);
        System.setErr(null);
    }


    @Test
    public void testLibrarySystemConstructor() {
        assertEquals(3, testLibrarySystem.booklist.length);
    }

    @Test
    public void testPrintMenu() {
        testLibrarySystem.printMenu();
        assertEquals(HelperMessages.menuScreen, output.toString());
    }

    @Test
    public void testCheckoutBook() {
        assertFalse(testLibrarySystem.checkoutBook("A book not in the library"));
        assertTrue(testLibrarySystem.checkoutBook("The Tao of Physics"));
        assertFalse(testLibrarySystem.booklist[2].getAvailability());
        assertFalse(testLibrarySystem.checkoutBook("The Tao of Physics"));
    }

    @Test
    public void testReturnBook() {
        assertFalse(testLibrarySystem.returnBook("A book not in the library"));
        assertFalse(testLibrarySystem.returnBook("Musicophilia"));
        testLibrarySystem.booklist[1].setAvailable(false);
        assertTrue(testLibrarySystem.returnBook("Musicophilia"));
        assertTrue(testLibrarySystem.booklist[1].getAvailability());
    }
}
