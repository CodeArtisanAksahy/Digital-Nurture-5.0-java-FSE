package com.example.command;

/**
 * Invoker class - asks the command to carry out a request.
 * The RemoteControl doesn't know what the command does;
 * it only knows to call execute() on whatever command is set.
 */
public class RemoteControl {

    private Command command;

    /**
     * Sets the command to be executed when the button is pressed.
     *
     * @param command the command to associate with the button
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Simulates pressing a button — triggers the stored command.
     */
    public void pressButton() {
        command.execute();
    }
}
