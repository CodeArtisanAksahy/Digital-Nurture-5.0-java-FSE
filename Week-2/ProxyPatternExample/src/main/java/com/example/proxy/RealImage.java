package com.example.proxy;

/**
 * Real Subject in the Proxy Pattern.
 * 
 * RealImage represents the actual heavyweight object that is expensive
 * to create. Loading an image from a remote server is simulated in the
 * constructor with a delay, making it a perfect candidate for lazy
 * initialization through a proxy.
 */
public class RealImage implements Image {

    private final String filename;

    /**
     * Constructs a RealImage by loading it from a remote server.
     * The loading process is expensive (simulated with a delay).
     *
     * @param filename the name of the image file to load
     */
    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    /**
     * Simulates loading the image from a remote server.
     * This is a costly operation involving network I/O and processing.
     */
    private void loadFromRemoteServer() {
        System.out.println("  [RealImage] Loading image from remote server: " + filename);
        try {
            // Simulate network delay for loading the image
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("  [RealImage] Loading interrupted for: " + filename);
        }
        System.out.println("  [RealImage] Finished loading: " + filename);
    }

    /**
     * Displays the image. This is a lightweight operation since the
     * image data is already loaded into memory.
     */
    @Override
    public void display() {
        System.out.println("  [RealImage] Displaying image: " + filename);
    }
}
