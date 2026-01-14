package org.example.interfaces;

public interface IStack<T> {

    /**
     * Push value on top of stack
     * 
     * @param value to push on the stack.
     */
    public boolean push(T value);

    /**
     * Pop the value from the top of stack.
     * 
     * @return value popped off the top of the stack.
     */
    public T pop();

    /**
     * Peek the value from the top of stack.
     * 
     * @return value popped off the top of the stack.
     */
    public T peek();

    /**
     * Remove value from stack.
     * 
     * @param value to remove from stack.
     * @return True if value was removed.
     */
    public boolean remove(T value);

    /**
     * Clear the entire stack.
     */
    public void clear();

    /**
     * Does stack contain object.
     * 
     * @param value object to find in stack.
     * @return True is stack contains object.
     */
    public boolean contains(T value);

    /**
     * Size of the stack.
     * 
     * @return size of the stack.
     */
    public int size();

    /**
     * Validate the stack according to the invariants.
     * 
     * @return True if the stack is valid.
     */
    public boolean validate();

    /**
     * Get this Stack as a Java compatible Queue
     * 
     * @return Java compatible Queue
     */
    public java.util.Queue<T> toLifoQueue();

    /**
     * Get this Stack as a Java compatible Collection
     * 
     * @return Java compatible Collection
     */
    public java.util.Collection<T> toCollection();

}