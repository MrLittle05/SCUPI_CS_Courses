import org.junit.jupiter.api.Test;

import stores.MyArrayList;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    private MyArrayList<String> myArrayList = new MyArrayList<>();

    @BeforeEach
    public void setupMyArrayList() {
        myArrayList = new MyArrayList<>();
    }

    @Test
    void testAddPos() {
        assertTrue(myArrayList.add("hello"));
    }

    @Test
    void testContainsPos() {
        myArrayList.add("hello");
        assertTrue(myArrayList.contains("hello"));
    }

    @Test
    void testContainsNegEmpty() {
        assertFalse(myArrayList.contains("hello"));
    }

    @Test
    void testContainsNegNonEmpty() {
        myArrayList.add("hello");
        assertFalse(myArrayList.contains("world"));
    }

    @Test
    void testClearEmpty(){
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    void testClearNotEmpty() {
        myArrayList.add("hello");
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    void testIsEmptyPos() {
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    void testIsEmptyNeg() {
        myArrayList.add("hello");
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    void testSizeEmpty() {
        assertTrue(myArrayList.size() == 0);
    }

    @Test
    void testSizeNotEmpty() {
        myArrayList.add("hello");
        assertTrue(myArrayList.size() == 1);
    }

    @Test
    void testGetPos() {
        myArrayList.add("hello");
        myArrayList.add("world");
        assertTrue(myArrayList.get(0).equals("hello"));
        assertTrue(myArrayList.get(1).equals("world"));
    }

    @Test
    void testGetNeg(){
        myArrayList.add("hello");
        myArrayList.add("world");
        assertFalse(myArrayList.get(0).equals("world"));
        assertFalse(myArrayList.get(1).equals("hello"));
    }

    @Test
    void testIndexOfPos() {
        myArrayList.add("hello");
        myArrayList.add("world");
        assertTrue(myArrayList.indexOf("hello") == 0);
        assertTrue(myArrayList.indexOf("world") == 1);
    }

    @Test
    void testIndexOfNeg() {
        myArrayList.add("hello");
        myArrayList.add("world");
        assertFalse(myArrayList.indexOf("hello") == 1);
        assertFalse(myArrayList.indexOf("world") == 0);
    }

    @Test
    void testIndexOfNonexist() {
        myArrayList.add("hello");
        myArrayList.add("world");
        assertTrue(myArrayList.indexOf("foo") == -1);
    }

    @Test
    void testRemovePos() {
        myArrayList.add("hello");
        assertTrue(myArrayList.remove("hello"));
    }

    @Test
    void testRemoveNeg(){
        myArrayList.add("hello");
        assertFalse(myArrayList.remove("world"));
    }

    @Test
    void testRemoveEmpty() {
        assertFalse(myArrayList.remove("hello"));
    }

    @Test
    void testSetPos() {
        myArrayList.add("hello");
        try{
            assertTrue(myArrayList.set(0, "world").equals("hello"));
        } catch(Exception e) {
            assertTrue(false, "Threw error: " + e.toString());
        }
    }

    @Test
    void testSetNeg() {
        myArrayList.add("hello");
        try{
            assertFalse(myArrayList.set(0, "world").equals("world"));
        } catch(Exception e) {
            assertTrue(false, "Threw error: " + e.toString());
        }
    }

    @Test
    void testSetOutOfBounds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {myArrayList.set(0, "hello");});
    }

    @Test
    void testToStringPos() {
        myArrayList.add("hello");
        assertTrue(myArrayList.toString().equals("[hello]"));
    }

    @Test
    void testToStringEmpty() {
        assertTrue(myArrayList.toString().equals("[]"));
    }
}
