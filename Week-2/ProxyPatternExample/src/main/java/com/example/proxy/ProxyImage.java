package com.example.proxy;

/**
 * Proxy (Virtual Proxy) in the Proxy Pattern.
 * 
 * ProxyImage acts as a stand-in for RealImage. It defers the expensive
 * creation of RealImage until the client actually calls display().
 * Once created, the RealImage is cached so subsequent display() calls
 * reuse the same instance without re-loading.
 * 
 * Key behaviors:
 *  - Lazy Initialization: RealImage is created only on first use.
 *  - Caching: The reference is stored for future calls.
 *  - Transparent to the client: Implements the same Image interface.
 */
public class ProxyImage implements Image {

    private final String filename;

    // Initially null — RealImage is NOT created until needed
    private RealImage realImage;

    /**
     * Constructs a ProxyImage. This is a lightweight operation — no
     * actual image loading happens here.
     *
     * @param filename the name of the image file
     */
    public ProxyImage(String filename) {
        this.filename = filename;
        System.out.println("  [ProxyImage] Proxy created for: " + filename + " (image NOT loaded yet)");
    }

    /**
     * Displays the image. On the first call, the RealImage is created
     * (triggering the expensive load). On subsequent calls, the cached
     * RealImage is reused directly.
     */
    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("  [ProxyImage] First access — creating RealImage for: " + filename);
            realImage = new RealImage(filename);
        } else {
            System.out.println("  [ProxyImage] Using cached RealImage for: " + filename);
        }
        realImage.display();
    }
}
