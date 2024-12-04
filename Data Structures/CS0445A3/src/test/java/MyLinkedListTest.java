import org.junit.jupiter.api.Test;

import stores.MyLinkedList;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {
    private MyLinkedList<String> myLinkedList = new MyLinkedList<>();

    @BeforeEach
    public void setupMyLinkedList() {
        myLinkedList = new MyLinkedList<>();
    }

    @Test
    void testIsEmptyDefault() {
        assertTrue(myLinkedList.isEmpty());
    }

    @Test
    void testIsEmptyAfterAdd() {
        myLinkedList.add("hello");
        assertFalse(myLinkedList.isEmpty());
    }

    @Test
    void testIsEmptyAfterAddAndRemove() {
        myLinkedList.add("hello");
        myLinkedList.remove("hello");
        assertTrue(myLinkedList.isEmpty());
    }

    @Test
    void testAdd() {
        assertTrue(myLinkedList.add("hello"));
    }

    @Test
    void testSizeDefault() {
        assertTrue(myLinkedList.size() == 0);
    }

    @Test
    void testSizeAfterAdd() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.size() == 1);
    }

    @Test
    void testSizeAfterAddAndRemove() {
        myLinkedList.add("hello");
        myLinkedList.remove("hello");
        assertTrue(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 0);
    }

    @Test
    void testToStringEmpty() {
        assertTrue(myLinkedList.toString().equals("[]"));
    }

    @Test
    void testToStringAfterAdd() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.toString().equals("[hello]"));
    }

    @Test
    void testToStringMultipleAdd() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.toString().equals("[world, hello]"));
    }

    @Test
    void testAddToTailEmpty() {
        assertTrue(myLinkedList.addToTail("hello"));
        assertTrue(myLinkedList.toString().equals("[hello]"));
        assertFalse(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 1);
    }

    @Test
    void testAddToTailNotEmpty() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.addToTail("world"));
        assertTrue(myLinkedList.toString().equals("[hello, world]"));
        assertFalse(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 2);
    }

    @Test
    void testRemoveFromHeadEmpty() {
        assertTrue(myLinkedList.removeFromHead() == null);
        assertTrue(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 0);
        assertTrue(myLinkedList.toString().equals("[]"));
    }

    @Test
    void testRemoveFromHeadSingle() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.removeFromHead().equals("hello"));
        assertTrue(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 0);
        assertTrue(myLinkedList.toString().equals("[]"));
    }

    @Test
    void testRemoveFromHeadMultiple() {
        myLinkedList.add("world");
        myLinkedList.add("hello");
        assertTrue(myLinkedList.removeFromHead().equals("hello"));
        assertFalse(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 1);
        assertTrue(myLinkedList.toString().equals("[world]"));
    }

    @Test
    void testAddToTailAndRemoveFromHead() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.addToTail("world"));
        assertTrue(myLinkedList.toString().equals("[hello, world]"));
        assertFalse(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 2);

        assertTrue(myLinkedList.removeFromHead() == "hello");
        assertFalse(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 1);
        assertTrue(myLinkedList.toString().equals("[world]"));
    }

    @Test
    void testGetPos() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.get(0).equals("world"));
    }

    @Test
    void testGetNeg() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertFalse(myLinkedList.get(1).equals("world"));
    }

    @Test
    void testIndexOfPos() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.indexOf("hello") == 1);
    }

    @Test
    void testIndexOfNeg() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertFalse(myLinkedList.indexOf("hello") == 0);
    }

    @Test
    void testIndexOfNone() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.indexOf("all") == -1);
    }

    @Test
    void testSetPos() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.set(1, "hello2").equals("hello"));
        assertTrue(myLinkedList.toString().equals("[world, hello2]"));
    }

    @Test
    void testSetNeg() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertFalse(myLinkedList.set(1, "hello2").equals("world"));
        assertTrue(myLinkedList.toString().equals("[world, hello2]"));
    }

    @Test
    void testClearViaIsEmpty() {
        myLinkedList.add("hello");
        myLinkedList.clear();
        assertTrue(myLinkedList.isEmpty());
    }

    @Test
    void testClearViaToString() {
        myLinkedList.add("hello");
        myLinkedList.clear();
        assertTrue(myLinkedList.toString().equals("[]"));
    }

    @Test
    void testClearViaSize() {
        myLinkedList.add("hello");
        myLinkedList.clear();
        assertTrue(myLinkedList.size() == 0);
    }

    @Test
    void testContainsPos() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.contains("hello"));
    }

    @Test
    void testContainsNeg() {
        myLinkedList.add("hello");
        assertFalse(myLinkedList.contains("world"));
    }

    @Test
    void testRemovePos() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.remove("hello"));
    }

    @Test
    void testRemoveNeg() {
        myLinkedList.add("hello");
        assertFalse(myLinkedList.remove("world"));
    }
}
