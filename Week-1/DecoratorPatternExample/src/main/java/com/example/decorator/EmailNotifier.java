package com.example.decorator;

/**
 * Concrete Component - EmailNotifier
 * 
 * The base notifier that sends notifications via email.
 * Decorators will wrap this (or other decorated versions) to add
 * additional notification channels without modifying this class.
 */
public class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("  [EMAIL] Sending email notification: " + message);
    }
}
