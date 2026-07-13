package com.example.factory;

/**
 * ExcelDocumentFactory - Concrete Creator.
 * Overrides the factory method to produce ExcelDocument instances.
 */
public class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        System.out.println("[ExcelDocumentFactory] Creating a new Excel document...");
        return new ExcelDocument();
    }
}
