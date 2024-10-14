package Tutorials;
import java.util.ArrayList;
import java.util.Arrays;

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

    
     public static void insertMaxHeap(int[] A, int n, int value) {
    	 if (n >= A.length - 1) {
             A = Arrays.copyOf(A, A.length + 1);  // Resize the array
         }
    	 
    	 System.out.print("N" + A.length + "\n");
    	 A[n]= value;    	 
    	 int i = n;
    	 int parent =  (int)Math.floor((n/2));
    	 if(A[parent] < A[i]) {
    		 int temp = A[parent];
    		 A[parent] = A[i];
    		 A[i] = temp;
    	 }else {
    		 return;
    	 }
    	 
    	 for (int a : A) {
             System.out.println("Heap " + a);
         }
     }

    public static void main(String[] args) {          
        
        int[] A= {70,50,40,45,35,39,16,10,9};
        insertMaxHeap(A,9,60);  
        
        }
    
}
