package W1D1Labs;

public class Prob2_Test {

	public static void main(String[] args) {
		 	Node head1 = new Node(5);
	        head1.next = new Node(8);
	        head1.next.next = new Node(9);
	        head1.next.next.next = new Node(7);
	        head1.next.next.next.next = new Node(3);
	        	     
	        System.out.print("Test Case 1 : Original Linked list:");
	        Prob2.printNodes(head1);
	        
	        head1 = Prob2.reverseList(head1);

	        System.out.print("\nTest Case 1 : Reversed Linked List:");
	        Prob2.printNodes(head1);
	        
	        Node head2 = new Node(6);
	        head2.next = null;
	        
	        System.out.print("\nTest Case 2 : Original Linked list:");
	        Prob2.printNodes(head2);
	        
	        head2 = Prob2.reverseList(head2);
	        
	        System.out.print("\nTest Case 2 : Reversed Linked list:");
	        Prob2.printNodes(head2);
	        
	        
	        Node head3 = new Node(2);
	        head3.next = new Node(4);
	        head3.next.next = new Node(9);
	   
	        
	        System.out.print("\nTest Case 3 : Original Linked list:");
	        Prob2.printNodes(head3);
	        
	        head3 = Prob2.reverseList(head3);
	        
	        System.out.print("\nTest Case 3 : Reversed Linked list:");
	        Prob2.printNodes(head3);
	}

}
