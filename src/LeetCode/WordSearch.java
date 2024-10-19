package LeetCode;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][]  board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		boolean found=false;
		found=existWordSearch(board,word);
		System.out.println("Word found " + found);

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
	        System.out.println("Indexes "+ rowIndex  + ": " + colIndex + " - " + wordIndex);
	        System.out.println("Each Word at row and col index nad word index " + currentChar +" - "+ wordChar);
	        if(wordChar==currentChar){
	            if(wordIndex+1 == word.length()){
	                return true;
	            }
	            board[rowIndex][colIndex] = '*';
	            
	            for(int i=-1;i<2;i++){
	                for(int j=-1;j<2;j++){
	                    boolean validI = (i==-1 || i==+1) && j==0;
	                    boolean validJ = i == 0 && (j==-1 || j==+1);
	                    if( validI || validJ ){
	                        int row = rowIndex+i;
	                        int col = colIndex +j;
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
