package org.jagan.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class GraphUtil {

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
		
        System.out.println("DFS for 2");
		g.dfs(2);
		System.out.println("DFS All Vertex");
		g.dfsAll();
		System.out.println("BFS for 2");
		g.bfs(2);
		System.out.println("BFS All Vertex");
		g.bfsAll();
		
		g.printMotherVertex();
		g.printTransitiveClosure();
	}
	
	static class Graph {
		int n;
		LinkedList<Integer>[] adjList;
		int[][] transitiveClosure;
		
		@SuppressWarnings("unchecked")
		Graph(int n) {
			this.n = n;
			this.adjList = new LinkedList[n];
			for(int i = 0 ; i < n; i++) this.adjList[i] = new LinkedList<Integer>();
			this.transitiveClosure = new int[n][n];
		}
		
		public void addEdge(int src, int dest) {
			this.adjList[src].add(dest);
		}
		
		public void dfs(int v) {
			boolean[] visited = new boolean[n];						
			dfsUtil(v, visited);
			System.out.println();
		}
		
		public void dfsUtil(int v, boolean[] visited) {
			visited[v] = true;
			System.out.print(" -> " + v);
			ListIterator<Integer> listIterator = this.adjList[v].listIterator();
			while(listIterator.hasNext()) {
				int next = listIterator.next();
				if(!visited[next]) {
					dfsUtil(next, visited);
				}
			}
		}
		
		public void dfsAll() {
			boolean[] visited = new boolean[n];
			for(int i = 0 ; i < n; i++) {
				if(!visited[i])	dfsUtil(i, visited);
			}
			System.out.println();
		}
		
		public void bfs(int v) {
			boolean[] visited = new boolean[n];
			bfsUtil(v, visited);
			System.out.println();
		}
		
		public void bfsUtil(int v, boolean[] visited) {			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(v);
			visited[v] = true;
			while(!queue.isEmpty()) {
				int val = queue.poll();
				System.out.print(" -> " + val);
				for(int entry : this.adjList[val]) {
					if(!visited[entry]) {
						visited[entry] = true;
						queue.add(entry);
					}
				}
			}
		}
		
		public void bfsAll() {
			boolean[] visited = new boolean[n];
			for(int i = 0 ; i < n; i++) {
				if(!visited[i]) bfsUtil(i, visited);				
			}
			System.out.println();
		}
		
		public void printMotherVertex() {
			boolean[] visited = new boolean[n];
			int m = -1;
			for(int i = 0 ; i < n; i++) {
				if(!visited[i]) {
					dfsUtil(i, visited);
					m = i;
				}
			}
			
			visited = new boolean[n];
			dfsUtil(m, visited);
			for(boolean vis : visited) {
				if(!vis) m = -1; break;
			}
			System.out.println("\nMother Vertex : " + m);
			
		}
		
		
		public void printTransitiveClosure() {
			for(int i = 0; i < n; i++) {
				tClosure(i, i);				
			}
			System.out.println("Printing Transitive Closure : ");
			for(int[] arr : transitiveClosure) System.out.println(Arrays.toString(arr));
		}
		
		private void tClosure(int s, int d) {
			transitiveClosure[s][d] = 1;
			for(Integer v : this.adjList[d]) {
				if(transitiveClosure[s][v] == 0) tClosure(s, v);
			}
		}
	}
}
