package com.example.factory;

/**
 * ExcelDocument - Concrete Product.
 * Implements the Document interface with Excel-specific behavior.
 */
public class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("[ExcelDocument] Opening Excel spreadsheet (.xlsx)...");
        System.out.println("[ExcelDocument] Loading worksheets, formulas, and charts.");
    }

    @Override
    public void save() {
        System.out.println("[ExcelDocument] Saving Excel spreadsheet (.xlsx)...");
        System.out.println("[ExcelDocument] Recalculating formulas and preserving cell formats.");
    }

    @Override
    public void close() {
        System.out.println("[ExcelDocument] Closing Excel spreadsheet (.xlsx)...");
        System.out.println("[ExcelDocument] Resources released.");
    }
}
