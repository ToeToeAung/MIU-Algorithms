package LeetCode;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

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
		String str= "tree";
		String result = "";
		result= FrequencySort(str);
		System.out.println(result);
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
	
	public static String FrequencySort(String s) {
	        int[] counter = new int['z' - '0' + 1];
	        int z='z';
	        int zero='0';
	        int zminuszero =z- zero +1;
	        System.out.println("Counter ... "+ z + " zero "+ zero + " array size " +zminuszero );
	        for (int i = 0; i < s.length(); i++) {
	            counter[s.charAt(i) - '0']++;
	            int index = s.charAt(i) - '0';
	            System.out.println("Within loop " + index);
	        }

	        List<int[]> list = new ArrayList<>();
	        for (int i = 0; i < counter.length; i++) {
	            list.add(new int[]{i, counter[i]});
	            
	            System.out.println("i and counter [i] " + counter[i]);
	        }

	        Collections.sort(list, (a, b) -> b[1] - a[1]);

	        for(int[] num : list){
	        	System.out.println("what is in the list - " + num[0]);
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(int[] element : list){
	            char c = (char)('0' + element[0]);
	            for (int i = 0; i < element[1]; i++) sb.append(c);
	        }
	        return sb.toString();
	}
}
