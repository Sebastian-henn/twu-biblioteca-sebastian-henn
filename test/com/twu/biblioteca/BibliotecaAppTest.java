package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BibliotecaAppTest {

    BibliotecaApp testApp = new BibliotecaApp();

    @Test
    public void testPrintWelcomeMessage() {
        assertEquals("Welcome to the Bangalore Public Library management system BIBLIOTECA!", testApp.printWelcomeMessage());
    }


}
