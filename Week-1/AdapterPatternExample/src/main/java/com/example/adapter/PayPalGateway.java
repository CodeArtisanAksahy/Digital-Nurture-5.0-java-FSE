package com.example.adapter;

/**
 * Adaptee - PayPalGateway
 *
 * Simulates a third-party PayPal payment gateway with its own unique API.
 * PayPal's API requires both an amount AND a currency string, making it
 * incompatible with our simple PaymentProcessor target interface.
 *
 * Pattern Role: ADAPTEE
 */
public class PayPalGateway {

    /**
     * PayPal's proprietary method to send a payment.
     * Note: Requires an extra currency parameter not present in our target interface.
     *
     * @param amount   the amount to send via PayPal
     * @param currency the currency code (e.g., "USD", "EUR")
     */
    public void sendPayPalPayment(double amount, String currency) {
        System.out.println("[PayPal Gateway] Initiating PayPal payment...");
        System.out.println("[PayPal Gateway] Sending $"
                + String.format("%.2f", amount) + " " + currency + " through PayPal.");
        System.out.println("[PayPal Gateway] PayPal transaction confirmed.");
    }
}
