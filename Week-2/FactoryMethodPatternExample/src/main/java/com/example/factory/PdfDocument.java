package com.example.factory;

/**
 * PdfDocument - Concrete Product.
 * Implements the Document interface with PDF-specific behavior.
 */
public class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("[PdfDocument] Opening PDF document (.pdf)...");
        System.out.println("[PdfDocument] Rendering pages with fixed layout.");
    }

    @Override
    public void save() {
        System.out.println("[PdfDocument] Saving PDF document (.pdf)...");
        System.out.println("[PdfDocument] Embedding fonts and compressing images.");
    }

    @Override
    public void close() {
        System.out.println("[PdfDocument] Closing PDF document (.pdf)...");
        System.out.println("[PdfDocument] Resources released.");
    }
}
