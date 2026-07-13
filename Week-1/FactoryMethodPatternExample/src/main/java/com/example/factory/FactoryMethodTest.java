package com.example.factory;

/**
 * FactoryMethodTest - Demonstrates the Factory Method design pattern.
 *
 * The Factory Method pattern defines an interface for creating objects but
 * lets subclasses decide which class to instantiate. It promotes loose
 * coupling by eliminating the need to bind application-specific classes
 * into the code — the code works with the Product interface, while
 * Concrete Creators handle the actual instantiation.
 *
 * Structure:
 *   - Product (Document)             : interface for objects the factory creates
 *   - ConcreteProduct (Word/Pdf/Excel): specific implementations of Product
 *   - Creator (DocumentFactory)       : abstract class declaring the factory method
 *   - ConcreteCreator (Word/Pdf/ExcelDocumentFactory): overrides factory method
 *
 * Key benefits:
 *   1. Open/Closed Principle — add new document types without modifying existing code
 *   2. Single Responsibility — creation logic is isolated in factory subclasses
 *   3. Loose coupling — client code depends on abstractions, not concrete classes
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("   Exercise 2: Factory Method Pattern — Document Creator");
        System.out.println("==========================================================");

        // -----------------------------------------------------------
        // Demo 1: Using factories directly via createDocument()
        // -----------------------------------------------------------
        System.out.println("\n--- Demo 1: Creating documents via individual factories ---\n");

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        System.out.println();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        System.out.println();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();

        // -----------------------------------------------------------
        // Demo 2: Polymorphic usage — same code, different factories
        // -----------------------------------------------------------
        System.out.println("\n--- Demo 2: Polymorphic usage via demonstrateDocument() ---\n");

        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };

        for (DocumentFactory factory : factories) {
            System.out.println(">> Using factory: " + factory.getClass().getSimpleName());
            factory.demonstrateDocument();
            System.out.println();
        }

        // -----------------------------------------------------------
        // Demo 3: Adding a new type requires NO changes to this code
        // -----------------------------------------------------------
        System.out.println("--- Key Takeaway ---");
        System.out.println("To add a new document type (e.g., PowerPoint):");
        System.out.println("  1. Create PowerPointDocument implements Document");
        System.out.println("  2. Create PowerPointDocumentFactory extends DocumentFactory");
        System.out.println("  3. No existing code needs to change!");
        System.out.println("This is the Open/Closed Principle in action.");
        System.out.println("\n==========================================================");
        System.out.println("   Factory Method Pattern demo complete.");
        System.out.println("==========================================================");
    }
}
