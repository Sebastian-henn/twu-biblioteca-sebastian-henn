package com.twu.biblioteca;

public class HelperMessages {
    public static String welcomeMessage = "Welcome to the Bangalore Public Library management system BIBLIOTECA!\n";
    public static String menuScreen = "\nThis is the main menu. Please select one of the following:\n" +
                                      "[1] - List Books\n" +
                                      "[2] - Checkout a Book\n"+
                                      "[3] - Return a Book\n" +
                                      "[0] - Quit\n\n";
    public static String checkoutPrompt = "Please type the book title you wish to check out:\n";
    public static String returnPrompt = "Please type the book title you wish to return:\n";
    public static String successfulCheckout = "Thank you! Enjoy the book\n";
    public static String failedCheckout = "That book is not available.\n";
    public static String successfulReturn = "Thank you for returning the book.\n";
    public static String failedReturn = "That is not a valid book to return.\n";
    public static String invalidInput = "Please enter either [1],[2],[3] or [0]\n";



}
