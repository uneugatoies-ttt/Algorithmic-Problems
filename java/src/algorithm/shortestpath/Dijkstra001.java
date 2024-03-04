package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Dijkstra001 {
	
	final private static int INF = Integer.MAX_VALUE - 100;
	
	// The number of nodes
	private static int n;
	
	// The number of edges
	private static int m;
	
	// The starting node of the search
	private static int source;
	
	// The adjacency list of this graph
	// The key indicates the node, and the value indicates the weight.
	private static List<List<Entry<Integer, Integer>>> adj;
	
	private static boolean[] visited;
	
	// The list for indicating the shortest distances
	private static int[] minDist;
	
	private static void in() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		source = Integer.parseInt(reader.readLine());
		adj = new ArrayList<>();
		visited = new boolean[n + 1];
		minDist = new int[n + 1];
		
		for (int i = 0; i < n + 1; ++i) {
			adj.add(new ArrayList<>());
			minDist[i] = INF;
		}
		
		int from, to, wei;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			from = Integer.parseInt(token.nextToken());
			to = Integer.parseInt(token.nextToken());
			wei = Integer.parseInt(token.nextToken());
			adj.get(from).add(new SimpleImmutableEntry<>(to, wei));
		}
	}
	
	// Return the index that contains the smallest "minDist" value
	// among the unvisited nodes.
	private static int getSmallestNode() {
		int mn = INF;
		int ind = 0;
		for (int i = 1; i < n + 1; ++i) {
			if (minDist[i] < mn && !visited[i]) {
				mn = minDist[i];
				ind = i;
			}
		}
		return ind;
	}
	
	private static void dijkstra(int start) {
		minDist[start] = 0;
		visited[start] = true;
		
		for (Entry<Integer, Integer> j : adj.get(start))
			minDist[j.getKey()] = j.getValue();
		
		int curr, cost;
		for (int i = 0; i < n - 1; ++i) {
			curr = getSmallestNode();
			visited[curr] = true;
			for (Entry<Integer, Integer> j : adj.get(curr)) {
				cost = minDist[curr] + j.getValue();
				if (cost < minDist[j.getKey()])
					minDist[j.getKey()] = cost;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		in();
		dijkstra(source);
		
		for (int i = 1; i < n + 1; ++i) {
			if (minDist[i] == INF)
				System.out.println("INFINITY");
			else
				System.out.println(minDist[i]);
		}
	}

}
