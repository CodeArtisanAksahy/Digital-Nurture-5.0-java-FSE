package com.example.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Singleton Logger Utility
 * 
 * Demonstrates the Singleton design pattern with:
 * - Private static volatile instance (ensures visibility across threads)
 * - Private constructor (prevents external instantiation)
 * - Public static synchronized getInstance() (thread-safe lazy initialization)
 * 
 * The Singleton pattern ensures that a class has only one instance
 * and provides a global point of access to it.
 */
public class Logger {

    // volatile ensures that changes to the instance are visible to all threads immediately.
    // Without volatile, a thread might see a partially constructed object.
    private static volatile Logger instance;

    // Formatter for timestamped log messages
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * Private constructor prevents instantiation from outside the class.
     * This is the key mechanism that enforces the "single instance" rule.
     */
    private Logger() {
        System.out.println("[Logger] Private constructor called — new instance created.");
    }

    /**
     * Public static synchronized method to get the single instance.
     * 
     * The 'synchronized' keyword ensures that only one thread can execute
     * this method at a time, preventing the creation of multiple instances
     * in a multi-threaded environment.
     * 
     * This is the "lazy initialization" approach — the instance is created
     * only when it is first requested, not when the class is loaded.
     * 
     * @return the single Logger instance
     */
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * Logs a message with a timestamp prefix.
     * 
     * @param message the message to log
     */
    public void log(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[" + timestamp + "] LOG: " + message);
    }
}
