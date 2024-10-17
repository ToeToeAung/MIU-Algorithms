package W3D2;

public class HeapSortPhaseTwo {
    static int comparisonCount = 0;

    public static void heapSort(int[] array) {
        int n = array.length;
       
        for (int i = n / 2 - 1; i >= 0; i--) {
        	buildMaxHeap(array, n, i);
        }
    
        for (int i = n - 1; i >= 0; i--) {
            swap(array, 0, i); 
            buildMaxHeap(array, i, 0); 
        }
    }

    private static void buildMaxHeap(int[] array, int n, int i) {
        int maxElement = i;

        while (true) {
            int left = 2 * i + 1;  
            int right = 2 * i + 2; 
          
            if (left < n && array[left] > array[maxElement]) {
                comparisonCount++; 
              
                    maxElement = left;
                
            }
      
            if (right < n && array[right] > array[maxElement]) {
                comparisonCount++;        
                    maxElement = right;            
            }
        
            if (maxElement != i) {
                swap(array, i, maxElement);
                i = maxElement;
            } else {
                break; 
            }
        }
    }
 
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {  
        int[] dataSet1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        testingHeapSort(dataSet1, "Data Set 1");

        int[] dataSet2 = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
        testingHeapSort(dataSet2, "Data Set 2");

        int[] dataSet3 = {4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        testingHeapSort(dataSet3, "Data Set 3");

        int[] dataSet4 = {5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
        testingHeapSort(dataSet4, "Data Set 4");
    }

  
    private static void testingHeapSort(int[] dataSet, String dataSetName) {
        comparisonCount = 0; 
        System.out.println("Original array of " + dataSetName + ":");
        printArray(dataSet);
        heapSort(dataSet);
        System.out.println("Sorted array of " + dataSetName + ":");
        printArray(dataSet);
        System.out.println("Total comparisons of " + dataSetName + ": " + comparisonCount);
        System.out.println("\n***************************************");
    }
}
