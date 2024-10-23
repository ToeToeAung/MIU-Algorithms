package LeetCode;
import java.util.*;

class ReplaceValueInTree1 {
	static Map<Integer,Integer> map1;
	static Map<TreeNode,Integer> map2;
    public static TreeNode replaceValueInTree(TreeNode root) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        dfs(root, null, 0);
        fillSum(root, null, 0);
        return root;
    }
    
    private static void dfs(TreeNode root,TreeNode parent,int c){
        if(root==null){
            return;
        }
        if(parent!=null){
           map2.put(parent,map2.getOrDefault(parent,0)+root.val);
           map1.put(c,map1.getOrDefault(c,0)+root.val);
        }
        dfs(root.left,root,c+1);
        dfs(root.right,root,c+1);
    }

    private static void fillSum(TreeNode root,TreeNode parent,int c){
        if(root==null){
            return;
        }
        root.val = parent==null? 0: (map1.get(c)-map2.get(parent));
        fillSum(root.left,root,c+1);
        fillSum(root.right,root,c+1);
    }
    
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);              
        System.out.print( "Tree " +root.val + " ");  
        printTree(root.right);            
    }
    
    public static void main(String args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

   
        replaceValueInTree(root);


        printTree(root);
    }
}