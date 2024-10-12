package W2D4;

public class BST {

	public static void main(String[] args) {
		    Node root = new Node(25);
	        root.left = new Node(20);
	        root.right = new Node(70);
	        root.left.left = new Node(15);
	        root.left.right = new Node(23);
	        root.right.right = new Node(95);
	        
	        // Counting nodes from BST
	        System.out.println("Total nodes: " + countNodes(root));

	        // Counting leaves from BST
	        System.out.println("Total leaves: " + countLeaves(root));

	       
	        mirrorNode(root);
	        System.out.println("BST mirrored successfully.");
	}
	
	public static int countNodes(Node root) {
		if(root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	public static int countLeaves(Node root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null) {
			return 1;
		}
		return countLeaves(root.left) + countLeaves(root.right);
	}
	
	public static Node mirrorNode(Node root) {
        if (root == null) {
            return null;
        }
        
      
        Node leftMirror = mirrorNode(root.left);
        Node rightMirror = mirrorNode(root.right);        
 
        root.left = rightMirror;
        root.right = leftMirror;
        
        return root;
    }

}
