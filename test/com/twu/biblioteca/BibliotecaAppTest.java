package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private BibliotecaApp testApp = new BibliotecaApp();
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
    public void testPrintWelcomeMessage() {
        testApp.printWelcomeMessage();
        assertEquals(HelperMessages.welcomeMessage, output.toString());
    }
}
