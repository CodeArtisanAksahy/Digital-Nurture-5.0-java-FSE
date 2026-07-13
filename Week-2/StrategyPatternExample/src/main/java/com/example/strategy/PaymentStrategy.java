package com.example.strategy;

/**
 * Strategy Interface - PaymentStrategy
 * 
 * Defines a common interface for all payment algorithms.
 * Each concrete strategy will implement this interface with
 * its own payment processing logic.
 */
public interface PaymentStrategy {

    /**
     * Process a payment of the given amount.
     *
     * @param amount the amount to pay
     */
    void pay(double amount);
}
