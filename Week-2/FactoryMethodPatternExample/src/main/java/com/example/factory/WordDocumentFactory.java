package com.example.factory;

/**
 * WordDocumentFactory - Concrete Creator.
 * Overrides the factory method to produce WordDocument instances.
 */
public class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        System.out.println("[WordDocumentFactory] Creating a new Word document...");
        return new WordDocument();
    }
}
