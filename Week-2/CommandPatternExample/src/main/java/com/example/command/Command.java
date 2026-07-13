package com.example.command;

/**
 * Command Interface - declares the execute() method.
 * All concrete commands must implement this interface.
 * This decouples the invoker from the receiver.
 */
public interface Command {
    void execute();
}
