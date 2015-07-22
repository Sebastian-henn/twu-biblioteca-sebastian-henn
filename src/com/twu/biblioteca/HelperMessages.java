package com.twu.biblioteca;

public class HelperMessages {
    public static String welcomeMessage = "Welcome to the Bangalore Public Library management system BIBLIOTECA!";
    public static String menuScreen = "\nThis is the main menu. Please select one of the following:\n" +
                                      "[1] - List Items in Library\n" +
                                      "[2] - Checkout an Item\n"+
                                      "[3] - Return an Item\n" +
                                      "[0] - Quit";
    public static String checkoutPrompt = "Please type the item title you wish to check out:";
    public static String returnPrompt = "Please type the item title you wish to return:";
    public static String successfulCheckout = "Thank you! Enjoy the item";
    public static String failedCheckout = "That book is not available.";
    public static String successfulReturn = "Thank you for returning the item.";
    public static String failedReturn = "That is not a valid book to return.";
    public static String invalidInput = "Please enter either [1],[2],[3] or [0]";



}
