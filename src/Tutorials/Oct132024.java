package Tutorials;
import java.util.Queue;
import java.util.PriorityQueue;

public class Oct132024 {
public static void main(String args[]) {
	Queue<String> queue = new PriorityQueue<String>();
	queue.offer("B");
	queue.offer("C");
	queue.offer("A");
	queue.offer("F");
	queue.offer("D");
	
	while(!queue.isEmpty()) {
		System.out.println(queue.poll());
	}
}
}
