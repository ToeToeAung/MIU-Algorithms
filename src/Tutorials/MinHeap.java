package Tutorials;
import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;
  
    public MinHeap() {
        heap = new ArrayList<>();
    }
  
    private int parent(int index) {
        return (index - 1) / 2;
    }


    private int leftChild(int index) {
        return 2 * index + 1;
    }


    private int rightChild(int index) {
        return 2 * index + 2;
    }

 
    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;


        while (current > 0 && heap.get(current) < heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

 
    public int removeMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty!");
        }


        int min = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));

    
        heapifyDown(0);
        return min;
    }


    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

  
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }


        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }


    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }


    public void displayHeap() {
        System.out.println("Heap: " + heap);
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(67);
        minHeap.insert(9);
        minHeap.insert(8);

        System.out.println("After inserting elements:");
        minHeap.displayHeap();

        System.out.println("Removed Min: " + minHeap.removeMin());
        minHeap.displayHeap();
    }
}
