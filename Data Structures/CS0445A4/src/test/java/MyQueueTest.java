import org.junit.jupiter.api.Test;

import stores.MyQueue;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {
    private MyQueue<String> myQueue = new MyQueue<>();

    @BeforeEach
    public void setupMyQueue() {
        myQueue = new MyQueue<>();
    }

    @Test
    void testIsEmptyDefault() {
        assertTrue(myQueue.isEmpty());
    }

    @Test
    void testIsEmptyAfterEnqueue() {
        myQueue.enqueue("hello");
        assertFalse(myQueue.isEmpty());
    }

    @Test
    void testIsEmptyAfterEnqueueAndDequeue() {
        myQueue.enqueue("hello");
        myQueue.dequeue();
        assertTrue(myQueue.isEmpty());
    }

    @Test
    void testDequeueDefault() {
        assertTrue(myQueue.dequeue() == null);
    }

    @Test
    void testDequeueAfterEnqueue1() {
        myQueue.enqueue("hello");
        assertTrue(myQueue.dequeue().equals("hello"));
    }

    @Test
    void testDequeueAfterEnqueue2() {
        myQueue.enqueue("hello");
        myQueue.enqueue("world");
        assertTrue(myQueue.dequeue().equals("hello"));
    }

    @Test
    void testEnqueueByToString() {
        myQueue.enqueue("hello");
        assertTrue(myQueue.toString().equals("[hello]"));
    }

    @Test
    void testEnqueue2ByToString() {
        myQueue.enqueue("hello");
        myQueue.enqueue("world");
        assertTrue(myQueue.toString().equals("[hello, world]"));
    }

    @Test
    void testModifyHeadDefault() {
        assertTrue(myQueue.modifyHead("hello") == null);
        assertTrue(myQueue.toString().equals("[hello]"));
    }

    @Test
    void testModifyHeadAfterEnqueue() {
        myQueue.enqueue("hello");
        assertTrue(myQueue.modifyHead("hello2").equals("hello"));
        assertTrue(myQueue.toString().equals("[hello2]"));
    }

    @Test
    void testModifyHeadAfterEnqueue2() {
        myQueue.enqueue("hello");
        myQueue.enqueue("world");
        assertTrue(myQueue.modifyHead("hello2").equals("hello"));
        assertTrue(myQueue.toString().equals("[hello2, world]"));
    }

    @Test
    void testToStringDefault() {
        assertTrue(myQueue.toString().equals("[]"));
    }

    @Test
    void testToStringAfterEnqueueAndDequeue() {
        myQueue.enqueue("hello");
        myQueue.dequeue();
        assertTrue(myQueue.toString().equals("[]"));
    }

    @Test
    void testToStringAfterEnqueue2AndDequeue() {
        myQueue.enqueue("hello");
        myQueue.enqueue("world");
        myQueue.dequeue();
        assertTrue(myQueue.toString().equals("[world]"));
    }
}
