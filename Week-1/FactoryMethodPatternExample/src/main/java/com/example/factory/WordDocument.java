package com.example.factory;

/**
 * WordDocument - Concrete Product.
 * Implements the Document interface with Word-specific behavior.
 */
public class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("[WordDocument] Opening Word document (.docx)...");
        System.out.println("[WordDocument] Loading rich text formatting and styles.");
    }

    @Override
    public void save() {
        System.out.println("[WordDocument] Saving Word document (.docx)...");
        System.out.println("[WordDocument] Preserving fonts, images, and layout.");
    }

    @Override
    public void close() {
        System.out.println("[WordDocument] Closing Word document (.docx)...");
        System.out.println("[WordDocument] Resources released.");
    }
}
