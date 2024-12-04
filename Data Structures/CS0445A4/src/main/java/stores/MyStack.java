package stores;

import interfaces.IStack;

public class MyStack<E> implements IStack<E> {
	
	DoublyLinkedList<E> stack=new DoublyLinkedList<E>();
    // INCOMPLETE.
    public void push(E val) {
        //  TODO: implement pushing
    	stack.addToHead(val);
    }

    // INCOMPLETE.
    public E pop() {
        //  TODO: implement popping
    	if(stack.isEmpty()) {
            return null;
        }
        else {
        	E val=stack.getHead().getValue();
        	stack.removeFromHead();
            return val;
        }
    }

    // INCOMPLETE
    public boolean isEmpty() {
        //  TODO: check whether list is empty
    	if(stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    //INCOMPLETE
    public String toString() {
        // TODO: produces a String of the contents of the queue
    	String str=new String("");
    	ListElement<E> temp = stack.getHead();
   
    	while(temp!=null) {
    		if(temp.getNext()!=null) {
    			str=str+temp.getValue().toString()+", ";
                temp=temp.getNext();
            }
    		else {
    			str=str+temp.getValue().toString();
                temp=null;
    		}
        }
        return "["+str+"]";
    }
}
