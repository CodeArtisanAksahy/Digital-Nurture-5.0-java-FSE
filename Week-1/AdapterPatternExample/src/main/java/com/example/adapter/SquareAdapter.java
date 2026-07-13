package com.example.adapter;

/**
 * Adapter - SquareAdapter
 *
 * Adapts the SquareGateway (adaptee) to the PaymentProcessor (target) interface.
 * This adapter wraps SquareGateway and translates calls from processPayment()
 * into the Square-specific chargeSquare() method, supplying a default
 * description that Square requires but our target interface does not provide.
 *
 * Pattern Role: ADAPTER (Object Adapter - uses composition)
 */
public class SquareAdapter implements PaymentProcessor {

    // The adaptee instance being wrapped
    private final SquareGateway squareGateway;

    // Default description used when adapting the simpler target interface
    private final String defaultDescription;

    /**
     * Constructor accepts the adaptee (SquareGateway) to wrap.
     * Defaults the description to "Payment".
     *
     * @param squareGateway the Square gateway instance to adapt
     */
    public SquareAdapter(SquareGateway squareGateway) {
        this(squareGateway, "Payment");
    }

    /**
     * Constructor that also accepts a custom default description.
     *
     * @param squareGateway      the Square gateway instance to adapt
     * @param defaultDescription the default transaction description to use
     */
    public SquareAdapter(SquareGateway squareGateway, String defaultDescription) {
        this.squareGateway = squareGateway;
        this.defaultDescription = defaultDescription;
    }

    /**
     * Adapts the target interface call to the Square-specific API.
     * Translates: processPayment(amount) -> chargeSquare(amount, "Payment")
     * The adapter fills in the missing description parameter with the default.
     *
     * @param amount the payment amount in USD
     */
    @Override
    public void processPayment(double amount) {
        System.out.println(">> SquareAdapter: Translating processPayment -> chargeSquare"
                + " (adding default description: \"" + defaultDescription + "\")");
        squareGateway.chargeSquare(amount, defaultDescription);
    }
}
