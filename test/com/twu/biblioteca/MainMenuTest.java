package com.twu.biblioteca;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainMenuTest {
    FakeConsole testConsole = new FakeConsole();
    User testUser = new User();
    MainMenu testMenu = new MainMenu(testConsole,testUser);

    @Test
    public void welcomeMessagePrintsCorrectly() {
        testMenu.welcomeMessage();
        assertThat(testConsole.getOutput(),endsWith("Welcome to the Bangalore Public Library management system BIBLIOTECA!"));
    }

    @Test
    public void printMenuPrintsCorrectly() {
        testMenu.printMenu();
        assertThat(testConsole.getOutput(),endsWith("[0] - Quit"));
    }
}
