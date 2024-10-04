package Tutorials;

public class W1D4Tutorial {

	public static void main(String[] args) {
		calculatePaths();		
	}
     
    public static void calculatePaths() {
    
        int[][] grid = new int[6][6]; 
        grid[0][0] = 1;  

        for (int i = 0; i < grid.length; i++) {  

            for (int j = 0; j < grid.length; j++) {

                if (i > 0) {            

                    grid[i][j] += grid[i - 1][j];

                }

                if (j > 0) {              
                    grid[i][j] += grid[i][j - 1];

                }

            }

        }   

        System.out.println("Number of ways to reach A1 (grid[4][2]): " + grid[4][2]);  // Example for one "R"

        System.out.println("Number of ways to reach A2 (grid[4][4]): " + grid[5][4]);  // Example for another "R"

    }


}
