package com.example.command;

/**
 * Test/Demo class for the Command Pattern.
 *
 * Demonstrates how the Command pattern decouples the invoker (RemoteControl)
 * from the receiver (Light). The invoker doesn't need to know what action
 * is performed — it simply calls execute() on the command object.
 *
 * Participants:
 *   - Command       : Command interface (declares execute())
 *   - ConcreteCommand: LightOnCommand, LightOffCommand (bind receiver to action)
 *   - Receiver      : Light (performs the actual work)
 *   - Invoker       : RemoteControl (triggers command execution)
 */
public class CommandPatternTest {

    public static void main(String[] args) {
        System.out.println("=== Command Pattern Demo ===\n");

        // 1. Create the Receiver
        Light livingRoomLight = new Light();

        // 2. Create Concrete Commands, passing the receiver
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // 3. Create the Invoker
        RemoteControl remote = new RemoteControl();

        // 4. Set the "light on" command and press the button
        System.out.println("Pressing the remote to turn the light ON...");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println();

        // 5. Set the "light off" command and press the button
        System.out.println("Pressing the remote to turn the light OFF...");
        remote.setCommand(lightOff);
        remote.pressButton();

        System.out.println("\n=== Key Takeaway ===");
        System.out.println("The RemoteControl (invoker) is completely decoupled from the Light (receiver).");
        System.out.println("It only knows about the Command interface — not what happens when execute() is called.");
    }
}
