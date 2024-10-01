package W1D2Labs;

public class W1D2Lab {
	
	public static int[] consecututiveSum1(int[] A, int k) {
		 int[] result = new int[A.length - k + 1];
	        
	        int sum = 0;
	        for (int i = 0; i < k; i++) {
	        	sum += A[i];
	        }
	        result[0] = sum;
	     
	        for (int i = k; i < A.length; i++) {
	        	sum += A[i] - A[i - k];
	            result[i - k + 1] = sum;
	        }

	        return result;
	}
	
	public static int[] consecututiveSum2(int[] A, int k) {
	      int[] result = new int[A.length - k + 1];
	        
	       
	        for (int i = 0; i <= A.length - k; i++) {
	            int sum = 0;	            
	       
	            for (int j = i; j < i + k; j++) {
	                sum += A[j];
	            }
	            	        
	            result[i] = sum;
	        }

	        return result;
	}
	
	
	public static void main(String[] args) {
		//Test case 1
		int k=3;
		int[] arr = {12, 7, 21, 5, 14, 6, 9, k};
        int[] sum = consecututiveSum1(arr, 3);

        System.out.print("Test Case 1 \n");
        for (int s : sum) {
            System.out.print(s + " ");
        }
        
        System.out.print("\n****************\n");
        //Test case 2
    	int[] arr1 = {5, 7, 9, 9, 3, 2, 6, 3};
        int[] sum1 = consecututiveSum2(arr1, k);

        System.out.print("Test Case 2 \n");
        for (int s : sum1) {
            System.out.print( s + " ");
        }
	}

}
