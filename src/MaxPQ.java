import java.util.*;

public class MaxPQ {

    public Object[] heap;
    public int size;
    public Comparator comparator;
    private static final int DEFAULT_CAPACITY = 4;
    private static final int AUTOGROW_SIZE = 4;
    public MaxPQ(Comparator comparator) {
        this.heap = new Object[DEFAULT_CAPACITY + 1];
        this.size = 0;
        this.comparator = comparator;
    }

    public void add(Object item) {
        if (size == heap.length - 1)
            grow();
        heap[++size] = item;
        swim(size);
    }

    public Object peek() {
        if (size == 0)
            return null;
        return heap[1];
    }

    public Object getMax() {
        if (size == 0)
            return null;
        Object root = heap[1];
        heap[1] = heap[size];
        size--;
        sink(1);
        return root;
    }

    private void swim(int i) {
        if (i == 1)
            return;
        int parent = i / 2;
        while (i != 1 && comparator.compare(heap[i], heap[parent]) > 0) {
            swap(i, parent);
            i = parent;
            parent = i / 2;
        }
    }

    private void sink(int i) {
        int left = 2 * i;
        int right = left + 1;
        if (left > size)
            return;
        while (left <= size) {
            int max = left;
            if (right <= size) {
                if (comparator.compare(heap[left], heap[right]) < 0)
                    max = right;
            }
            if (comparator.compare(heap[i], heap[max]) >= 0)
                return;
            else {
                swap(i, max);
                i = max;
                left = i * 2;
                right = left + 1;
            }
        }
    }
    private void swap(int i, int j) {
        Object tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void grow() {
        Object[] newHeap = new Object[heap.length + AUTOGROW_SIZE];
        for (int i = 0; i <= size; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

}
