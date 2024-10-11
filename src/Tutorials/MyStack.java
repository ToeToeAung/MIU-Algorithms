package Tutorials;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<String> queue1;
    private Queue<String> queue2;

 
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(String x) {
        queue1.offer(x); 
    }


    public String pop() {
        if (empty()) {
            return ""; 
        }
 
        while (queue1.size() > 1) {
        	System.out.println("Queue Poll " + queue1.poll());
            queue2.offer(queue1.poll());
        }
      
        String top = queue1.poll();

        Queue<String> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }


    public String top() {
        if (empty()) {
            return "";
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        String top = queue1.poll();
        queue2.offer(top);

        Queue<String> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }


    public boolean empty() {
        return queue1.isEmpty();
    }
}


