package com.example.adapter;

/**
 * Adapter - StripeAdapter
 *
 * Adapts the StripeGateway (adaptee) to the PaymentProcessor (target) interface.
 * This adapter wraps the StripeGateway and translates calls from processPayment()
 * into the Stripe-specific makeStripePayment() method.
 *
 * Pattern Role: ADAPTER (Object Adapter - uses composition)
 */
public class StripeAdapter implements PaymentProcessor {

    // The adaptee instance being wrapped
    private final StripeGateway stripeGateway;

    /**
     * Constructor accepts the adaptee (StripeGateway) to wrap.
     *
     * @param stripeGateway the Stripe gateway instance to adapt
     */
    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    /**
     * Adapts the target interface call to the Stripe-specific API.
     * Translates: processPayment(amount) -> makeStripePayment(amount)
     *
     * @param amount the payment amount in USD
     */
    @Override
    public void processPayment(double amount) {
        System.out.println(">> StripeAdapter: Translating processPayment -> makeStripePayment");
        stripeGateway.makeStripePayment(amount);
    }
}
