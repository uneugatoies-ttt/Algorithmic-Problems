package ict_practice.part3.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// failed
public class Q44_3 {

	private static class Node {
		int x, y, z;
		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	private static int n;
	private static Node[] nodes;
	private static int[] parent;
	private static int[] rank;
	private static boolean[] visited;
	private static int res = 0;
	
	private static void formEdges(int curr) {
		visited[curr] = true;
		
		int dist = Integer.MAX_VALUE;
		int thei = -1;
		for (int i = 0; i < n; ++i) {
			if (visited[i] || i == curr) continue;
			
			int temp = Math.min(Math.abs(nodes[i].x - nodes[curr].x), 
					Math.min(
							Math.abs(nodes[i].y - nodes[curr].y),
							Math.abs(nodes[i].z - nodes[curr].z)
					));
			
			if (dist > temp) {
				dist = temp;
				thei = i;
			}
		}
		
		if (thei == -1) return;
		
		res += dist;
		formEdges(thei);
	}
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		nodes = new Node[n];
		visited = new boolean[n];
	
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		StringTokenizer st;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(x,y,z);
		}
		
		formEdges(0);
		
		System.out.println(res);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}