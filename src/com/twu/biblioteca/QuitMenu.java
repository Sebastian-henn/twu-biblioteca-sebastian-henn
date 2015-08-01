package com.twu.biblioteca;

public class QuitMenu implements MenuOption {
    IConsole console;
    User user;


    public QuitMenu(IConsole console, User user) {
        this.console = console;
        this.user = user;
    }

    public void runOption() {
        console.writeOutput("Thankyou "+user.getName()+", please come again soon");
    }

    public String getNameOfOption() {
        return "Quit";
    }
}
