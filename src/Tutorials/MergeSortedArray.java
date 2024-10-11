package Tutorials;

public class MergeSortedArray {
	public static void merge(int[] A, int n, int[] B, int m) {
        int i = n - 1;
        int j = m - 1; 
        int k = n + m - 1; 
     
        while (j >= 0) {
            if (i >= 0 && A[i] > B[j]) {
                A[k] = A[i];
                i--;
            } else {
                A[k] = B[j];
                j--;
            }
            k--;
        }
    }

	public static void main(String[] args) {
		 int[] A = {5, 8, 10, 15, 0, 0, 0};
	        int[] B = {2, 12, 25};
	        int n = 4; 
	        int m = 3; 

	        merge(A, n, B, m);
	    
	        for (int num : A) {
	            System.out.print(num + " ");
	        }
	}

}
