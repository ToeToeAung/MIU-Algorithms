package Tutorials;
import java.util.*;
public class NetworkDelay {

	public static void main(String[] args) {
		int n= 4,k=2;
		int[][] times ={{2,1,1},{2,3,1},{3,4,1}};
		int totalDelay=networkDelayTime (times,n,k);
		System.out.println("Network Delay Time " + totalDelay);
		}
	  public static int networkDelayTime(int[][] times, int n, int k) {
	        Map<Integer, List<int[]>> graph = new HashMap<>();
	        for (int[] time : times) {
	            int u = time[0], v = time[1], t = time[2];
	            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, t});
	        }

	        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
	      
	        minHeap.add(new int[]{k, 0});
	        Map<Integer, Integer> minTimes = new HashMap<>();

	        while (!minHeap.isEmpty()) {
	            int[] current = minHeap.poll();
	            for(int a :current) {
	            	 System.out.println(" Heap Values *** "+ a);
	            }
	           
	            int node = current[0];
	            int time = current[1];

	            if (minTimes.containsKey(node)) continue;

	            minTimes.put(node, time);
	            if (graph.containsKey(node)) {
	                for (int[] neighbor : graph.get(node)) {
	                    int nb = neighbor[0];
	                    int nbTime = neighbor[1];
	                    
	                    System.out.println(" Heap Values *** nb "+ nb + " - nbTime "+ nbTime);
	                    
	                    if (!minTimes.containsKey(nb)) {
	                        minHeap.add(new int[]{nb, time + nbTime});
	                    }
	                }
	            }
	        }

	        if (minTimes.size() == n) {
	            return Collections.max(minTimes.values());
	        } else {
	            return -1;
	        }
	    }
}
