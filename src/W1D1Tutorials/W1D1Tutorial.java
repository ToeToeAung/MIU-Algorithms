package W1D1Tutorials;

public class W1D1Tutorial {
	

	   public static int findGcd(int a, int b)
	     {
	        while (b != 0) {
	            int temp = b;
	            b = a % b;
	            a = temp;
	        }
	        return a;
	     }
	 
	 
	     public int fibonacciIterative(int n) {
	    	 if(n <= 1) {
		     return n;
	         }
			 int b = 1, a = 1, temp;
			 for(int i=2; i<n; i++) {
			      temp = b;
			      b = a + b;
			      a = temp;
			  }
			  return b;
	       }
	 
	 
		public static Node reverseList(Node head) {
	             Node current = head, prev = null, temp;
	 
	             while (prev != null) {
	                  temp = prev.next;           
	                  prev.next = current;
	                  current = prev;
	                  prev = temp;
	              }       
	              return current;
	         }
	 
}
