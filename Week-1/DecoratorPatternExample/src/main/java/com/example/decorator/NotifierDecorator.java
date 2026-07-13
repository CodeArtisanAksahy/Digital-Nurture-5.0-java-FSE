package com.example.decorator;

/**
 * Base Decorator - NotifierDecorator
 * 
 * Abstract decorator class that implements the Notifier interface and
 * holds a reference to a wrapped Notifier object. By default, it
 * delegates the send() call to the wrapped notifier.
 * 
 * Concrete decorators extend this class and add their own behavior
 * before or after delegating to the wrapped notifier.
 * 
 * KEY INSIGHT: The decorator holds a reference to a Notifier (not a
 * specific class), so decorators can wrap other decorators — enabling
 * dynamic stacking of behaviors at runtime.
 */
public abstract class NotifierDecorator implements Notifier {

    /** The wrapped notifier that this decorator delegates to */
    protected final Notifier wrappedNotifier;

    /**
     * Constructs a decorator wrapping the given notifier.
     *
     * @param notifier the notifier to wrap (can be a base component or another decorator)
     */
    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    /**
     * Default delegation — forwards the send call to the wrapped notifier.
     * Concrete decorators override this to add behavior and then call super.send().
     */
    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}
