package Tutorials;

public class Average {

	public static void main(String[] args) {
	
        int[][] allNoZero = {
            {4, 6, 3, 4},
            {8, 6, 7, 9},
            {9, 10, 11, 12},
            {22, 5, 15, 16}
        };

        int[][] lowerTriangular = {
            {1, 0, 0, 0},
            {5, 6, 0, 0},
            {9, 10, 11, 0},
            {13, 14, 15, 16}
        };

        int[][] upperTriangular = {
            {0, 2, 3, 4},
            {0, 0, 7, 8},
            {0, 0, 0, 12},
            {0, 0, 0, 0}
        };

        int[][] mixedPattern = {
            {1, 2, 3, 4, 5, 6, 7, 8},
            {0, 0, 0, 0, 9, 10, 11, 12},
            {0, 0, 0, 0, 0, 0, 13, 14},
            {0, 0, 0, 0, 0, 0, 0, 15},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };

      
        System.out.println("Average of all No Zero: " + findAverage(allNoZero));
        System.out.println("Average of lowerTriangular: " + findAverage(lowerTriangular));
        System.out.println("Average of upperTriangular: " + findAverage(upperTriangular));
        System.out.println("Average of mixedPattern: " + findAverage(mixedPattern));
	}
	
	public static double findAverage(int[][] matrix) {
		int sum = 0;
		int count = 0;
		int n = matrix.length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j< matrix[i].length;j++) {
				if(matrix[i][j] != 0) {
					sum += matrix[i][j];
					count ++;
				}
			}
		}
		return (count>0) ? (double) sum/count : 0;
	}

}
