package LeetCode;

public class FlipEquivalentBinaryTrees {

	public static void main(String[] args) {
	
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        System.out.println(flipEquiv(tree1, tree2)); 


        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(3);
        tree3.right = new TreeNode(2);

        System.out.println(flipEquiv(tree1, tree3)); 

        // Test Case 3: Trees are not equivalent
        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(2);

        TreeNode tree5 = new TreeNode(1);
        tree5.right = new TreeNode(3);

        System.out.println(flipEquiv(tree4, tree5)); 

	}
	
	 public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
         if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        if (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
           flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)) {
            return true;
        }
        return false;
    }

}
