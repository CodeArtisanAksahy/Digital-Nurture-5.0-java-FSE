package com.example.command;

/**
 * Receiver class - knows how to perform the actual operations.
 * The Light is the object being acted upon by commands.
 */
public class Light {

    /**
     * Turns the light on.
     */
    public void turnOn() {
        System.out.println("Light is ON");
    }

    /**
     * Turns the light off.
     */
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}
