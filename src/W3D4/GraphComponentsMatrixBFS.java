package W3D4;
import java.util.*;

public class GraphComponentsMatrixBFS {
    private int vertices;             
    private int[][] matrix;     
    private boolean[] visited;          

    // Constructor
    public GraphComponentsMatrixBFS(int vertices, int[][] matrix) {
        this.vertices = vertices;
        this.matrix = matrix;
        this.visited = new boolean[vertices];  // Initially, no vertices are visited
    }

  
    private void bfs(int start, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;  
        component.add(start);   

        while (!queue.isEmpty()) {
            int v = queue.poll();  
          
            for (int w = 0; w < vertices; w++) {
                if (matrix[v][w] == 1 && !visited[w]) {
                    queue.add(w);          
                    visited[w] = true;    
                    component.add(w);     
                }
            }
        }
    }
 
    public int countComponents() {
        int componentCount = 0;    
        for (int v = 0; v < vertices; v++) {
            if (!visited[v]) {             
                List<Integer> component = new ArrayList<>();
                bfs(v, component);
                componentCount++; 
                System.out.println("Component " + componentCount + ": " + component);
            }
        }

        return componentCount;  
    }

    public static void main(String[] args) {
    
    	  int[][] bfsMatrix = {
  	            {0, 1, 1, 0, 0, 0, 0, 0, 0},
  	            {1, 0, 0, 1, 0, 0, 0, 0, 0}, 
  	            {1, 0, 0, 1, 0, 0, 0, 0, 0}, 
  	            {0, 1, 1, 0, 0, 0, 0, 0, 0}, 
  	            {0, 0, 0, 0, 0, 1, 0, 0, 0}, 
  	            {0, 0, 0, 0, 1, 0, 1, 0, 0}, 
  	            {0, 0, 0, 0, 0, 1, 0, 0, 0}, 
  	            {0, 0, 0, 0, 0, 0, 0, 0, 1}, 
  	            {0, 0, 0, 0, 0, 0, 0, 1, 0}, 
  	        };

      
        int vertices = bfsMatrix.length;   
        GraphComponentsMatrixBFS graph = new GraphComponentsMatrixBFS(vertices, bfsMatrix);
        int componentCount = graph.countComponents();
        System.out.println("Total number of components BFS: " + componentCount);
    }
}
