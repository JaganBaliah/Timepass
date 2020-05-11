package org.jagan.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

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
		
		@SuppressWarnings("unchecked")
		Graph(int n) {
			this.n = n;
			this.adjList = new List[n];
			for(int i = 0; i < n; i++) adjList[i] = new ArrayList<Integer>();
			this.transclosure = new int[n][n];
		}
	
		void addEdge(int src, int desc) {
			this.adjList[src].add(desc);
		}
		
		void dfs(int v, boolean[] visited) {
			visited[v] = true;
			System.out.print(v + " -> ");
			ListIterator<Integer> listIterator = this.adjList[v].listIterator();
			while(listIterator.hasNext()) {
				Integer next = listIterator.next();
				if(!visited[next]) dfs(next, visited);
			}
		}
		
		void dfsFor(int v) {
			boolean[] visited = new boolean[n];
			dfs(v, visited);
			System.out.println();
		}
		
		void dfsForAll() {
			boolean[] visited = new boolean[n];
			for(int i = 0; i < n; i++) if(!visited[i]) dfs(i, visited);
			System.out.println();
		}
		
		void bfs(int v, boolean[] visited) {
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(v);
			visited[v] = true;
			while(!queue.isEmpty()) {
				Integer val = queue.poll();
				System.out.print(val + " -> ");
				for(Integer x : this.adjList[val]) {
					if(!visited[x]) {
						queue.add(x);
						visited[x] = true;
					}
				}
			}
		}
		
		void bfsFor(int v) {
			boolean[] visited = new boolean[n];
			bfs(v, visited);
			System.out.println();
		}
		
		void bfsForAll() {
			boolean[] visited = new boolean[n];
			for(int i = 0; i < n; i++) if(!visited[i]) bfs(i, visited);
			System.out.println();
		}
		
		int printMotherVertex() {
			int rtnVal = -1;
			boolean[] visited = new boolean[n];
			for(int i = 0 ; i < n; i++) {
			//for(int i = n-1 ; i >= 0; i--) {
				if(!visited[i]) {
					dfs(i, visited);
					rtnVal = i;
				}
			}
			visited = new boolean[n];
			dfs(rtnVal, visited);
			for(boolean i : visited) if(!i) return -1;
			return rtnVal;
		}
		
		void printTransitiveClosure() {
			for(int i = 0 ; i < n; i++) closureUtil(i, i);
			for(int i = 0 ; i < n; i++) {
				System.out.println(Arrays.toString(transclosure[i]));
			}
		}
		
		void closureUtil(int s, int v) {
			transclosure[s][v] = 1;
			for(int t : this.adjList[v]) {
				if(transclosure[s][t] == 0) closureUtil(s, t);				
			}
		}
		
	}
	
}
