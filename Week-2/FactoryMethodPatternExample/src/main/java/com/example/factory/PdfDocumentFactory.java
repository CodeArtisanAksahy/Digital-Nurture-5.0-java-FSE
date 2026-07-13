package com.example.factory;

/**
 * PdfDocumentFactory - Concrete Creator.
 * Overrides the factory method to produce PdfDocument instances.
 */
public class PdfDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        System.out.println("[PdfDocumentFactory] Creating a new PDF document...");
        return new PdfDocument();
    }
}
