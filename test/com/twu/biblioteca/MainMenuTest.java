package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
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

    @Test
    public void menuWithInputZeroQuits() {
        testMenu.menu(0);
        assertThat(testConsole.getOutput(), endsWith("Thankyou and goodbye!"));
    }

    @Test
    public void menuWithInputOneCallsPrintItems() {
        testMenu.menu(1);
        assertThat(testConsole.getOutput(), containsString("These are the list of items available for checkout:"));
    }

    @Test
    public void menuWithInputTwoCallsCheckoutMenu() {
        testMenu.menu(2);
        assertThat(testConsole.getOutput(), containsString("Please type in the title of the item you wish to check out:"));
    }

    @Test
    public void menuWithInputThreeCallsReturnMenu() {
        testMenu.menu(3);
        assertThat(testConsole.getOutput(), containsString("Please type in the title of the item you wish to return:"));
    }

    @Test
    public void menuWithInputFourCallsPrintUserDetails() {
        testMenu.menu(4);
        assertThat(testConsole.getOutput(), containsString("You are currently logged on as:"));
    }
}
