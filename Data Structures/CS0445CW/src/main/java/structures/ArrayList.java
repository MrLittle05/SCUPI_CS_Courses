package structures;

public class ArrayList<E>  {
    private Object[] array;
    private int size;
    private int capacity;
    
    public ArrayList() {
        this.capacity = 100;
        this.array = new Object[capacity];
        this.size = 0;
    }
    
    public boolean add(E element) {
        try {
             if (this.size >= this.capacity) {
                this.capacity = (capacity * 2);
                Object[] tmp = new Object[this.capacity];
                for (int i = 0; i < this.size; i++) {
                    tmp[i] = this.array[i];
                }        
                this.array = tmp;
            }

            this.array[size] = element;
            this.size++;

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(this.array[i])) {return true;}
        }
        return false;
    }

    public void clear() {
        this.capacity = 100;
        this.array = new Object[capacity];
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public int size() {
        return size;
    }
    
    
    @SuppressWarnings("unchecked") 
    public E get(int index) {
        return (E) this.array[index];
    }
    
    public int indexOf(E element) {
        for (int i=0;i<this.size();i++) {
            if (element.equals(this.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int index) {
        if (index >= 0) {
            for (int i=index+1;i<this.size();i++) {
                this.set(i-1, this.get(i));
            }
            this.array[size-1] = null;
            size--;
            return true;
        }
        return false;
    }
    

    public E set(int index, E element) {
        if (index >= this.size()) {
            throw new ArrayIndexOutOfBoundsException("index > size: "+index+" >= "+size);
        }
        E replaced = this.get(index);
        this.array[index] = element;
        return replaced;
    }
    
}
