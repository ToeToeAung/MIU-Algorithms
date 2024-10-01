package W1D2Labs;

public class W1D2Lab {
	
	public static int[] consecututiveSum(int[] A, int k) {
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
	
	public static void main(String[] args) {
		int[] arr = {5, 7, 9, 9, 3, 2, 6, 3};
        int[] sum = consecututiveSum(arr, 3);

      
        for (int s : sum) {
            System.out.print(s + " ");
        }
	}

}
