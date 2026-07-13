package com.example.decorator;

/**
 * Component Interface - Notifier
 * 
 * Defines the common interface for both concrete components and decorators.
 * In the Decorator pattern, this is the contract that all notifiers
 * (both base and decorated) must follow.
 */
public interface Notifier {

    /**
     * Sends a notification with the given message.
     *
     * @param message the message content to send
     */
    void send(String message);
}
