package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User testUser = new User("000-0000","testPassword","Test Name","test@email","1800 000 000");

    @Test
    public void testAuthenticateReturnsTrueIfValid() {
        assertTrue(testUser.authenticatePassword("testPassword"));
    }

    @Test
    public void testAuthenticateReturnsFalseIfInvalid() {
        assertFalse(testUser.authenticatePassword("incorrect Password"));
    }

    @Test
    public void testGetUserInformationReturnsCorrectDetails() {
        String expectedOutput = "Library Number: 000-0000"+
                "\nName: Test Name"+
                "\nemail: test@email"+
                "\nphone: 1800 000 000";
        assertEquals(expectedOutput,testUser.getUserInformation());
    }

}