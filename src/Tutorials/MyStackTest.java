package Tutorials;

public class MyStackTest {

	public static void main(String[] args) {
        // Create a new stack instance
        MyStack stack = new MyStack();     
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        
        System.out.print(stack.top());
        stack.push("E");
   
	}
}
