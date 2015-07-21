package com.twu.biblioteca;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainMenuTest {
    FakeConsole testConsole = new FakeConsole();
    MainMenu testMenu = new MainMenu(testConsole);

    @Test
    public void welcomeMessagePrintsCorrectly() {
        testMenu.welcomeMessage();
        assertThat(testConsole.getOutput(),endsWith(HelperMessages.welcomeMessage));
    }

    @Test
    public void printMenuPrintsCorrectly() {
        testMenu.printMenu();
        assertThat(testConsole.getOutput(),endsWith(HelperMessages.menuScreen));
    }
}
