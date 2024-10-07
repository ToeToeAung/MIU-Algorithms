package Tutorials;

public class mergeSort {

	public static void main(String[] args) {
		    int[] A = {5, 8, 10, 15}; 
	        int[] B = {2, 12, 25}; 
	        int n = A.length; 
	        int m = B.length;            
	     
	        merge(A, n, B, m);	    
	 
	}
	 public static void merge(int[] A, int n, int[] B, int m) {

    int i = n - 1; 
    int j = m - 1; 
    int k = n + m - 1; 
    

    int[] C = new int[n + m];
    
    System.out.println("m: " + m + " n: " + n + " k: " + C.length);

    while (i >= 0 && j >= 0) {
        if (A[i] > B[j]) {
            C[k] = A[i];
            i--;
        } else {
            C[k] = B[j];
            j--;
        }
        k--;
    }


    while (i >= 0) {
        C[k] = A[i];
        i--;
        k--;
    }


    while (j >= 0) {
        C[k] = B[j];
        j--;
        k--;
    }


    System.out.print("Merged array C: ");
    for (int val : C) {
        System.out.print(val + " ");
    }
    System.out.println();
}

}
