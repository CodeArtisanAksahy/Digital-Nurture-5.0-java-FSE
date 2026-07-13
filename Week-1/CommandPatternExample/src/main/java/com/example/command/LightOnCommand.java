package com.example.command;

/**
 * Concrete Command - encapsulates the "turn on" action.
 * Binds the Light receiver to the turnOn() action.
 */
public class LightOnCommand implements Command {

    private Light light;

    /**
     * Constructor takes the receiver (Light) that this command will act on.
     *
     * @param light the Light receiver
     */
    public LightOnCommand(Light light) {
        this.light = light;
    }

    /**
     * Delegates to the receiver's turnOn() method.
     */
    @Override
    public void execute() {
        light.turnOn();
    }
}
