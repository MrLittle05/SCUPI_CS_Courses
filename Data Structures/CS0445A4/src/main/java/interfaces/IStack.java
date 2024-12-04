package interfaces;

/*
 * An interface for a generic stack
 */
public interface IStack<E> {
    
    // Add an element to the (top of) stack.
    public void push(E element);
   
    // Remove and return element from the (top of) queue.
    public E pop();
    
    public boolean isEmpty();

    public String toString();
    
}
