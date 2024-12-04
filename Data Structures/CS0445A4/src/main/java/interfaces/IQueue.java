package interfaces;

/**
* An interface for a generic queue
*/
public interface IQueue<E> {
    
    // Add an element to the (end of) queue.
    public void enqueue(E element);
    
    // Remove and return element from the (start of) queue.
    public E dequeue();
    
    // Returns true when the queue has no elements, false otherwise.
    public boolean isEmpty();

    //Modifies the head of the queue, and returns the previous value of the head
    public E modifyHead(E element);

    public String toString();
    
}
