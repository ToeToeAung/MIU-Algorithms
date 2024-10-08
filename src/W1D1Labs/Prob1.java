package W1D1Labs;
import java.util.LinkedList;
import java.util.Queue;

public class Prob1 {  
    Queue<Integer> queue1;
    Queue<Integer>queue2;
    public Prob1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    

    public void push(int x) {
        queue1.add(x);
        
    }    
   
    public int pop() {
        while(queue1.size()>1) {
            queue2.add(queue1.poll());
        }
        int x = queue1.poll();
        while(!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return x;
    }
    

    public int top() {
        while(queue1.size()>1) {
            queue2.add(queue1.poll());
        }
        int x = queue1.peek();
        queue2.add(queue1.poll());
        while(queue2.size()>0) {
            queue1.add(queue2.poll());
        }
        return x;
    }
    

    public boolean empty() {
        if(queue1.isEmpty())
            return true;
        else
            return false;
    }
}
