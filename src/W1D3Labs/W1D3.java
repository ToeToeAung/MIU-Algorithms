package W1D3Labs;
/*
Question 1. Write an algorithm
beautiful(A, n)
Input : An integer array with n elements
such that the best-case running time is equal to the worst-case running time. Write the algorithm and give your analysis to justify your claim.
Question 2. Order them based on their complexity.
2^n , 2^(2n), 2^(n + 1), 2^( 2^n ) (Note: ^ stands for exponent operation. Example: 2^n = 2n )
Question 3. Mention one algorithm you know for each of the time complexities listed.
O(1), O(log n), O(n), O(n log n), O(n2), O(n3), O(2n)
Question 4. Apply Master Theorem and determine the time complexity of
fib(n) shown in Lesson 2. If you cannot apply Master Theorem please give detailed explanation.

 * */
public class W1D3 {

	public static void main(String[] args) {
        int[] A = {7, 2, 9, 4, 5,11,8};
        int n = A.length;        
        System.out.println("Question 1. *********** ");
        System.out.println("Sum of the elements in the array: " + beautiful(A, n));
        
        System.out.println("Question 3. O(n) *********** ");
        int constantNum = printConstantNumber(A);
        System.out.println("Question 3. O(n) Value " +constantNum);
        
        System.out.println("Question 3. O(log n) *********** ");
        int foundAt = binarySearch(A,4);
        System.out.println("Question 3. O(log n) found element at " + foundAt);
        
        
	}
	/*Question 1*/
	public static int beautiful(int[] A,int n) {
		int total=0;
		for(int i=0;i<A.length;i++) {
			total += A[i];
		}		
		return total;
	}
	 
	/*Question 3 -> O(1) */
	public static int printConstantNumber(int[] arr) {
        int element = arr[3];  
        System.out.println("The constant element at index 3: " + element);
        return element;
	}
	
	/*Question 3 ->  O(log n) */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return -1;  
    }

	/*Question 3 ->  O(n) */   
        public static int findMax(int[] arr) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        }

 
     /*Question 3 ->  O(n log n)  */        
        
        public static void mergeSort(int[] array, int left, int right) {
            if (left < right) {             
                int middle = left + (right - left) / 2;         
                mergeSort(array, left, middle);       
                mergeSort(array, middle + 1, right);             
                merge(array, left, middle, right);
            }
        }
        
        /*Question 3 ->  O(n log n)  */ 
        public static void merge(int[] array, int left, int middle, int right) {
          
            int merge1Length= middle - left + 1;
            int merge2Length = right - middle;
        
            int[] leftArray = new int[merge1Length];
            int[] rightArray = new int[merge2Length];

            for (int i = 0; i < merge1Length; ++i)
                leftArray[i] = array[left + i];
            for (int j = 0; j < merge2Length; ++j)
                rightArray[j] = array[middle + 1 + j];

        
            int i = 0, j = 0;
            int k = left;
         
            while (i < merge1Length && j < merge2Length) {
                if (leftArray[i] <= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }

       
            while (i < merge1Length) {
                array[k] = leftArray[i];
                i++;
                k++;
            }
        
            while (j < merge2Length) {
                array[k] = rightArray[j];
                j++;
                k++;
            }
        }

        
     /*Question 3 ->  O(n^2)  */ 
       public static void bubbleSort(int[] A) {
    	   int n= A.length -1;    			   
    	   for(int i=0;i<n-1;i++) {
    		   for(int j=0;j<n-i-1;j++) {
    			   if(A[j]>A[j+1]) {
    				   int temp = A[j+1];
    				   A[j+1] = A[j];
    				   A[j] = temp;
    			   }
    		   }
    	   }
       }
     /*Question 3 ->  O(n^3)  */ 
       public static int[][] multiplyMatrix(int[][] A,int[][] B,int n) {
    	   	int[][] result = new int[n][n];
    	   	
    	   	for(int i=0;i<n;i++) {
    	   		for(int j=0;j<n;j++) {
    	   			for(int k=0;k<n;k++) {
    	   				result[i][j] += A[i][k] * B[k][j];
    	   			}
    	   		}
    	   	}
    	   	return result;
       }
       
     /*Question 3 ->  O(2^n)  */ 
       
       public static int fib(int n) {
    	   
    	   if(n <= 1) {
    		   return n;
    	   }
    	   
    	   return fib(n) + fib(n-1);
       }
       
       
}
