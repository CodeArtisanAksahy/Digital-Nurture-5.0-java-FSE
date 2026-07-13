package com.example.observer;

/**
 * Concrete Observer — MobileApp.
 *
 * Simulates a mobile application that receives push notifications
 * whenever a stock price it is observing changes.
 */
public class MobileApp implements Observer {

    private final String appUser;

    public MobileApp(String appUser) {
        this.appUser = appUser;
    }

    /**
     * React to a stock price update by printing a mobile notification.
     */
    @Override
    public void update(String stockName, double price) {
        System.out.println("  📱 [MobileApp - " + appUser + "] Notification: "
                + stockName + " is now $" + String.format("%.2f", price));
    }
}
