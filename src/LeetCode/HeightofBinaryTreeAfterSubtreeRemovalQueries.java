package LeetCode;

public class HeightofBinaryTreeAfterSubtreeRemovalQueries {
	static int maxHeight = 0;
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(4);
		root1.left.left = new TreeNode(2);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(5);
		root1.right.left.right = new TreeNode(7);
	    
		int[] queries1 = {1, 3, 4, 6}; 
		//int[] actualOutput1 = 
				treeQueries(root1, queries1);
	     //   for(int num : actualOutput1) {
	     //   	System.out.println("Numbers "+ num);
	      //  }     
	        
	}
	
    public static int[] treeQueries(TreeNode root, int[] queries) {
        int[] treeHeights = new int[100001];
        preorder(root, treeHeights, maxHeight = 0);
        postorder(root, treeHeights, maxHeight = 0);

      
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) res[i] = treeHeights[queries[i]];
        for(int i :res) {
        System.out.println("Res " + i);
        }
        return res;
    }
    
    private static void preorder(TreeNode root, int[] treeHeights, int height) {
        if (root == null) return;
        treeHeights[root.val] = maxHeight;
        maxHeight = Math.max(maxHeight, height);
        preorder(root.left, treeHeights, height + 1);
        preorder(root.right, treeHeights, height + 1);
    }
    private static void postorder(TreeNode root, int[] treeHeights, int height) {
        if (root == null) return;
        treeHeights[root.val] = Math.max(treeHeights[root.val], maxHeight);
        maxHeight = Math.max(maxHeight, height);
        postorder(root.right, treeHeights, height + 1);
        postorder(root.left, treeHeights, height + 1);
    }
}
