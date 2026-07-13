package com.example.factory;

/**
 * DocumentFactory - Abstract Creator in the Factory Method pattern.
 *
 * Declares the factory method createDocument() that subclasses must override
 * to produce specific document types. Also provides a template method
 * newDocument() that uses the factory method and performs common operations.
 */
public abstract class DocumentFactory {

    /**
     * Factory Method - subclasses override this to create
     * the specific type of Document.
     *
     * @return a new Document instance
     */
    public abstract Document createDocument();

    /**
     * Template method that creates a document via the factory method
     * and performs a standard workflow: open, save, and close.
     *
     * This demonstrates how the creator can use the product without
     * knowing the concrete class — the subclass decides what gets created.
     */
    public void demonstrateDocument() {
        // The factory method is called here — we don't know the concrete type
        Document document = createDocument();
        document.open();
        document.save();
        document.close();
    }
}
