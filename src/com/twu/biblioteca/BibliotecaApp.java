package com.twu.biblioteca;




public class BibliotecaApp {

    public Book[] booklist;

    public static void main(String[] args) {
        BibliotecaApp testApp = new BibliotecaApp();
        testApp.printWelcomeMessage();
        testApp.printMenu();
        testApp.createBooks();
        testApp.printBookList();
    }


    public void createBooks()
    {
        Book book1 = new Book("One Hundred Years of Solitude","Gabriel Garcia Marquez",1970);
        Book book2 = new Book("Musicophilia","Oliver Sacks",2006);
        Book book3 = new Book("The Tao of Physics","Fritjof Capra",1976);

        booklist = new Book[3];
        booklist[0] = book1;
        booklist[1] = book2;
        booklist[2] = book3;
    }

    public String printWelcomeMessage() {
        String message = "Welcome to the Bangalore Public Library management system BIBLIOTECA!";
        System.out.println(message);
        return message;
    }

    public void printBookList() {
        for (int i = 0; i < booklist.length; i++)
        {
            if (booklist[i].available) {
                System.out.println(booklist[i].name + ", by " + booklist[i].author + ". Published: " + booklist[i].year);
            } else {
                System.out.println("Book not available");
            }
        }
    }

    public void printMenu() {
        System.out.println("\nThis is the main menu. Please select one of the following:");
        System.out.println("[1] - List Books");
        System.out.println("[q] - Quit\n");
    }

}
