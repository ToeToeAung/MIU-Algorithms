package LeetCode;

public class Countsquaresubmatriceswithallones {

	public static void main(String[] args) {
		int[][] matrix = {
				  {1,0,1},
				  {1,1,0},
				  {1,1,0}
				  };
		int count =countSquares(matrix);
		System.out.println("Square count " + count);

	}
	 public static int countSquares(int[][] matrix) {
	        int result = 0, n = matrix.length, m = matrix[0].length;
	        int[][] dp = new int[n + 1][m + 1];
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (matrix[i][j] == 1) {
	                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i][j])) + 1;
	                    result += dp[i + 1][j + 1];
	                }
	            }
	        }

	        return result;
	    }
}
