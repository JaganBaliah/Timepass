package org.jagan.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphKCoreUtil {

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

		@SuppressWarnings("unchecked")
		Graph(int n) {
			this.n = n;
			this.adjList = new LinkedList[n];
			for(int i = 0;i < n; i++) this.adjList[i] = new LinkedList<Integer>();
			transclosure = new int[n][n];
			for(int i = 0 ; i < n; i++) {
				transclosure[i] = new int[n];
				for(int j = 0 ; j < n; j++) transclosure[i][j] = 0;
			}
		}

		void addEdge(int src, int desc) {
			this.adjList[src].add(desc);
			this.adjList[desc].add(src);
		}
		
		boolean dfsKCoreUtil(int v, boolean[] visited, int[] degree, int k) {
			visited[v] = true;
			for(int i : this.adjList[v]) {
				if(degree[v] < k) degree[i]--;
				if(!visited[i]) {
					if(dfsKCoreUtil(i, visited, degree, k)) degree[v]--; 
				}
			}
			return degree[v] < k;
		}
		
		void printKCores(int k) {
			boolean[] visited = new boolean[n];
			int[] degree = new int[n];
			int startVertex = -1;
			int maxDegree = Integer.MIN_VALUE;
			for(int i = 0 ; i < n; i++) {
				degree[i] = this.adjList[i].size();
				if(degree[i] > maxDegree) {
					maxDegree = degree[i];
					startVertex = i;
				}
			}
			dfsKCoreUtil(startVertex, visited, degree, k);
			for(int i = 0 ; i < n; i++) {
				if(!visited[i]) dfsKCoreUtil(i, visited, degree, k);
			}
			System.out.println("Printing KCores for graph with " + k + " cores : ");
			for(int i = 0 ; i < n; i++) {
				if(degree[i] >= k) {
					System.out.print("[" + i + "] : ");
					for(int j : this.adjList[i]) {
						if(degree[j] >= k) System.out.print(" -> " + j);
					}
					System.out.println();
				}
			}
			
		}

	}
}
