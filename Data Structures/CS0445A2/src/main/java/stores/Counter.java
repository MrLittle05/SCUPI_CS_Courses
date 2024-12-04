package stores;

import interfaces.ICounter;

/**
* A generic implementation of the ICounter iterface.
*/
public class Counter<E> implements ICounter<E> {

    MyArrayList<Count<E>> counts = new MyArrayList<>();
    int size=0;
    // INCOMPLETE.
    public int getCount(E element) {
    	if(find(element)==null) {
    		return 0;
    	}
        // Returns the count of an item (the number of times it was added to the list).
    else
        return find(element).getCount();
    }

    // INCOMPLETE.
    public boolean add(E element) {
        Count<E> count = find(element);
        if (count == null) {
            // If the element does not exist, add it as a new count object to counts.
        	counts.add(new Count<E>(element,1));
        } else {
            // If the element does exist, increment its count value.
        	count.incrementCount();
        }
        size++;
        return true;
    }

    // INCOMPLETE.
    public int size() {
        // Returns the total count of all items in the list.
        return size;
    }

    // Returns the count object related to element.
    // Returns null if the element does not exist.
    private Count<E> find(E element) {
        for (int i=0;i<counts.size();i++) {
            if (counts.get(i).getObj().equals(element)) {
                return counts.get(i);
            }
        }
        return null;
    }

    public void clear() {
        counts.clear();
        size=0;
    }

    public boolean contains(E element) {
        return find(element) != null;
    }

    public boolean isEmpty() {
        return counts.isEmpty();
    }

    public boolean remove(E element) {
        Count<E> count = find(element);
        if (count == null) return false;
        else {
        	size--;
        	return counts.remove(count);
        }
    }

}
