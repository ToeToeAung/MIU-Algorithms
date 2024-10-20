package LeetCode;
import java.util.*;
public class CourseSchedule2 {

	public static void main(String[] args) {
		int[][] pre= {{1,0},{2,0},{3,1},{3,2}};
		int numCourses= 4;
		
	    int[] Courses = new int[numCourses];
	    Courses=findOrder(numCourses,pre);

	    for(int c :Courses) {
	    	System.out.println("Courses are " + c);
	    }
	}
	  public static int[] findOrder(int numCourses, int[][] prerequisites) {
	        int[] order = new int[numCourses];
	        int[] inDegree = new int[numCourses];
	        Map<Integer, List<Integer>> map = new HashMap<>();
	        Queue<Integer> queue = new LinkedList<>();

	        for (int[] pre : prerequisites) {
	            int target = pre[0], preCourse = pre[1];
	            map.computeIfAbsent(preCourse, k -> new ArrayList<>()).add(target);
	            inDegree[target] += 1;
	        }
	  
	        for (int i = 0; i < numCourses; ++i) {
	            if (inDegree[i] == 0) {
	                queue.offer(i);
	            }
	        }
	        int index = 0;
	        while (!queue.isEmpty()) {
	            int node = queue.poll();
	            order[index++] = node;
	            
	            if (map.containsKey(node)) {
	                for (int target : map.get(node)) {
	                    inDegree[target] -= 1;
	                    if (inDegree[target] == 0) {
	                        queue.offer(target);
	                    }
	                }
	            }
	        }
	        return index == numCourses ? order : new int[0];
	    }
}
