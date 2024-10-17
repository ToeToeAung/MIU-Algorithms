package W3D2;

public class HeapSortPhaseTwo {

    private static int comparisonCount = 0;


    public static int heapSortPhaseTwo(int[] A) {
        comparisonCount = 0;
        int n = A.length - 1;

        buildMaxHeapBottomUp(A, n);

        for (int i = n; i >= 2; i--) {
            swap(A, 1, i);
            downHeap(A, 1, i - 1); 
        }

        return comparisonCount;
    }

      public static void buildMaxHeapBottomUp(int[] A, int n) {
        for (int i = n / 2; i >= 1; i--) {
            downHeap(A, i, n);
        }
    }
   
    public static void downHeap(int[] A, int i, int n) {
        int j = i;
        int k = maxChildIndex(A, j, n);
        while (k != 0) {
            swap(A, j, k);
            j = k;
            k = maxChildIndex(A, j, n);
        }
    }

    public static int maxChildIndex(int[] A, int j, int n) {
        int k = j;
        int leftChild = 2 * j;
        int rightChild = 2 * j + 1;

        if (leftChild <= n && A[leftChild] > A[k]) {
            comparisonCount++;
            k = leftChild;
        }
        if (rightChild <= n && A[rightChild] > A[k]) {
            comparisonCount++;
            k = rightChild;
        }

        return (k == j) ? 0 : k;  
    }

  
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
   
    public static void printArray(int[] A) {
        for (int i = 1; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
    	 int comparisons=0;
    	 int[] dataSet1 = {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        System.out.println("Original array of Data Set 1 :");
        printArray(dataSet1);

        comparisons= heapSortPhaseTwo(dataSet1);

        System.out.println("Sorted array of Data Set 1:");
        printArray(dataSet1);

        System.out.println("Total comparisons of Data Set 1: " + comparisons);
        
        System.out.println("*************************************");
        
        int[] dataSet2 = {0,2,1,4,3,6,5,8,7,10,9,12,11,14,13,16,15};   
        comparisons=0;
        System.out.println("Original array of Data Set 2 :");
        printArray(dataSet2);

        comparisons= heapSortPhaseTwo(dataSet2);

        System.out.println("Sorted array of Data Set 2:");
        printArray(dataSet2);

        System.out.println("Total comparisons of Data Set 2: " + comparisons);
        
        System.out.println("*************************************");
        
        int[] dataSet3 = {0,4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        comparisons=0;
        System.out.println("Original array of Data Set 3 :");
        printArray(dataSet3);

        comparisons= heapSortPhaseTwo(dataSet3);

        System.out.println("Sorted array of Data Set 3:");
        printArray(dataSet2);

        System.out.println("Total comparisons of Data Set 3: " + comparisons);
        
        System.out.println("*************************************");
        
 		int[] dataSet4 = {0,5,6,7,4,2,3,1,8,11,13,14,16,10,12,11,9};   
        comparisons=0;
        System.out.println("Original array of Data Set 4 :");
        printArray(dataSet4);

        comparisons= heapSortPhaseTwo(dataSet4);

        System.out.println("Sorted array of Data Set 4:");
        printArray(dataSet4);

        System.out.println("Total comparisons of Data Set 4: " + comparisons);
    }
}
