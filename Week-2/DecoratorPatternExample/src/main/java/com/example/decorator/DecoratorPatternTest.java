package com.example.decorator;

/**
 * Exercise 5: Decorator Pattern - Test / Demo
 * 
 * Demonstrates the Decorator Pattern using a notification system:
 * 
 * PATTERN STRUCTURE:
 *   Notifier (Component Interface)
 *     └── EmailNotifier (Concrete Component)
 *     └── NotifierDecorator (Abstract Decorator)
 *           ├── SMSNotifierDecorator (Concrete Decorator)
 *           └── SlackNotifierDecorator (Concrete Decorator)
 * 
 * KEY CONCEPTS:
 *   - Decorators add behavior dynamically without modifying existing classes
 *   - Decorators can be stacked in any combination at runtime
 *   - Client code works with the Notifier interface — it doesn't know
 *     whether it's talking to a base component or a decorated one
 *   - Follows Open/Closed Principle: open for extension, closed for modification
 */
public class DecoratorPatternTest {

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   Exercise 5: Decorator Pattern Demo");
        System.out.println("   (Notification System)");
        System.out.println("==============================================\n");

        // -------------------------------------------------------
        // Scenario 1: Base component only — Email notification
        // -------------------------------------------------------
        System.out.println("--- Scenario 1: Email Only (Base Component) ---");
        Notifier emailOnly = new EmailNotifier();
        emailOnly.send("Server is down!");
        System.out.println();

        // -------------------------------------------------------
        // Scenario 2: Email + SMS (single decorator wrapping)
        // -------------------------------------------------------
        System.out.println("--- Scenario 2: Email + SMS (Single Decorator) ---");
        Notifier emailPlusSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailPlusSMS.send("CPU usage exceeded 90%");
        System.out.println();

        // -------------------------------------------------------
        // Scenario 3: Email + SMS + Slack (double decorator stacking)
        // -------------------------------------------------------
        System.out.println("--- Scenario 3: Email + SMS + Slack (Stacked Decorators) ---");
        Notifier fullStack = new SlackNotifierDecorator(
                                new SMSNotifierDecorator(
                                    new EmailNotifier()));
        fullStack.send("Database connection lost!");
        System.out.println();

        // -------------------------------------------------------
        // Scenario 4: Dynamic composition — building at runtime
        // -------------------------------------------------------
        System.out.println("--- Scenario 4: Dynamic Composition at Runtime ---");
        System.out.println("  (Simulating user preferences for notification channels)\n");

        boolean wantEmail = true;
        boolean wantSMS = true;
        boolean wantSlack = false;

        // Start with base notifier if email is wanted
        Notifier dynamicNotifier = null;
        if (wantEmail) {
            dynamicNotifier = new EmailNotifier();
        }

        // Stack decorators based on runtime flags
        if (dynamicNotifier != null && wantSMS) {
            dynamicNotifier = new SMSNotifierDecorator(dynamicNotifier);
        }
        if (dynamicNotifier != null && wantSlack) {
            dynamicNotifier = new SlackNotifierDecorator(dynamicNotifier);
        }

        System.out.println("  User preferences: Email=" + wantEmail
                + ", SMS=" + wantSMS + ", Slack=" + wantSlack);
        if (dynamicNotifier != null) {
            dynamicNotifier.send("Disk space running low");
        }
        System.out.println();

        // -------------------------------------------------------
        // Scenario 5: Different stacking order
        // -------------------------------------------------------
        System.out.println("--- Scenario 5: Different Stacking Order ---");
        System.out.println("  (Slack wraps Email, then SMS wraps that)\n");
        Notifier reverseOrder = new SMSNotifierDecorator(
                                    new SlackNotifierDecorator(
                                        new EmailNotifier()));
        reverseOrder.send("Memory leak detected!");
        System.out.println();

        // -------------------------------------------------------
        // Summary
        // -------------------------------------------------------
        System.out.println("==============================================");
        System.out.println("   Decorator Pattern Benefits:");
        System.out.println("   • Add responsibilities dynamically");
        System.out.println("   • Combine behaviors in any order");
        System.out.println("   • No subclass explosion (vs inheritance)");
        System.out.println("   • Follows Open/Closed Principle");
        System.out.println("   • Client code uses the same interface");
        System.out.println("==============================================");
    }
}
