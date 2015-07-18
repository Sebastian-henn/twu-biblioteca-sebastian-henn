package com.twu.biblioteca;

import java.util.Scanner;

public class LibrarySystem {

    public Book[] booklist = { new Book("One Hundred Years of Solitude","Gabriel Garcia Marquez",1970),
                               new Book("Musicophilia","Oliver Sacks",2006),
                               new Book("The Tao of Physics","Fritjof Capra",1976)};

    public void LibrarySystem() {
    }

    public void printMenu() {
        System.out.print(HelperMessages.menuScreen);
    }

    public void printBooklist() {
        for (int i = 0; i < booklist.length; i++) {
            String spacedTitle = String.format("%-30.30s",booklist[i].getTitle());
            String spacedAuthor = String.format("%-30.30s",booklist[i].getAuthor());
            String availability = (booklist[i].getAvailability()) ? "IN LIBRARY" : "OUT OF STOCK";
            System.out.print(String.format("%s | %s | %s | %s\n",spacedTitle,spacedAuthor,booklist[i].getYear(),availability));
        }
    }

    public void checkoutMenu() {
        System.out.print(HelperMessages.checkoutPrompt);
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        if (checkoutBook(input)) {
            System.out.print(HelperMessages.successfulCheckout);
        } else {
            System.out.print(HelperMessages.failedCheckout);
        }
        printMenu();
    }

    public boolean checkoutBook(String title){
        for (int i = 0; i < booklist.length; i++) {
            if (booklist[i].getTitle().matches(title)) {
                if(booklist[i].getAvailability()) {
                    booklist[i].setAvailable(false);
                    return true;
                }
            }
        }
        return false;
    }

    public void returnMenu() {
        System.out.print(HelperMessages.returnPrompt);
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        if (returnBook(input)) {
            System.out.print(HelperMessages.successfulReturn);
        } else {
            System.out.print(HelperMessages.failedReturn);
        }
        printMenu();
    }

    public boolean returnBook(String title){
        for (int i = 0; i < booklist.length; i++) {
            if (booklist[i].getTitle().matches(title)) {
                if(!booklist[i].getAvailability()) {
                    booklist[i].setAvailable(true);
                    return true;
                }
            }
        }
        return false;
    }

    public void setupMenu(){
        int input = -1;
        printMenu();
        Scanner sc = new Scanner(System.in);
        while (input != 0) {
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                switch (input) {
                    case 1:
                        printBooklist();
                        break;
                    case 2:
                        checkoutMenu();
                        break;
                    case 3:
                        returnMenu();
                        break;
                    case 0:
                        //quit
                        break;
                    default:
                        System.out.print(HelperMessages.invalidInput);
                }
            } else {
                System.out.print(HelperMessages.invalidInput);
                sc.next();
            }
        }
    }
}
