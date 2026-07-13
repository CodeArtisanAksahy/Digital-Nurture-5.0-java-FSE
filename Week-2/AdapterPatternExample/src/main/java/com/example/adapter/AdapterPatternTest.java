package com.example.adapter;

/**
 * Exercise 4: Adapter Pattern - Test / Demo Class
 *
 * This class demonstrates the Adapter Pattern by showing how three different
 * third-party payment gateways (Stripe, PayPal, Square), each with their own
 * incompatible API, can be used through a single unified PaymentProcessor interface.
 *
 * KEY CONCEPTS DEMONSTRATED:
 * 1. Target Interface (PaymentProcessor) - the interface our client code expects
 * 2. Adaptees (StripeGateway, PayPalGateway, SquareGateway) - existing classes
 *    with incompatible interfaces
 * 3. Adapters (StripeAdapter, PayPalAdapter, SquareAdapter) - bridge classes
 *    that translate the target interface into adaptee-specific calls
 *
 * WHEN TO USE THE ADAPTER PATTERN:
 * - When you want to use an existing class but its interface doesn't match yours
 * - When integrating third-party libraries or legacy code
 * - When you want to create a reusable class that cooperates with unrelated classes
 */
public class AdapterPatternTest {

    public static void main(String[] args) {

        System.out.println("==========================================================");
        System.out.println("   Exercise 4: Adapter Pattern - Payment Gateway Demo");
        System.out.println("==========================================================");
        System.out.println();

        // ---------------------------------------------------------------
        // Step 1: Create the third-party gateway instances (adaptees)
        // ---------------------------------------------------------------
        // These are the "existing" classes with incompatible interfaces.
        StripeGateway stripeGateway = new StripeGateway();
        PayPalGateway payPalGateway = new PayPalGateway();
        SquareGateway squareGateway = new SquareGateway();

        // ---------------------------------------------------------------
        // Step 2: Wrap each gateway in its corresponding adapter
        // ---------------------------------------------------------------
        // Now all three gateways can be used through the unified
        // PaymentProcessor interface, even though their native APIs differ.
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        PaymentProcessor squareProcessor = new SquareAdapter(squareGateway);

        // ---------------------------------------------------------------
        // Step 3: Use all processors through the SAME interface
        // ---------------------------------------------------------------
        // The client code doesn't need to know which gateway is being used.
        // It simply calls processPayment() on any PaymentProcessor.

        System.out.println("--- Processing payment via Stripe ---");
        stripeProcessor.processPayment(49.99);
        System.out.println();

        System.out.println("--- Processing payment via PayPal ---");
        payPalProcessor.processPayment(129.50);
        System.out.println();

        System.out.println("--- Processing payment via Square ---");
        squareProcessor.processPayment(75.00);
        System.out.println();

        // ---------------------------------------------------------------
        // Step 4: Demonstrate polymorphic usage with an array
        // ---------------------------------------------------------------
        // This is the real power of the Adapter Pattern: treating all
        // adapters uniformly through the target interface.
        System.out.println("==========================================================");
        System.out.println("   Polymorphic Usage: Processing $200 through ALL gateways");
        System.out.println("==========================================================");
        System.out.println();

        PaymentProcessor[] processors = { stripeProcessor, payPalProcessor, squareProcessor };

        for (PaymentProcessor processor : processors) {
            processor.processPayment(200.00);
            System.out.println();
        }

        // ---------------------------------------------------------------
        // Step 5: Demonstrate adapter with custom parameters
        // ---------------------------------------------------------------
        System.out.println("==========================================================");
        System.out.println("   Custom Adapter Configuration");
        System.out.println("==========================================================");
        System.out.println();

        // PayPalAdapter with EUR currency instead of default USD
        PaymentProcessor euroPayPal = new PayPalAdapter(payPalGateway, "EUR");
        System.out.println("--- PayPal payment in EUR ---");
        euroPayPal.processPayment(85.00);
        System.out.println();

        // SquareAdapter with a custom description
        PaymentProcessor squareSubscription = new SquareAdapter(squareGateway, "Monthly Subscription");
        System.out.println("--- Square payment with custom description ---");
        squareSubscription.processPayment(19.99);
        System.out.println();

        System.out.println("==========================================================");
        System.out.println("   Adapter Pattern Demo Complete!");
        System.out.println("==========================================================");
    }
}
