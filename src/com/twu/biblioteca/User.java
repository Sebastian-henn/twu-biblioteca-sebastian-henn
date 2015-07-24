package com.twu.biblioteca;

public class User {
    private String libraryNumber = "123-4567";
    private String password = "pw";
    private String name = "Seb";
    private String email = "seb@winning.com";
    private String phone = "+61(8)9123 4567";

    public User() {}

    public User(String libraryNumber, String password, String name, String email, String phone) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getUserInformation() {
        String information =    "Library Number: "+libraryNumber+
                              "\nName: "+name+
                              "\nemail: " +email+
                              "\nphone: "+phone;
        return information;
    }

    public boolean authenticatePassword(String inputPassword) {
        return (password.equals(inputPassword));
    }
}
