package com.example.builder;

/**
 * Exercise 3: Builder Pattern
 *
 * Computer is the Product class. It has many optional attributes,
 * making a telescoping constructor impractical. Instead, we use a
 * static nested Builder class that provides a fluent API for
 * constructing Computer instances step-by-step.
 */
public class Computer {

    // ── Product attributes (all immutable once built) ──────────────
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String graphicsCard;
    private final String operatingSystem;

    // ── Private constructor – only the Builder can call this ───────
    private Computer(Builder builder) {
        this.CPU             = builder.CPU;
        this.RAM             = builder.RAM;
        this.storage         = builder.storage;
        this.graphicsCard    = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    // ── Getters ────────────────────────────────────────────────────
    public String getCPU()             { return CPU; }
    public String getRAM()             { return RAM; }
    public String getStorage()         { return storage; }
    public String getGraphicsCard()    { return graphicsCard; }
    public String getOperatingSystem() { return operatingSystem; }

    @Override
    public String toString() {
        return "Computer Configuration:\n"
             + "  CPU             : " + CPU + "\n"
             + "  RAM             : " + RAM + "\n"
             + "  Storage         : " + storage + "\n"
             + "  Graphics Card   : " + graphicsCard + "\n"
             + "  Operating System: " + operatingSystem;
    }

    // ════════════════════════════════════════════════════════════════
    //  Static nested Builder class
    // ════════════════════════════════════════════════════════════════
    public static class Builder {

        // Mirror the same attributes as Computer
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        // Fluent setter methods – each returns 'this' so calls can be chained
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        /**
         * Terminal operation – constructs and returns the immutable Computer.
         */
        public Computer build() {
            return new Computer(this);
        }
    }
}
