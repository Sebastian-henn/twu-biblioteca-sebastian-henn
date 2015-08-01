package com.twu.biblioteca;


import org.junit.Test;

public class BibliotecaAppTest {


    @Test
    public void AcceptanceTest() {

        FakeConsole fc = new FakeConsole("acceptance test");
        fc.setupInputCommand("123-4567");
        fc.setupInputCommand("pw");
        fc.setupInputCommand("1");
        fc.setupInputCommand("2");
        fc.setupInputCommand("Musicophilia");
        fc.setupInputCommand("2");
        fc.setupInputCommand("Musicophilia");
        fc.setupInputCommand("2");
        fc.setupInputCommand("The Matrix is such a good movie");
        fc.setupInputCommand("2");
        fc.setupInputCommand("The Matrix");
        fc.setupInputCommand("1");
        fc.setupInputCommand("3");
        fc.setupInputCommand("Musicophilia");
        fc.setupInputCommand("1");
        fc.setupInputCommand("4");
        fc.setupInputCommand("0");
        fc.setupInputCommand("Unreachable");

        BibliotecaApp acceptanceTest = new BibliotecaApp();
        acceptanceTest.runApplication(fc);
    }

}
