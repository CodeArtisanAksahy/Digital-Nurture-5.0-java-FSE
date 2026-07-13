package com.example.strategy;

/**
 * Concrete Strategy - CreditCardPayment
 * 
 * Implements the PaymentStrategy interface to process
 * payments via credit card. Encapsulates the credit card
 * payment algorithm.
 */
public class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;
    private String cardHolderName;

    /**
     * Constructs a CreditCardPayment strategy.
     *
     * @param cardNumber     the credit card number
     * @param cardHolderName the name on the card
     */
    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        // Mask the card number for display, showing only last 4 digits
        String maskedCard = "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Paid $" + String.format("%.2f", amount)
                + " using Credit Card [" + maskedCard + "]"
                + " | Cardholder: " + cardHolderName);
    }
}
