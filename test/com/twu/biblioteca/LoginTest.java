package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    FakeConsole testConsole = new FakeConsole();
    HashMap<String,User> testUserList = new HashMap<String, User>();
    User testUser = new User("000-0000","testPassword","Test Name","test@email","1800 000 000");
    Login testLogin;


    @Before
    public void setUp() {
        testUserList.put(testUser.getLibraryNumber(),testUser);
        testLogin = new Login(testConsole,testUserList);
    }

    @Test
    public void testIsLoginValidReturnsTrueIfValid() {
        assertTrue(testLogin.isLoginValid("000-0000","testPassword"));
    }

    @Test
    public void testIsLoginValidReturnsFalseIfInvalidPassword() {
        assertFalse(testLogin.isLoginValid("000-0000", "incorrectPassword"));
        assertThat(testConsole.getOutput(), containsString("Password doesn't match a known library number"));
    }

    @Test
    public void testIsLoginValidReturnsFalseIfInvalidLibraryNumber() {
        assertFalse(testLogin.isLoginValid("000-0001", "testPassword"));
        assertThat(testConsole.getOutput(), containsString("Library number not in database"));
    }

    @Test
    public void testReturnUserReturnsNullIfInvalidInput() {
        assertEquals(testLogin.returnTheUser("000-0001", "testPassword"), null);
    }

    @Test
    public void testReturnUserReturnsTestUserIfValidInput() {
        assertEquals(testLogin.returnTheUser("000-0000", "testPassword"),testUser);
    }
}
