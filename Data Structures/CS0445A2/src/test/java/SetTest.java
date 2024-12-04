import org.junit.jupiter.api.Test;

import stores.Set;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set<String> mySet = new Set<>();

    @BeforeEach
    public void setupSet() {
        mySet = new Set<>();
    }

    @Test
    void testAddPos() {
        assertTrue(mySet.add("hello"));
    }

    @Test
    void testAddNeg() {
        mySet.add("hello");
        assertFalse(mySet.add("hello"));
    }

    @Test
    void testToStringPos() {
        mySet.add("hello");
        assertTrue(mySet.toString().equals("[hello]"));
    }

    @Test
    void testToStringNoDup() {
        mySet.add("hello");
        mySet.add("hello");
        assertTrue(mySet.toString().equals("[hello]"));
    }

    @Test
    void testToStringEmpty() {
        assertTrue(mySet.toString().equals("[]"));
    }

    @Test
    void testClearEmpty() {
        mySet.clear();
        assertTrue(mySet.isEmpty());
    }

    @Test
    void testClearNotEmpty() {
        mySet.add("hello");
        mySet.clear();
        assertTrue(mySet.isEmpty());
    }

    @Test
    void testContainsPos() {
        mySet.add("hello");
        assertTrue(mySet.contains("hello"));
    }

    @Test
    void testContainsNeg() {
        mySet.add("hello");
        assertFalse(mySet.contains("world"));
    }

    @Test
    void testIsEmptyPos() {
        assertTrue(mySet.isEmpty());
    }

    @Test
    void testIsEmptyNeg() {
        mySet.add("hello");
        assertFalse(mySet.isEmpty());
    }

    @Test
    void testRemovePos() {
        mySet.add("hello");
        assertTrue(mySet.remove("hello"));
    }

    @Test
    void testRemoveNeg() {
        mySet.add("hello");
        assertFalse(mySet.remove("world"));
    }

    @Test
    void testSizeEmpty() {
        assertTrue(mySet.size() == 0);
    }

    @Test
    void testSizeNotEmpty() {
        mySet.add("hello");
        assertTrue(mySet.size() == 1);
    }
}
