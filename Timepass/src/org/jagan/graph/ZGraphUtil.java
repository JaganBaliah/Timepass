package org.jagan.graph;

import java.util.List;

public class ZGraphUtil {

	public static void main(String[] args) {
		
		Graph g = new Graph(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
		
        System.out.println("DFS for 2");
		g.dfsFor(2);
		System.out.println("DFS All Vertex");
		g.dfsForAll();
		System.out.println("BFS for 2");
		g.bfsFor(2);
		System.out.println("BFS All Vertex");
		g.bfsForAll();

		g = new Graph(7);
		g.addEdge(0, 1); 
    	g.addEdge(0, 2); 
    	g.addEdge(1, 3); 
    	g.addEdge(4, 1); 
    	g.addEdge(6, 4); 
    	g.addEdge(5, 6); 
    	g.addEdge(5, 2); 
    	g.addEdge(6, 0);
		System.out.println("\nMother Vertex : " + g.printMotherVertex());
		
		g = new Graph(4); 
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
		g.printTransitiveClosure();
		
		g = new Graph(5); 
        
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(1, 4);
		
        g.dfsFor(0);
	}
	
	static class Graph {
		int n;
		List<Integer>[] adjList;
		int[][] transclosure;
		
		Graph(int n) {}
	
		void addEdge(int src, int desc) {}
		
		void dfs(int v, boolean[] visited) {}
		
		void dfsFor(int v) {}
		
		void dfsForAll() {}
		
		void bfs(int v, boolean[] visited) {}
		
		void bfsFor(int v) {}
		
		void bfsForAll() {}
		
		int printMotherVertex() {return 0;}
		
		void printTransitiveClosure() {}
		
		void closureUtil(int s, int v) {}
		
	}
	
}
