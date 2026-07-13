package com.example.observer;

/**
 * Exercise 7: Observer Pattern — Demo / Test Class
 *
 * Demonstrates the Observer Pattern using a stock market scenario:
 *  1. A StockMarket (subject) is created for a stock.
 *  2. MobileApp and WebApp observers register to watch the stock.
 *  3. When the price changes, both observers are notified.
 *  4. One observer is deregistered.
 *  5. On the next price change, only the remaining observer is notified.
 *
 * Key takeaway: The subject and observers are loosely coupled.
 *               The subject doesn't know the concrete type of its observers —
 *               it only knows they implement the Observer interface.
 */
public class ObserverPatternTest {

    public static void main(String[] args) {

        System.out.println("=== Exercise 7: Observer Pattern ===");
        System.out.println("Scenario: Stock price tracker with multiple notification channels\n");

        // --- Step 1: Create the Subject (StockMarket) ---
        StockMarket appleStock = new StockMarket("AAPL", 150.00);

        // --- Step 2: Create Observers ---
        MobileApp mobileApp = new MobileApp("Akshay");
        WebApp webApp = new WebApp("TradingDashboard");

        // --- Step 3: Register both observers ---
        System.out.println("--- Registering Observers ---");
        appleStock.registerObserver(mobileApp);
        appleStock.registerObserver(webApp);

        // --- Step 4: Change price — both observers get notified ---
        System.out.println("\n--- Price Change #1 (both observers active) ---");
        appleStock.setPrice(155.50);

        System.out.println("\n--- Price Change #2 (both observers active) ---");
        appleStock.setPrice(162.75);

        // --- Step 5: Deregister the MobileApp observer ---
        System.out.println("\n--- Deregistering MobileApp ---");
        appleStock.deregisterObserver(mobileApp);

        // --- Step 6: Change price again — only WebApp gets notified ---
        System.out.println("\n--- Price Change #3 (only WebApp active) ---");
        appleStock.setPrice(158.30);

        // --- Bonus: Re-register MobileApp and change price again ---
        System.out.println("\n--- Re-registering MobileApp ---");
        appleStock.registerObserver(mobileApp);

        System.out.println("\n--- Price Change #4 (both observers active again) ---");
        appleStock.setPrice(170.00);

        System.out.println("\n=== Observer Pattern Demo Complete ===");
    }
}
