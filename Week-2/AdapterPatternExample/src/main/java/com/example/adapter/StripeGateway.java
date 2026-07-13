package com.example.adapter;

/**
 * Adaptee - StripeGateway
 *
 * Simulates a third-party Stripe payment gateway with its own unique API.
 * This class has a method signature that does NOT match our PaymentProcessor
 * target interface, which is exactly why we need an adapter.
 *
 * Pattern Role: ADAPTEE
 */
public class StripeGateway {

    /**
     * Stripe's proprietary method to process a payment.
     * Note: The method name and signature differ from our target interface.
     *
     * @param totalAmount the total amount to charge via Stripe
     */
    public void makeStripePayment(double totalAmount) {
        System.out.println("[Stripe Gateway] Processing Stripe payment of $"
                + String.format("%.2f", totalAmount));
        System.out.println("[Stripe Gateway] Connecting to Stripe API...");
        System.out.println("[Stripe Gateway] Payment of $"
                + String.format("%.2f", totalAmount) + " completed successfully via Stripe.");
    }
}
