package com.example.proxy;

/**
 * Subject Interface for the Proxy Pattern.
 * 
 * Defines the common interface shared by both the RealImage (real subject)
 * and ProxyImage (proxy). Clients interact with this interface, unaware
 * of whether they are using the real object or the proxy.
 */
public interface Image {

    /**
     * Displays the image.
     */
    void display();
}
