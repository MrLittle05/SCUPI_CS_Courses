import org.junit.jupiter.api.Test;

import stores.Counter;
import stores.Count;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class CounterTest {
    private Counter<String> myCounter = new Counter<>();

    @BeforeEach
    public void setCounter() {
        myCounter = new Counter<>();
    }

    @Test
    void testGetCount() {
        myCounter.add("hello");
        assertTrue(myCounter.getCount("hello") == 1);
    }

    @Test
    void testAddSingle() {
        assertTrue(myCounter.add("hello"));
        assertTrue(myCounter.getCount("hello") == 1);
    }

    @Test
    void testAddDouble() {
        assertTrue(myCounter.add("hello"));
        assertTrue(myCounter.add("hello"));
        assertTrue(myCounter.getCount("hello") == 2);
    }

    @Test
    void testSizeSingle() {
        myCounter.add("hello");
        assertTrue(myCounter.size() == 1);
    }

    @Test
    void testSizeDouble() {
        myCounter.add("hello");
        myCounter.add("hello");
        assertTrue(myCounter.size() == 2);
    }

    @Test
    void testSizeMulti() {
        myCounter.add("hello");
        myCounter.add("world");
        assertTrue(myCounter.size() == 2);
    }

    @Test
    void testSizeCombo() {
        myCounter.add("hello");
        myCounter.add("hello");
        myCounter.add("world");
        assertTrue(myCounter.size() == 3);
    }

    @Test
    void testSizeEmpty() {
        assertTrue(myCounter.size() == 0);
    }

    @Test
    void testClearEmpty() {
        myCounter.clear();
        assertTrue(myCounter.isEmpty());
    }

    @Test
    void testClearNotEmpty() {
        myCounter.add("hello");
        myCounter.clear();
        assertTrue(myCounter.isEmpty());
    }

    @Test
    void testContainsPos() {
        myCounter.add("hello");
        assertTrue(myCounter.contains("hello"));
    }

    @Test
    void testContainsNegEmpty() {
        assertFalse(myCounter.contains("hello"));
    }

    @Test
    void testContainsNegNonEmpty() {
        myCounter.add("hello");
        assertFalse(myCounter.contains("world"));
    }

    @Test
    void testIsEmptyPos() {
        assertTrue(myCounter.isEmpty());
    }

    @Test
    void testIsEmptyNeg() {
        myCounter.add("hello");
        assertFalse(myCounter.isEmpty());
    }

    @Test
    void testRemovePos() {
        myCounter.add("hello");
        assertTrue(myCounter.remove("hello"));
    }

    @Test
    void testRemoveNeg() {
        myCounter.add("hello");
        assertFalse(myCounter.remove("world"));
    }

    @Test
    void testRemoveEmpty() {
        assertFalse(myCounter.remove("hello"));
    }

}
