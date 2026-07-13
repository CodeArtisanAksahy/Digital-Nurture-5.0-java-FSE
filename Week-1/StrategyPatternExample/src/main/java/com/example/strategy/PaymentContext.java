package com.example.strategy;

/**
 * Context Class - PaymentContext
 * 
 * Maintains a reference to the current PaymentStrategy and
 * delegates payment execution to it. The strategy can be
 * swapped at runtime, allowing the payment algorithm to
 * change dynamically without modifying this class.
 */
public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    /**
     * Sets or swaps the payment strategy at runtime.
     *
     * @param strategy the PaymentStrategy to use
     */
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    /**
     * Executes payment by delegating to the currently set strategy.
     *
     * @param amount the amount to pay
     * @throws IllegalStateException if no strategy has been set
     */
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set! Call setPaymentStrategy() first.");
        }
        paymentStrategy.pay(amount);
    }
}
