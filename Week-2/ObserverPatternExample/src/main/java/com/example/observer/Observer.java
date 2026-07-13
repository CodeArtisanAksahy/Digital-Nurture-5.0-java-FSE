package com.example.observer;

/**
 * Observer interface for the Observer Pattern.
 * Any class that wants to be notified of stock price changes should implement this interface.
 */
public interface Observer {

    /**
     * Called by the subject when the stock price changes.
     * @param stockName the name of the stock that changed
     * @param price     the new price of the stock
     */
    void update(String stockName, double price);
}
