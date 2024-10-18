package LeetCode;
import java.util.PriorityQueue;;
public class KCloset {

	public static void main(String[] args) {

		int[][] points = {{3,3},{5,-1},{-2,4}};
		int k=2;
		int[][] output=new int[k][2];
		output=kClosest(points,k);
		
		for(int[] p: output) {
			for(int i=0;i<p.length;i++) {
				System.out.println(p[i]);
			}	
		}
	}
	
	public static int[][] kClosest(int[][] points, int k) {
        int[][] output = new int[k][2];
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(
        		(a,b) -> (a[0] * a[0] + a[1] * a[1]) -(b[0] * b [0] + b[1] * b[1])
        		);
        
        int count =0;
        for(int[] p : points) {
        	pq.add(p);
        }
        
        while(k-- > 0) {
        	output[count++] = pq.poll();
        }
        return output;
    }
}
