package LeetCode;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) {

		int[][] points = {{3,3},{5,-1},{-2,4}};
		int k=2;
		int[][] output=new int[k][2];
		output=kClosest(points,k);
		
		for(int[] p: output) {
			for(int i=0;i<p.length;i++) {
				System.out.println(p[i]);
			}	
		}
		String str= "tree";
		String result = "";
		result= FrequencySort(str);
		System.out.println(result);
		
		char[][] grid = {{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};
		
		int numOfIsland1 = numIslands(grid);
		System.out.println("Number of islands 1 ** "+ numOfIsland1);
		char[][] grid1 = {
				  {'1','1','0','0','0'},
				  {'1','1','0','0','0'},
				  {'0','0','1','0','0'},
				  {'0','0','0','1','1'}
				};
		
		int numOfIsland2 = numIslands(grid1);
		System.out.println("Number of islands 2 ** "+ numOfIsland2);
		
	  int[][] grid3={{0,0,1,0,0,0,0,1,0,0,0,0,0}
		,{0,0,0,0,0,0,0,1,1,1,0,0,0}
		,{0,1,1,0,1,0,0,0,0,0,0,0,0}
		,{0,1,0,0,1,1,0,0,1,0,1,0,0}
		,{0,1,0,0,1,1,0,0,1,1,1,0,0}
		,{0,0,0,0,0,0,0,0,0,0,1,0,0}
		,{0,0,0,0,0,0,0,1,1,1,0,0,0}
		,{0,0,0,0,0,0,0,1,1,0,0,0,0}};
	  
	  int maxAreaOfIsland = maxAreaOfIsland(grid3);
	  System.out.println("Max area of Island " + maxAreaOfIsland);
	}
	
	
  
    public static int maxAreaOfIsland(int[][] grid) {
        
    int maxArea = 0;
    for (int r=0; r<grid.length; r++){
    	for (int c=0; c<grid[0].length; c++){
    		if (grid[r][c] == 1){
    			int area = expand(grid, r, c, 1);
    			maxArea = java.lang.Math.max(area, maxArea);
    		}
    	}
    }
    return maxArea;
}          

	private static int expand(int[][] grid, int r, int c, int area){
	
		if (r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=1)
			return 0;
	
		grid[r][c] = 0;
		area += expand(grid, r+1, c, 1);
		area += expand(grid, r-1, c, 1);
		area += expand(grid, r, c+1, 1);
		area += expand(grid, r, c-1, 1);
		return area;
	}
	
	public static boolean exist(char[][] board, String word) {
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[0].length;j++){
	                if(backTrack(i,j,0,board,word)) return true;
	            }
	        }
	        return false;
	    }
	  
	 public static boolean backTrack(int row, int col, int index, char[][] board, String word){
	        if(index==word.length()) return true;
	        if(row<0 || row>=board.length|| col<0 || col>=board[0].length) return false;
	        char wordLetter = word.charAt(index);
	        if(board[row][col]!=wordLetter) return false;
	        board[row][col] = '.';
	        boolean result = backTrack(row+1,col,index+1,board,word) ||
	                backTrack(row,col+1,index+1,board,word) || 
	                backTrack(row-1,col,index+1,board,word) ||
	                backTrack(row,col-1,index+1,board,word);
	        board[row][col] = wordLetter;
	        return result;
	        
	    }
	
	
	public static int[][] kClosest(int[][] points, int k) {
        int[][] output = new int[k][2];
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(
        		(a,b) -> (a[0] * a[0] + a[1] * a[1]) -(b[0] * b [0] + b[1] * b[1])
        		);
        
        int count =0;
        for(int[] p : points) {
        	pq.add(p);
        }
        
        while(k-- > 0) {
        	output[count++] = pq.poll();
        }
        return output;
    }
	
	public static String FrequencySort(String s) {
	        int[] counter = new int['z' - '0' + 1];
	        int z='z';
	        int zero='0';
	        int zminuszero =z- zero +1;
	        System.out.println("Counter ... "+ z + " zero "+ zero + " array size " +zminuszero );
	        for (int i = 0; i < s.length(); i++) {
	            counter[s.charAt(i) - '0']++;
	            int index = s.charAt(i) - '0';
	            System.out.println("Within loop " + index);
	        }

	        List<int[]> list = new ArrayList<>();
	        for (int i = 0; i < counter.length; i++) {
	            list.add(new int[]{i, counter[i]});
	            
	            System.out.println("i and counter [i] " + counter[i]);
	        }

	        Collections.sort(list, (a, b) -> b[1] - a[1]);

	        for(int[] num : list){
	        	System.out.println("what is in the list - " + num[0]);
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(int[] element : list){
	            char c = (char)('0' + element[0]);
	            for (int i = 0; i < element[1]; i++) sb.append(c);
	        }
	        return sb.toString();
	}
	
    public static int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        
        int m=grid.length;
        int n=grid[0].length;
        
        int numIslands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    numIslands++;
                    dfs(grid,i,j);
                }
            }
        }
        return numIslands;
    }
    
    private static void dfs(char[][] grid,int row,int col){
        int m=grid.length;
        int n=grid[0].length;
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}
