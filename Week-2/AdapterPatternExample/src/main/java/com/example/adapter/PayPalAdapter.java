package com.example.adapter;

/**
 * Adapter - PayPalAdapter
 *
 * Adapts the PayPalGateway (adaptee) to the PaymentProcessor (target) interface.
 * This adapter wraps PayPalGateway and translates calls from processPayment()
 * into the PayPal-specific sendPayPalPayment() method, supplying the default
 * currency "USD" that PayPal requires but our target interface does not provide.
 *
 * Pattern Role: ADAPTER (Object Adapter - uses composition)
 */
public class PayPalAdapter implements PaymentProcessor {

    // The adaptee instance being wrapped
    private final PayPalGateway payPalGateway;

    // Default currency used when adapting the simpler target interface
    private final String defaultCurrency;

    /**
     * Constructor accepts the adaptee (PayPalGateway) to wrap.
     * Defaults the currency to "USD".
     *
     * @param payPalGateway the PayPal gateway instance to adapt
     */
    public PayPalAdapter(PayPalGateway payPalGateway) {
        this(payPalGateway, "USD");
    }

    /**
     * Constructor that also accepts a custom default currency.
     *
     * @param payPalGateway   the PayPal gateway instance to adapt
     * @param defaultCurrency the default currency code to use
     */
    public PayPalAdapter(PayPalGateway payPalGateway, String defaultCurrency) {
        this.payPalGateway = payPalGateway;
        this.defaultCurrency = defaultCurrency;
    }

    /**
     * Adapts the target interface call to the PayPal-specific API.
     * Translates: processPayment(amount) -> sendPayPalPayment(amount, "USD")
     * The adapter fills in the missing currency parameter with the default.
     *
     * @param amount the payment amount in USD
     */
    @Override
    public void processPayment(double amount) {
        System.out.println(">> PayPalAdapter: Translating processPayment -> sendPayPalPayment"
                + " (adding default currency: " + defaultCurrency + ")");
        payPalGateway.sendPayPalPayment(amount, defaultCurrency);
    }
}
