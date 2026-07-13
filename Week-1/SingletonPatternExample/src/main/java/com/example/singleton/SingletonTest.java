package com.example.singleton;

/**
 * Test / Demo class for the Singleton Pattern.
 * 
 * This class demonstrates:
 * 1. Getting two Logger references and proving they are the same object.
 * 2. Logging messages from both references.
 * 3. Thread-safety verification by fetching the instance from multiple threads.
 */
public class SingletonTest {

    public static void main(String[] args) {

        System.out.println("=== Singleton Pattern Demo ===\n");

        // ---------------------------------------------------------
        // Step 1: Get two Logger instances and verify they are the same
        // ---------------------------------------------------------
        System.out.println("--- Step 1: Identity Check ---");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // The '==' operator checks reference equality (same object in memory)
        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));
        System.out.println("logger1 hashCode : " + logger1.hashCode());
        System.out.println("logger2 hashCode : " + logger2.hashCode());
        System.out.println();

        // ---------------------------------------------------------
        // Step 2: Log messages from both references
        // ---------------------------------------------------------
        System.out.println("--- Step 2: Logging from Both References ---");
        logger1.log("Message from logger1");
        logger2.log("Message from logger2");
        System.out.println("(Both messages come from the same Logger instance)\n");

        // ---------------------------------------------------------
        // Step 3: Thread-safety — get instances from multiple threads
        // ---------------------------------------------------------
        System.out.println("--- Step 3: Thread-Safety Verification ---");
        final int threadCount = 5;
        Thread[] threads = new Thread[threadCount];
        final Logger[] instancesFromThreads = new Logger[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                instancesFromThreads[index] = Logger.getInstance();
                instancesFromThreads[index].log("Hello from Thread-" + index);
            }, "Thread-" + i);
        }

        // Start all threads
        for (Thread t : threads) {
            t.start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Verify every thread received the exact same instance
        System.out.println("\n--- Verification: All Threads Got Same Instance ---");
        boolean allSame = true;
        for (int i = 0; i < threadCount; i++) {
            boolean same = (instancesFromThreads[0] == instancesFromThreads[i]);
            System.out.println("  instances[0] == instances[" + i + "] ? " + same);
            if (!same) {
                allSame = false;
            }
        }

        System.out.println("\nAll threads received the same instance: " + allSame);
        System.out.println("\n=== Singleton Pattern Demo Complete ===");
    }
}
