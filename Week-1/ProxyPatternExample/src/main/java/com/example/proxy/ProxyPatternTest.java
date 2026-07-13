package com.example.proxy;

/**
 * Test / Demo class for the Proxy Pattern.
 * 
 * Demonstrates:
 *  1. Lazy Loading  — RealImage is NOT created when ProxyImage is constructed.
 *  2. On-demand Init — RealImage is created only when display() is first called.
 *  3. Caching        — Subsequent display() calls reuse the cached RealImage.
 */
public class ProxyPatternTest {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║        PROXY PATTERN — Virtual Proxy Demo       ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // ─── Step 1: Create proxy instances (lightweight — no loading) ───
        System.out.println();
        System.out.println("━━━ Step 1: Creating ProxyImage instances ━━━");
        System.out.println("  (Notice: NO image loading happens here!)");
        System.out.println();

        Image photo1 = new ProxyImage("vacation_photo.jpg");
        Image photo2 = new ProxyImage("family_portrait.png");
        Image photo3 = new ProxyImage("sunset_landscape.bmp");

        System.out.println();
        System.out.println("  ✓ Three proxies created. Zero images loaded.");

        // ─── Step 2: First display() triggers lazy loading ───
        System.out.println();
        System.out.println("━━━ Step 2: First display() call — triggers lazy loading ━━━");
        System.out.println();

        System.out.println("→ Calling photo1.display() for the FIRST time:");
        photo1.display();

        System.out.println();
        System.out.println("→ Calling photo2.display() for the FIRST time:");
        photo2.display();

        // ─── Step 3: Second display() uses cached image (no reload) ───
        System.out.println();
        System.out.println("━━━ Step 3: Second display() call — uses cached image ━━━");
        System.out.println("  (Notice: NO loading delay this time!)");
        System.out.println();

        System.out.println("→ Calling photo1.display() AGAIN:");
        photo1.display();

        System.out.println();
        System.out.println("→ Calling photo2.display() AGAIN:");
        photo2.display();

        // ─── Step 4: photo3 was never displayed — never loaded ───
        System.out.println();
        System.out.println("━━━ Step 4: photo3 was never displayed ━━━");
        System.out.println("  photo3 (sunset_landscape.bmp) was NEVER loaded");
        System.out.println("  because display() was never called on it.");
        System.out.println("  This is the power of lazy initialization!");

        System.out.println();
        System.out.println("→ Now calling photo3.display() for the FIRST time:");
        photo3.display();

        // ─── Summary ───
        System.out.println();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  SUMMARY — Proxy Pattern Benefits:");
        System.out.println("  • Lazy Init : Expensive objects created only when needed");
        System.out.println("  • Caching   : Once loaded, the object is reused");
        System.out.println("  • Transparent: Client uses the Image interface throughout");
        System.out.println("  • Resource   : Unused objects (photo3) never consume resources");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
}
