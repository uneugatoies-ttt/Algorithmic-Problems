package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1991_2 {
	
	private static void preorder(Map<Character, List<Character>> adj, char curr) {
		System.out.print(curr);
		if (adj.get(curr).get(0) != '.')
			preorder(adj, adj.get(curr).get(0));
		if (adj.get(curr).get(1) != '.')
			preorder(adj, adj.get(curr).get(1));
	}
	
	private static void inorder(Map<Character, List<Character>> adj, char curr) {
		if (adj.get(curr).get(0) != '.') {
			inorder(adj, adj.get(curr).get(0));
		}	
		System.out.print(curr);
		if (adj.get(curr).get(1) != '.') {
			inorder(adj, adj.get(curr).get(1));
		}
	}
	
	private static void postorder(Map<Character, List<Character>> adj, char curr) {
		if (adj.get(curr).get(0) != '.') {
			postorder(adj, adj.get(curr).get(0));
		}	
		if (adj.get(curr).get(1) != '.') {
			postorder(adj, adj.get(curr).get(1));
		}
		System.out.print(curr);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		
		Map<Character, List<Character>> adj = new HashMap<>();
		char c;
		char left, right;
		for (int i = 0; i < n; ++i) {
			c = 'A';
			c += i;
			adj.put(c, new ArrayList<>());
		}
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			c = token.nextToken().charAt(0);
			left = token.nextToken().charAt(0);
			right = token.nextToken().charAt(0);

			adj.get(c).add(left);
			adj.get(c).add(right);
		}
		
		preorder(adj, 'A');
		System.out.println();
		inorder(adj, 'A');
		System.out.println();
		postorder(adj, 'A');
	}

}
