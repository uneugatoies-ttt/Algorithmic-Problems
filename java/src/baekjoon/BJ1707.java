package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1707 {
	private static final int C1 = 15;
	private static final int C2 = 17;
	
	public static boolean checkDFS(int curr, List<List<Integer>> adj, List<Integer> color) {
		boolean res = true;
		
		if (color.get(curr) != C1 && color.get(curr) != C2)
			color.set(curr, C1);
		
		for (int nei : adj.get(curr)) {
			if (color.get(curr) == color.get(nei))
				return false;
			
			if (color.get(nei) != C1 && color.get(nei) != C2) {
				if (color.get(curr) == C1)
					color.set(nei, C2);
				else
					color.set(nei, C1);
				
				res = checkDFS(nei, adj, color);
			}
		}
		
		return res;
	}
	
	public static boolean isBipartite(List<List<Integer>> adj, List<Integer> color) {
		for (int i = 0; i < adj.size(); ++i) {
			boolean res = true;
			
			if (color.get(i) != C1 && color.get(i) != C2)
				res = checkDFS(i, adj, color);
			
			if (!res)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		int v, e, node1, node2;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int k = Integer.parseInt(token.nextToken());
		
		for (int i = 0; i < k; ++i) {
			token = new StringTokenizer(reader.readLine());
			v = Integer.parseInt( token.nextToken() );
			e = Integer.parseInt( token.nextToken() );

			List<List<Integer>> adj = new ArrayList<>();
			List<Integer> color = new ArrayList<>();
			
			for (int j = 0; j < v; ++j) {
				adj.add(new ArrayList<>());
				color.add(-1);
			}
			
			for (int j = 0; j < e; ++j) {
				token = new StringTokenizer(reader.readLine());
				node1 = Integer.parseInt(token.nextToken());
				node2 = Integer.parseInt(token.nextToken());
				
				adj.get(node1 - 1).add(node2 - 1);
				adj.get(node2 - 1).add(node1 - 1);
			}
			
			if (isBipartite(adj, color))
				builder.append("YES\n");
			else
				builder.append("NO\n");
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
