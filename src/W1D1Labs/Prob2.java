package W1D1Labs;

public class Prob2 {

static Node reverseList(Node head) {       
  
        Node curr = head, prev = null, next;    
        while (curr != null) {                
            next = curr.next;                   
            curr.next = prev;        
            prev = curr;
            curr = next;
        }        
        return prev;
    }


static void printNodes(Node node) {
    while (node != null) {
        System.out.print(" " + node.val);
        node = node.next;
    }
}
}

