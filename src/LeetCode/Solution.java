package LeetCode;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

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
		System.out.println("Frequency Sort : " + result);
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
		StringBuilder result=new StringBuilder();
		Map<Character,Integer> hMap=new HashMap<>();
		
		for(char ch : s.toCharArray()) {
			hMap.put(ch,hMap.getOrDefault(ch,0)+1);			
		}
		List<Character> list= new ArrayList(hMap.keySet());
		list.sort((ob1,ob2) -> hMap.get(ob1) - hMap.get(ob2));
		
		for(char ch : list) {
			for(int i=0;i<hMap.get(ch);i++) {
				result.append(ch);	
			}			
		}
		return result.toString();
	}
}
