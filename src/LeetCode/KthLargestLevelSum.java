package LeetCode;
import java.util.*;

public class KthLargestLevelSum {
	
	public static void main(String[] args) {
		
	}
	
	    
	    public static long kthLargestLevelSum(TreeNode root, int k,List<Long> list) {
	    	list = new ArrayList<>();
	        collectSum(root,0,list);
	        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->Long.compare(b,a));
	        pq.addAll(list);
	        if(pq.size() < k)   return -1;
	        while(k-- > 1)  pq.poll();
	        return pq.poll();
	    }
	    
	    public static void  collectSum(TreeNode root, int level,List<Long> list){
	        if(root == null)    return;
	        if(level == list.size()) list.add((long)root.val);
	        else list.set(level,list.get(level)+root.val);
	        collectSum(root.left, level+1,list);
	        collectSum(root.right, level+1,list);	        
	    }
	
}
 