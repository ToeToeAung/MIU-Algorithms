package LeetCode;

public class NQueenProblem {
    static final int N = 4;
    static final boolean singleSolution = false;

    //Function to check whether it is safe to place a queen at board(row, col).
    static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check this row on the left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static boolean solveNQUtil(int board[][], int col) {
        //Trying to place the queen in column col.
    	if (col >= N)             //This means all columns are completed.
            return singleSolution;
   	  

        //In the current column col, we are trying our option at row 0 to N-1.
    	for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;         //Found a good row, Place Queen, Go FWD. 
                if (solveNQUtil(board, col + 1))
                    return true;
                
                printSolution(board);         //This is a partial solution
                System.out.println("\tBacktrack Now");
                board[i][col] = 0; // row = i tried. Now need to try i + 1
            }
        }

        return false;
    }

    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int board[][] = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.println("\tBacktracking done!");
            return;
        }

        printSolution(board);
    }
}