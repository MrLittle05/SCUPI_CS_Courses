import org.junit.jupiter.api.Test;

import stores.Count;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class CountTest {
    private Count<String> myCount = new Count<>("hello", 1);

    @BeforeEach
    public void setCount() {
        myCount = new Count<>("hello", 1);
    }

    @Test
    void testIncrementCount() {
        myCount.incrementCount();
        assertTrue(myCount.getCount() == 2);
    }

    @Test
    void testGeCount() {
        assertTrue(myCount.getCount() == 1);
    }

    @Test
    void testGetObj() {
        assertTrue(myCount.getObj().equals("hello"));
    }

    @Test
    void testObjectEqualsPos() {
        assertTrue(myCount.objectEquals("hello"));
    }

    @Test
    void testObjectEqualsNeg() {
        assertFalse(myCount.objectEquals("world"));
    }
}
