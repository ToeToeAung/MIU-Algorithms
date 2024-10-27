package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public static List<String> binaryTreePaths(TreeNode root) {
	        List<String> paths = new LinkedList<>();
	        if(root == null) {
	        	return paths;
	        }
	        
	        if(root.left == null && root.right == null) {
	        	paths.add(root.val + "");
	        	return paths;
	        }
	        
	        for(String path : binaryTreePaths(root.left)) {
	        	paths.add(root.val + "->" + path);
	        	return paths;
	        }
	        
	        for(String path: binaryTreePaths(root.right)) {
	        	paths.add(root.val + "->" + path);
	        	return paths;
	        }
	        return paths;
	    }
}
