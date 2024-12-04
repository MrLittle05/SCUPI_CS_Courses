import org.junit.jupiter.api.Test;

import stores.MyStack;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    private MyStack<String> myStack = new MyStack<>();

    @BeforeEach
    public void setupMyStack() {
        myStack = new MyStack<>();
    }

    @Test
    void testIsEmptyDefault() {
        assertTrue(myStack.isEmpty());
    }

    @Test
    void testIsEmptyAfterPush() {
        myStack.push("hello");
        assertFalse(myStack.isEmpty());
    }

    @Test
    void testIsEmptyAfterPushAndPop() {
        myStack.push("hello");
        myStack.pop();
        assertTrue(myStack.isEmpty());
    }

    @Test
    void testPushByToString() {
        myStack.push("hello");
        assertTrue(myStack.toString().equals("[hello]"));
    }

    @Test
    void testPush2ByToString() {
        myStack.push("hello");
        myStack.push("world");
        assertTrue(myStack.toString().equals("[world, hello]"));
    }

    @Test
    void testPopDefault() {
        assertTrue(myStack.pop() == null);
    }

    @Test
    void testPopAfterPush() {
        myStack.push("hello");
        assertTrue(myStack.pop().equals("hello"));
    }

    @Test
    void testPopAfterPush2() {
        myStack.push("hello");
        myStack.push("world");
        assertTrue(myStack.pop().equals("world"));
    }

    @Test
    void testToStringDefault() {
        assertTrue(myStack.toString().equals("[]"));
    }

    @Test
    void testToStringAfterPushAndPop() {
        myStack.push("hello");
        myStack.push("world");
        myStack.pop();
        assertTrue(myStack.toString().equals("[hello]"));
    }
}
