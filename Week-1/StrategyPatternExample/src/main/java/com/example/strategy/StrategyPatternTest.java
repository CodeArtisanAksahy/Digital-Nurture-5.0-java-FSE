package com.example.strategy;

/**
 * Test / Demo Class - StrategyPatternTest
 * 
 * Demonstrates the Strategy Pattern by:
 * 1. Creating a PaymentContext (the context).
 * 2. Setting a CreditCardPayment strategy and making a payment.
 * 3. Switching to a PayPalPayment strategy at runtime and making another payment.
 * 
 * Key Takeaway:
 *   The Strategy Pattern lets you define a family of algorithms (payment methods),
 *   encapsulate each one, and make them interchangeable. The context delegates
 *   behavior to the strategy object, and the strategy can be swapped at runtime
 *   without changing the context's code.
 */
public class StrategyPatternTest {

    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Demo ===");
        System.out.println();

        // Create the context
        PaymentContext context = new PaymentContext();

        // --- Strategy 1: Credit Card Payment ---
        System.out.println("--- Using Credit Card Strategy ---");
        PaymentStrategy creditCard = new CreditCardPayment("1234567890123456", "Akshay Thakur");
        context.setPaymentStrategy(creditCard);
        context.executePayment(150.00);
        context.executePayment(49.99);
        System.out.println();

        // --- Strategy 2: Switch to PayPal at runtime ---
        System.out.println("--- Switching to PayPal Strategy at Runtime ---");
        PaymentStrategy payPal = new PayPalPayment("akshay@example.com");
        context.setPaymentStrategy(payPal);
        context.executePayment(89.50);
        context.executePayment(200.00);
        System.out.println();

        // --- Switch back to a different credit card ---
        System.out.println("--- Switching to Another Credit Card ---");
        PaymentStrategy anotherCard = new CreditCardPayment("9876543210987654", "John Doe");
        context.setPaymentStrategy(anotherCard);
        context.executePayment(320.75);
        System.out.println();

        System.out.println("=== Strategy Pattern Demo Complete ===");
        System.out.println();
        System.out.println("Notice: The PaymentContext never changed — only the strategy");
        System.out.println("it delegates to was swapped at runtime. This is the power of");
        System.out.println("the Strategy Pattern: algorithms are interchangeable!");
    }
}
