package com.example.adapter;

/**
 * Adaptee - SquareGateway
 *
 * Simulates a third-party Square payment gateway with its own unique API.
 * Square's API requires both an amount AND a description string, making it
 * incompatible with our simple PaymentProcessor target interface.
 *
 * Pattern Role: ADAPTEE
 */
public class SquareGateway {

    /**
     * Square's proprietary method to charge a payment.
     * Note: Requires an extra description parameter not present in our target interface.
     *
     * @param amount      the amount to charge via Square
     * @param description a description of the transaction
     */
    public void chargeSquare(double amount, String description) {
        System.out.println("[Square Gateway] Charging via Square...");
        System.out.println("[Square Gateway] Amount: $"
                + String.format("%.2f", amount) + " | Description: " + description);
        System.out.println("[Square Gateway] Square charge completed.");
    }
}
