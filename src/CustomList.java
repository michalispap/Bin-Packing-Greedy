import java.util.*;
public class CustomList<E> {

    public int size = 0;
    private static final int DEFAULT_CAPACITY = 1000;
    public Object elements[];
    public CustomList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public E remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = elements[i];
        int numElts = elements.length - ( i + 1 ) ;
        System.arraycopy( elements, i + 1, elements, i, numElts ) ;
        size--;
        return (E) item;
    }

    public int size() {
        return size;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        //sb.append('[');
        for(int i = 0; i < size ;i++) {
            sb.append(elements[i].toString());
            if(i<size-1){
                sb.append(" ");
            }
        }
        //sb.append(']');
        return sb.toString();
    }

    public void ensureCapacity() {
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements, newSize);
    }

}