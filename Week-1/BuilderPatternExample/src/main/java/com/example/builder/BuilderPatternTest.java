package com.example.builder;

/**
 * Exercise 3: Builder Pattern – Demo / Test class
 *
 * Demonstrates how the Builder pattern lets us create different
 * Computer configurations through the same construction process,
 * without needing a constructor with many parameters.
 */
public class BuilderPatternTest {

    public static void main(String[] args) {

        System.out.println("=== Builder Pattern Demo ===\n");

        // ── 1. Gaming computer – every option specified ────────────
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9-14900K")
                .setRAM("32 GB DDR5")
                .setStorage("2 TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setOperatingSystem("Windows 11 Pro")
                .build();

        System.out.println("Gaming PC:");
        System.out.println(gamingPC);

        System.out.println("\n----------------------------------\n");

        // ── 2. Office computer – only essential options ────────────
        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5-13400")
                .setRAM("16 GB DDR4")
                .setStorage("512 GB SSD")
                .build();

        System.out.println("Office PC:");
        System.out.println(officePC);

        System.out.println("\n==================================");
        System.out.println("Notice how the Builder pattern allows:");
        System.out.println("  • Flexible object creation (set only what you need)");
        System.out.println("  • Readable, self-documenting code (fluent API)");
        System.out.println("  • Immutable products (private constructor)");
    }
}
