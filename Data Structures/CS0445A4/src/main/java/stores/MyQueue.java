package stores;

import interfaces.IQueue;

public class MyQueue<E> implements IQueue<E> {

    private ListElement<E> head;
    private ListElement<E> tail;

    public MyQueue() {
        head = null;
        tail = null;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        ListElement<E> tmp = head;
        head = tmp.getNext();

        if (head == null) {
            tail = null;
        }

        return tmp.getValue();
    }

    public void enqueue(E value) {
        ListElement<E> tmp = new ListElement<>(value);

        if (isEmpty()) {
            tail = head = tmp;
        } else {
            tail.setNext(tmp);
            tail = tmp;
        }
    }

    //INCOMPLETE
    public E modifyHead(E value) {
        //TODO: modifies the head of the queue, and returns the previous value
    	if(head == null) {
    		ListElement<E> tmp = new ListElement<>(value);
    		head = tmp;
    		return null;
    	}
    	else {
    		E value1 = head.getValue();
    		ListElement<E> tmp = new ListElement<>(value);
    		ListElement<E> tmp2=head.getNext();
    		tmp.setNext(tmp2);
    		head=tmp;
    		return value1;
    	}
    }

    //INCOMPLETE
    public String toString() {
        //TODO: produces a String of the contents of the queue
    	String str=new String();
    	ListElement<E> temp = head;
   
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
    
    public static void main(String[] args) {
    	MyQueue<String> queue = new MyQueue<>();
    	queue.enqueue("hello");
    	queue.toString();
    	
    	queue.enqueue("world");
    	queue.toString();
    }
}
