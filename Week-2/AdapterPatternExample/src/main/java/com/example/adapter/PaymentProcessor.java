package com.example.adapter;

/**
 * Target Interface - PaymentProcessor
 *
 * This is the unified interface that our application expects all payment
 * processors to implement. The Adapter Pattern allows us to wrap third-party
 * payment gateways (each with their own unique API) behind this common interface.
 *
 * Pattern Role: TARGET
 */
public interface PaymentProcessor {

    /**
     * Process a payment for the given amount.
     *
     * @param amount the payment amount in USD
     */
    void processPayment(double amount);
}
