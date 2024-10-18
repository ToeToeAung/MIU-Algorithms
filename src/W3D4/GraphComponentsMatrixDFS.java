package W3D4;
import java.util.*;
public class GraphComponentsMatrixDFS {
	    private int vertices;               
	    private int[][] dfsMatrix;     
	    private boolean[] visited;          
	 
	    public GraphComponentsMatrixDFS(int vertices, int[][] dfsMatrix) {
	        this.vertices = vertices;
	        this.dfsMatrix = dfsMatrix;
	        this.visited = new boolean[vertices];  
	    }

	   
	    private void dfs(int vertex, List<Integer> component) {
	        visited[vertex] = true;       
	        component.add(vertex);       

	        for (int w = 0; w < vertices; w++) {
	            if (dfsMatrix[vertex][w] == 1 && !visited[w]) {
	                dfs(w, component);      
	            }
	        }
	    }
	  
	    public int countComponents() {
	        int componentCount = 0;  	  
	        for (int v = 0; v < vertices; v++) {
	            if (!visited[v]) {	             
	                List<Integer> component = new ArrayList<>();
	                dfs(v, component);  
	                componentCount++;   
	                System.out.println("Component " + componentCount + ": " + component);
	            }
	        }

	        return componentCount;  
	    }

	    public static void main(String[] args) {	    
	        int[][] matrix = {	            
	            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //0
	            {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
	            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //2
	            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //3
	            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //4
	            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0}, //5
	            
	            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //6
	            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //7
	            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //8
	            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0}, //9
	            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, //10
	            
	            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, //11
	            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, //12
	            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, //13
	        };
	       
	        int vertices = matrix.length;	
	        GraphComponentsMatrixDFS graph = new GraphComponentsMatrixDFS(vertices, matrix);
	      
	        int componentCount = graph.countComponents();
	        System.out.println("Total number of components * DFS : " + componentCount);
	    }
	}

