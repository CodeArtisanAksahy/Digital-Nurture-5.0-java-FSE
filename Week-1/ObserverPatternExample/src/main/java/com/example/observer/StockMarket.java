package com.example.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject implementing the Stock interface.
 *
 * StockMarket maintains a list of observers and notifies them
 * whenever the stock price changes. This is the core of the
 * Observer Pattern — the subject pushes updates to all registered observers.
 */
public class StockMarket implements Stock {

    // List of registered observers watching this stock
    private final List<Observer> observers;

    // The name of the stock (e.g., "AAPL", "GOOGL")
    private final String stockName;

    // Current price of the stock
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.observers = new ArrayList<>();
        this.stockName = stockName;
        this.price = initialPrice;
    }

    /**
     * Register an observer to receive price updates.
     */
    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
            System.out.println("[StockMarket] Observer registered: " + o.getClass().getSimpleName());
        }
    }

    /**
     * Deregister an observer so it stops receiving updates.
     */
    @Override
    public void deregisterObserver(Observer o) {
        if (observers.remove(o)) {
            System.out.println("[StockMarket] Observer deregistered: " + o.getClass().getSimpleName());
        } else {
            System.out.println("[StockMarket] Observer not found: " + o.getClass().getSimpleName());
        }
    }

    /**
     * Push the current stock name and price to every registered observer.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    /**
     * Update the stock price and automatically notify all observers.
     * This is the trigger that starts the observer notification chain.
     *
     * @param price the new stock price
     */
    public void setPrice(double price) {
        System.out.println("\n[StockMarket] " + stockName + " price changed to $" + String.format("%.2f", price));
        this.price = price;
        notifyObservers();
    }

    // --- Getters ---

    public String getStockName() {
        return stockName;
    }

    public double getPrice() {
        return price;
    }
}
