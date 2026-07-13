package com.example.factory;

/**
 * Document interface - the Product in the Factory Method pattern.
 * Defines the contract that all concrete document types must implement.
 */
public interface Document {

    /**
     * Opens the document for editing.
     */
    void open();

    /**
     * Saves the document to storage.
     */
    void save();

    /**
     * Closes the document and releases resources.
     */
    void close();
}
