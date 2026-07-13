package com.example.decorator;

/**
 * Concrete Decorator - SlackNotifierDecorator
 * 
 * Adds Slack notification capability on top of the wrapped notifier.
 * Can be stacked with SMSNotifierDecorator (or any other decorator)
 * to build a multi-channel notification pipeline at runtime.
 */
public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        // First, delegate to the wrapped notifier (e.g., email, or email+SMS)
        super.send(message);

        // Then, add Slack-specific behavior
        sendSlack(message);
    }

    /**
     * Sends a Slack notification — the additional behavior this decorator provides.
     */
    private void sendSlack(String message) {
        System.out.println("  [SLACK] Sending Slack notification: " + message);
    }
}
