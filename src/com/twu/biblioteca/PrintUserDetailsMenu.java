package com.twu.biblioteca;

public class PrintUserDetailsMenu implements MenuOption {
    IConsole console;
    User user;

    public PrintUserDetailsMenu(IConsole console, User user) {
        this.console = console;
        this.user = user;
    }

    public void runOption() {
        console.writeOutput(user.getUserInformation());
    }

    public String getNameOfOption() {
        return "Print user information";
    }

}
