package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSquareStreakInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int longestSquareStreak(int[] A) {
	   HashMap<Integer,Integer> hMap=new HashMap<>();
	   int result =0;
	   Arrays.sort(A);
	   for(int num : A) {
		   int root = (int) Math.sqrt(num);
		   
		  if( root * root == num)
			  hMap.put(num, hMap.getOrDefault(root, 0)+1);
		  else 
			  hMap.put(num,1);
		  
		  result = Math.max(result, hMap.get(num));
		  
	   }
	  
	   return result < 2 ? -1 : result;
	}
}
