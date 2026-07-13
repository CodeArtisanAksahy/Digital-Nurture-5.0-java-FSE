package com.example.decorator;

/**
 * Concrete Decorator - SMSNotifierDecorator
 * 
 * Adds SMS notification capability on top of the wrapped notifier.
 * When send() is called, it first delegates to the wrapped notifier
 * (preserving existing behavior) and then adds SMS notification.
 * 
 * This follows the Open/Closed Principle — we extend behavior
 * without modifying the original EmailNotifier class.
 */
public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        // First, delegate to the wrapped notifier (e.g., email)
        super.send(message);

        // Then, add SMS-specific behavior
        sendSMS(message);
    }

    /**
     * Sends an SMS notification — the additional behavior this decorator provides.
     */
    private void sendSMS(String message) {
        System.out.println("  [SMS]   Sending SMS notification: " + message);
    }
}
