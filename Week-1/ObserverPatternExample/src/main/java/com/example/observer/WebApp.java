package com.example.observer;

/**
 * Concrete Observer — WebApp.
 *
 * Simulates a web dashboard that updates its display
 * whenever a stock price it is observing changes.
 */
public class WebApp implements Observer {

    private final String dashboardName;

    public WebApp(String dashboardName) {
        this.dashboardName = dashboardName;
    }

    /**
     * React to a stock price update by printing a web dashboard notification.
     */
    @Override
    public void update(String stockName, double price) {
        System.out.println("  🌐 [WebApp - " + dashboardName + "] Dashboard updated: "
                + stockName + " is now $" + String.format("%.2f", price));
    }
}
