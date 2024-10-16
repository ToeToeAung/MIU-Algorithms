package W3D2;

public class MaxHeapTopDown {	
    public static void buildMaxHeapTopDown(int[] A, int n) {

        for (int i = 1; i < n; i++) {
            upHeap(A, i);  
        }
    }

    public static void upHeap(int[] A, int i) {
        int j = i;
        while (j > 0 && A[(j - 1) / 2] < A[j]) {
  
            swap(A, j, (j - 1) / 2);
          
            j = (j - 1) / 2;
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

	}

}
