package LeetCode;

public class RotateMatrix {

	public static void main(String[] args) {
		   int[][] matrix = {
		            {1, 2, 3},
		            {4, 5, 6},
		            {7, 8, 9}
		        };

		       // System.out.println("Original matrix:");
		       // printMatrix(matrix);

		        rotate(matrix);

		        System.out.println("Rotated matrix:");
		        printMatrix(matrix);
	}
	
	  public static void rotate(int[][] matrix) {
	        int n=matrix.length;
	        for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
	                
	                int temp=matrix[i][j];
	                matrix[i][j]=matrix[j][i];
	                matrix[j][i]=temp;
	            }
	        }       
	        for(int i=0;i<n;i++){
	            int left=0;
	            int right=n-1;  
	            while(left<right){
	               int temp=matrix[i][left];
	               matrix[i][left]=matrix[i][right];
	               matrix[i][right]=temp;
	                  left++;
	            right--;
	            }
	          
	        }        
	        
	    }
	
	private static void printMatrix(int[][] matrix) {
		for(int[] nums : matrix) {
			for(int num : nums) {
				System.out.println(num + " ");
			}
		}
		System.out.println();
	}

}
