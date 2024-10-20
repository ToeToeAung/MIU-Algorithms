package LeetCode;
import java.util.*;
public class CourseSchedule {

	public static void main(String[] args) {
	int[][] pre= {{1,0},{0,1}};
	int numCourses= 2;
	
    boolean isFinished=false;
    isFinished=canFinish(numCourses,pre);
    
    System.out.println("Finished?" + isFinished);
	}
	
    private static boolean dfs(int node, Map<Integer, List<Integer>> graph, int[] states) {
        if (states[node] == 1) return false; 
        if (states[node] == 2) return true;  

        states[node] = 1; 
        System.out.println("State of node "+ states[node]);
        
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!dfs(neighbor, graph, states)) {
                    return false;
                }
            }
        }

        states[node] = 2;
        return true;
    }
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : prerequisites) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
        }

        final int UNVISITED = 0;
        final int VISITING = 1;
        final int VISITED = 2;
        int[] states = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, states)) {
                return false;
            }
        }

        return true;
    }
}
