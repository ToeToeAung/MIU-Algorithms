package W1D1Labs;

public class Prob1_Test {

	public static void main(String[] args) {
			Prob1 stack = new Prob1();
	      
	        System.out.println("Test Case 1: Check if the stack is empty  " + stack.empty()); 
	     
	        stack.push(3);
	        stack.push(5);
	        stack.push(6);
	        stack.push(8);
	        System.out.println("Test Case 2: Top element after pushing: " + stack.top()); 
	      
	        System.out.println("Test Case 3: Pop element: " + stack.pop()); 
	        System.out.println("Test Case 4: Top element after pop: " + stack.top());

	}
}
