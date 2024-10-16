package W3D2;
/*
 * [1 point] Question 2.
Implement BuildHeap Bottom-Up.
Write your code in such a way that given an input, your program will return the number of “data item” comparisons.
 */

public class MaxHeapBottomUp{

    private static int comparisonCount = 0;    
    public static void buildMaxHeapBottomUp(int[] A) {
        int n = A.length;      
        for (int i = n / 2 - 1; i >= 0; i--) {
            downHeap(A, i, n);  
        }
    }

    
    public static void downHeap(int[] A, int j, int n) {    
        int k = maxChildIndex(A, j, n);     
        while (k != -1) {
            comparisonCount++;  
            if (A[j] < A[k]) {  
                swap(A, j, k); 
                j = k;  
                k = maxChildIndex(A, j, n);  
            } else {
                break;  
            }
        }
    }


    public static int maxChildIndex(int[] A, int j, int n) {
    	
    	/*maxChildIndex(A, j, n)
    	k = j
    	if (2j <= n && A[2j] > A[k]) k <- 2j
    	if (2j + 1 <= n && A[2j + 1] > A[k]) k <- 2j + 1
    	if (k = j) return 0 else return k */
    			
        int left = 2 * j; 
        int right = 2 * j + 1; 

        if (left >= n) return -1;
    
        if (right >= n) return left;
   
        comparisonCount++;
  
        return (A[left] > A[right]) ? left : right;
    }
 
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void main(String[] args) {
        int[] A = {3, 5, 1, 10, 2, 7, 9, 4};

        buildMaxHeapBottomUp(A);
   
        System.out.println("Max Heap:");
        for (int num : A) {
            System.out.print(num + " ");
        }
 
        System.out.println("\nTotal Comparisons: " + comparisonCount);
    }
}




