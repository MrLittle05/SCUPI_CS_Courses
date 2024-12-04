package stores;

/**
* A generic implementation of the IList iterface, that uses LinkElements.
*/

import interfaces.IList;

public class MyLinkedList<E> implements IList<E> {
    
    MyLinkedListElement<E> head;
    int count=0;
    
    public MyLinkedList() {
        this.head = null;
    }
    
    // INCOMPLETE.
    public boolean isEmpty() {
        // Returns whether the list is empty.
    	if(count==0) {
    		return true;
    	}
    	else {
            return false;
        }
    }
    
    // INCOMPLETE.
    public boolean add(E element) {
        // Adds an element to the head of the list.
    	count++;
        MyLinkedListElement<E> temp = new MyLinkedListElement<>(element);
        
        // if the list is not empty, point the new link to head
        if (head != null) {
            temp.setNext(head);
        }
        // update the head
        head = temp;
        
        return true;
    }
    
    // INCOMPLETE.
    public int size() {
        // Returns the number of elements in stored in this list.
        return count;
    }
    
    // INCOMPLETE.
    public String toString() {
        // Returns a string representation of this list.
    	String str=new String("");
    	MyLinkedListElement<E> temp = head;
   
    	while(temp!=null) {
    		if(temp.getNext()!=null) {
    			str=str+temp.toString()+", ";
                temp=temp.getNext();
            }
    		else {
    			str=str+temp.toString();
                temp=null;
    		}
        }
        return "["+str+"]";
    }
    
    // INCOMPLETE.
    public boolean addToTail(E element) {
    	count++;
        // Adds element to tail of the list
    	MyLinkedListElement<E> temp1 = head;
    	MyLinkedListElement<E> temp2 = new MyLinkedListElement<>(element);
    	if(head==null) {
    		head=temp2;
    	}
    	else {
    	while(temp1.getNext()!=null) {
            temp1=temp1.getNext();
    	}
    	temp1.setNext(temp2);
    	}
    	return true;
    }
    
    // INCOMPLETE.
    public E removeFromHead() {
        // Removes and returns the head element
    	if(head==null) {
    		return null;
    	}
    	else {
    		count--;
    		E value = head.getValue();
    		head=head.getNext();
    		return value;
    	}
    }
    
    public E removeFromTail() {
    	count--;
    	if(head==null) {
    		return null;
    	}
    	else {
    		MyLinkedListElement<E> ptr = head;
    		while(ptr.getNext()!=null) {
                ptr=ptr.getNext();
            }
    		E value = ptr.getValue();
    		ptr=null;
    		return value;
    	}
    }
    
    
    
    public E get(int index) {
        if (isEmpty() || index >= size()) {
            return null;
        }
        // Gets the element at index in the list
        MyLinkedListElement<E> ptr = head;
        for (int i = 0; i < index; i++) {
            ptr = ptr.getNext();
        }
        return ptr.getValue();
    }

    public int indexOf(E element) {
        // Gets the index of element in the list
        MyLinkedListElement<E> ptr = head;
        int i=0;
        while (ptr != null) {
            if (element.equals(ptr.getValue())) {
                return i;
            }
            i++;
            ptr = ptr.getNext();
        }
        return -1;
    }

    public E set(int index, E element) {
        if (isEmpty()) {
            return null;
        }

        // Sets element at index in the list
        MyLinkedListElement<E> ptr = head;
        MyLinkedListElement<E> prev = null;

        for (int i = 0; i < index; i++) {
            prev = ptr;
            ptr = ptr.getNext();
        }

        E ret = ptr.getValue();

        MyLinkedListElement<E> newLink = new MyLinkedListElement<>(element);
        newLink.setNext(ptr.getNext());
        if (prev != null) {
            prev.setNext(newLink);
        } else {
            head = newLink;
        }

        return ret;
    }
    
    public void clear() {
    	count=0;
        // Clears the list
        head = null;
    }
    
    public boolean contains(E element) {
        // Returns whether the element exists in the list
        return indexOf(element) != -1;
    }

    public boolean remove(E element) {
        MyLinkedListElement<E> ptr = head;
        MyLinkedListElement<E> prev = null;

        while (ptr != null) {
            if (ptr.getValue().equals(element)) {
                if (prev == null) {
                    head = ptr.getNext();
                } else {
                    prev.setNext(ptr.getNext());
                }
                count--;
                return true;
            }

            prev = ptr;
            ptr = ptr.getNext();
        }

        return false;
    }
    
    
    public static void main(String[] args) {
    	MyLinkedList<String> list = new MyLinkedList<>();
    	System.out.println(list.addToTail("hello"));
    	System.out.println(list.toString());
    	System.out.println(list.isEmpty());
    	System.out.println(list.size());
    }
    
    
}
