package com.twu.biblioteca;


public class User {
    private String libraryNumber = "123-4567";
    private String password = "pw";
    private String name = "Seb";
    private String email = "seb@winning.com";
    private String phone = "+61(8)9123 4567";

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
