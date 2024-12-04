import org.junit.jupiter.api.Test;

import stores.MyLinkedListElement;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListElementTest {
    private MyLinkedListElement<String> myElement = new MyLinkedListElement<>("hello");

    @BeforeEach
    public void setupMyLinkedListElement() {
        myElement = new MyLinkedListElement<>("hello");
    }

    @Test
    void testGetNextDefault() {
        assertTrue(myElement.getNext() == null);
    }

    @Test
    void testGetNextAfterSet() {
        MyLinkedListElement<String> next = new MyLinkedListElement<>("world");
        myElement.setNext(next);
        assertTrue(myElement.getNext() == next);
    }

    @Test
    void testGetValueDefault() {
        assertTrue(myElement.getValue() == "hello");
    }

    @Test
    void testGetValueAfterSet() {
        myElement.setValue("world");
        assertTrue(myElement.getValue() == "world");
    }

    @Test
    void testSetValue() {
        myElement.setValue("world");
        assertTrue((myElement.toString().equals("world")) & (myElement.getValue() == "world"));
    }

    @Test
    void testSetNext() {
        MyLinkedListElement<String> next = new MyLinkedListElement<>("world");
        myElement.setNext(next);
        assertTrue((myElement.getNext() != null) && (myElement.getNext().toString().equals("world")) && (myElement.getNext().getValue() == "world"));
    }

    @Test
    void testToString() {
        assertTrue(myElement.toString().equals("hello"));
    }
}
