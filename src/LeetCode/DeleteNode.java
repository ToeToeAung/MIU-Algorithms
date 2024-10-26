package LeetCode;

import java.util.List;

public class DeleteNode {

	public static void main(String[] args) {
		    ListNode head = new ListNode(1);
	        head.next = new ListNode(2);
	        head.next.next = new ListNode(3);
	        head.next.next.next = new ListNode(4);
	        head.next.next.next.next = new ListNode(5);
	        
	        deleteNode(head.next.next);

	        System.out.println("List after deleting node with value 3:");
	        printList(head);

	}
	
	public static void deleteNode(ListNode node) {
		if(node == null) return;
		
		ListNode current = node;
		current.val = node.next.val;
		current.next = current.next.next;
	}

	private static void printList(ListNode head) {
		ListNode current = head;
		
		while(current != null) {
			 System.out.print(current.val + " ");
			current =  current.next;
		}
	}
}
