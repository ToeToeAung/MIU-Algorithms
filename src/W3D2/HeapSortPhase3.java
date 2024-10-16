package W3D2;
/*
 * [1 point] Question 3.
Implement Heapsort Phase 2. Write your code in such a way that given an input, your program will return the number of “data item” comparisons. 
Note that your Heapsort will first call BuildHeap Bottom-Up you had implemented as part of Question 2.
 * */
public class HeapSortPhase3 {

    private static int comparisonCount = 0;  

  
    public static void buildMaxHeapBottomUp(int[] A, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            downHeap(A, i, n);
        }
    }
  
    public static void downHeap(int[] A, int j, int n) {      
        int k = maxChildIndex(A, j, n);        
        while (k != 0) {
            comparisonCount++; 
            if (A[j] < A[k]) {  
                swap(A, j, k);
            } else {
                break;  
            }
      
            j = k;
            k = maxChildIndex(A, j, n); 
        }
    }

  
    public static int maxChildIndex(int[] A, int j, int n) {
    	 int left = 2 * j + 1;
         int right = 2 * j + 2;
         if (left >= n) return 0;  
         if (right >= n) return left;  

         comparisonCount++; 
         return (A[left] > A[right]) ? left : right;
    }
   
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

   
    public static void heapsort(int[] A) {
        int n = A.length;    
        buildMaxHeapBottomUp(A, n);   
        for (int i = n - 1; i > 0; i--) {
            swap(A, 0, i);  
            downHeap(A, 0, i);  
        }
    }

  
    public static void main(String[] args) {
        int[] dataSet1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};         
        heapsort(dataSet1);    
        System.out.println("HeapSort - Sorted DataSet 1:");
        for (int num : dataSet1) {
            System.out.print(num + " ");
        }      
        System.out.println("\nTotal Comparisons for Data Set 1 : " + comparisonCount);
        
        System.out.println("\n ************************************");
        
        int[] dataSet2 = {2,1,4,3,6,5,8,7,10,9,12,11,14,13,16,15};   
        comparisonCount=0;
        heapsort(dataSet2);    
        System.out.println("HeapSort - Sorted DataSet 2:");
        for (int num : dataSet2) {
            System.out.print(num + " ");
        }      
        System.out.println("\nTotal Comparisons for Data Set 2 : " + comparisonCount);
        
        System.out.println("\n ************************************");
        
        int[] dataSet3 = {4,2,3,1,5,8,7,6,11,10,12,9,13,14,16,15};   
        comparisonCount=0;
        heapsort(dataSet3);    
        System.out.println("HeapSort - Sorted DataSet 3:");
        for (int num : dataSet3) {
            System.out.print(num + " ");
        }      
        System.out.println("\nTotal Comparisons for Data Set 3 : " + comparisonCount);
        
        System.out.println("\n ************************************");
        int[] dataSet4 = {5,6,7,4,2,3,1,8,11,13,14,16,10,12,11,9};   
        comparisonCount=0;
        heapsort(dataSet4);    
        System.out.println("HeapSort - Sorted DataSet 4:");
        for (int num : dataSet4) {
            System.out.print(num + " ");
        }      
        System.out.println("\nTotal Comparisons for Data Set 4 : " + comparisonCount);
    }
}

