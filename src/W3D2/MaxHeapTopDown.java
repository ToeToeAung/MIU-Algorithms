package W3D2;
/*
 * [1 point] Question 1.
Implement BuildHeap Top-Down.
Write your code in such a way that given an input, your program will return the number of “data item” comparisons.
 */
public class MaxHeapTopDown {	
	  private static int comparisonCount = 0;
    public static void buildMaxHeapTopDown(int[] A, int n) {

        for (int i = 1; i < n; i++) {
            upHeap(A, i);  
        }
    }

    public static void upHeap(int[] A, int i) {
        int j = i;
        while (j > 0) {
            int parent = (j - 1) / 2;  
            comparisonCount++;  

            if (A[j] > A[parent]) { 
                swap(A, j, parent);
                j = parent;  
            } else {
                break;  
            }
        }
    }
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
	public static void main(String[] args) {
		 int[] A = {3, 5, 1, 10, 2, 7};
	        int n = A.length;
	        buildMaxHeapTopDown(A, n);
	        System.out.println("Max Heap Top Down:");
	        for (int num : A) {
	            System.out.print(num + " ");
	        }
	        
	        System.out.println("\nTotal Comparisons: " + comparisonCount);
	}
}
