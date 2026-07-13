package com.example.strategy;

/**
 * Concrete Strategy - PayPalPayment
 * 
 * Implements the PaymentStrategy interface to process
 * payments via PayPal. Encapsulates the PayPal payment algorithm.
 */
public class PayPalPayment implements PaymentStrategy {

    private String email;

    /**
     * Constructs a PayPalPayment strategy.
     *
     * @param email the PayPal account email
     */
    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + String.format("%.2f", amount)
                + " using PayPal [" + email + "]");
    }
}
