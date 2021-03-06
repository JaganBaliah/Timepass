package org.jagan.graph;

import java.util.List;

public class ZGraphKCoreUtil {

	public static void main(String[] args) {
		int k = 3; 
		Graph g1 = new Graph(9);
		g1.addEdge(0, 1); 
		g1.addEdge(0, 2); 
		g1.addEdge(1, 2); 
		g1.addEdge(1, 5); 
		g1.addEdge(2, 3); 
		g1.addEdge(2, 4); 
		g1.addEdge(2, 5); 
		g1.addEdge(2, 6); 
		g1.addEdge(3, 4); 
		g1.addEdge(3, 6); 
		g1.addEdge(3, 7); 
		g1.addEdge(4, 6); 
		g1.addEdge(4, 7); 
		g1.addEdge(5, 6); 
		g1.addEdge(5, 8); 
		g1.addEdge(6, 7); 
		g1.addEdge(6, 8); 
		g1.printKCores(k); 

		System.out.println();
		Graph g2 = new Graph(13); 
		g2.addEdge(0, 1); 
		g2.addEdge(0, 2); 
		g2.addEdge(0, 3); 
		g2.addEdge(1, 4); 
		g2.addEdge(1, 5); 
		g2.addEdge(1, 6); 
		g2.addEdge(2, 7); 
		g2.addEdge(2, 8); 
		g2.addEdge(2, 9); 
		g2.addEdge(3, 10); 
		g2.addEdge(3, 11); 
		g2.addEdge(3, 12); 
		g2.printKCores(k); 

	}

	static class Graph {
		int n;
		List<Integer>[] adjList;
		int[][] transclosure;

		Graph(int n) {
			
		}

		void addEdge(int src, int desc) {
			
		}

		boolean dfsKCoreUtil(int v, boolean[] visited, int[] degree, int k) {
			return false;
		}
		
		void printKCores(int k) {
			
		}
	}

}
