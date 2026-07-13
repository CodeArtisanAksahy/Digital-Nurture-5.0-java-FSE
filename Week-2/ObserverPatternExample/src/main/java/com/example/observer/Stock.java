package com.example.observer;

/**
 * Subject interface for the Observer Pattern.
 * Any class that wants to act as a subject (observable) should implement this interface.
 * It provides methods to register, deregister, and notify observers.
 */
public interface Stock {

    /**
     * Register an observer to receive updates.
     * @param o the observer to register
     */
    void registerObserver(Observer o);

    /**
     * Deregister an observer so it no longer receives updates.
     * @param o the observer to deregister
     */
    void deregisterObserver(Observer o);

    /**
     * Notify all registered observers about a state change.
     */
    void notifyObservers();
}
