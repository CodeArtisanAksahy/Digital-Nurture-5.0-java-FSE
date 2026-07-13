package com.example.command;

/**
 * Concrete Command - encapsulates the "turn off" action.
 * Binds the Light receiver to the turnOff() action.
 */
public class LightOffCommand implements Command {

    private Light light;

    /**
     * Constructor takes the receiver (Light) that this command will act on.
     *
     * @param light the Light receiver
     */
    public LightOffCommand(Light light) {
        this.light = light;
    }

    /**
     * Delegates to the receiver's turnOff() method.
     */
    @Override
    public void execute() {
        light.turnOff();
    }
}
