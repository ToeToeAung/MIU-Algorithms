package LeetCode;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][]  board = {
		{'A','B','C','E'}
		,{'S','F','C','S'}
		,{'A','D','E','E'}};
		String word = "ABCCED";
		boolean found=false;
		found=existWord(board,word);
		System.out.println("Word found " + found);

	}
	
	 public static boolean existWord(char[][] board, String word) {
	        int m = board.length;
	        int n = board[0].length;
	        int W = word.length();
	        System.out.println("m n W " + m + " - " + n + " - " + " W " + W);
	        if (m == 1 && n == 1) {
	            return board[0][0] == word.charAt(0);
	        }

	        boolean[][] visited = new boolean[m][n];

	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (backtrack(board, word, i, j, 0, visited)) {
	                    return true;
	                }
	            }
	        }

	        return false;
	    }
	 
	  private static boolean backtrack(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
	        if (index == word.length()) return true;

	        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
	            return false;
	        }

	        visited[i][j] = true;

	        boolean found = backtrack(board, word, i + 1, j, index + 1, visited) ||
	                        backtrack(board, word, i - 1, j, index + 1, visited) ||
	                        backtrack(board, word, i, j + 1, index + 1, visited) ||
	                        backtrack(board, word, i, j - 1, index + 1, visited);
	        
	        System.out.println("i  j index " + i + " - " + j + " -" + index);
	        
	        visited[i][j] = false;
	        
	        return found;
	    }
	  public static boolean existWordSearch(char[][] board, String word) {
	        int m = board.length;
	        int n = board[0].length;
	        
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                boolean found = isSubStringFound(board,word, 0,i,j,m,n );
	                if(found){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    private static boolean isSubStringFound(char[][] board, String word, int wordIndex, int rowIndex, int colIndex, int m, int n){
	        char currentChar = board[rowIndex][colIndex];
	        char wordChar = word.charAt(wordIndex);
	        System.out.println("Word "+ word);
	        System.out.println("**************************************");
	        System.out.println("Indexes row : "+ rowIndex  + " col : " + colIndex + " - " + wordIndex);
	        System.out.println("**************************************");
	        System.out.println("Each Word at row and col index and word index " + currentChar +" - "+ wordChar);
	        if(wordChar==currentChar){
	            if(wordIndex+1 == word.length()){
	                return true;
	            }
	            board[rowIndex][colIndex] = '*';
	            
	            for(int i=-1;i<2;i++){
	                for(int j=-1;j<2;j++){
	                    boolean validI = (i==-1 || i==+1) && j==0;
	                    System.out.println("Valid I "+ validI);
	                    boolean validJ = i == 0 && (j==-1 || j==+1);
	                    System.out.println("Valid J "+ validJ);
	                    if( validI || validJ ){
	                        int row = rowIndex+i;
	                        int col = colIndex +j;
	                        System.out.println("Row and Col " + row + " , "+ col);
	                        if(row>=0 && row<m && col>=0 && col<n){
	                            boolean found = isSubStringFound(board,word,wordIndex+1,row,col,m,n);
	                            if(found){
	                                return true;
	                            }
	                        }
	                    }
	                }
	            }
	            
	            board[rowIndex][colIndex] = currentChar;
	        } 
	            return false;
	        
	    }
		
}
