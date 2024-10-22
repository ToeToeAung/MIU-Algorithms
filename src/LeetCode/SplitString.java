package LeetCode;

import java.util.*;

public class SplitString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababccc";
		int num=maxUniqueSplit(s);
		System.out.println("Num *** "+ num);
	}
	
    public static int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return dfs(set, 0, s);
    }
    
    private static int dfs(Set<String> set, int idx, String s) {
    	//System.out.println("Index * "+ idx + " String * "+s);
        if (idx >= s.length()) return 0;
        int result = -1;  
        for (int i = idx + 1; i <= s.length(); i++) {
            String sub = s.substring(idx, i);
         //   System.out.println("Sub * " + sub);
            if (!set.add(sub)) continue; 
            int next = dfs(set, i, s);
         //   System.out.println("Next * " + next);
            if (next >= 0) result = Math.max(result, next + 1);
            set.remove(sub);
        }
        return result;
    }

}
