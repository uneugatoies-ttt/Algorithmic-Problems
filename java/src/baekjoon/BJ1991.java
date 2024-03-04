package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1991 {
	
	private static Map<Character, List<Character>> adj;
	
	private static void preorder(char curr) {
		System.out.print(curr);
		if (adj.get(curr).get(0) != '.')
			preorder(adj.get(curr).get(0));
		
		if (adj.get(curr).get(1) != '.')
			preorder(adj.get(curr).get(1));
	}
	
	private static void inorder(char curr, Map<Character, Boolean> printed) {
		if (adj.get(curr).get(0) != '.') {
			inorder(adj.get(curr).get(0), printed);
		}	
		
		if (!printed.get(curr)) {
			System.out.print(curr);
			printed.put(curr, true);
		}
		
		if (adj.get(curr).get(1) != '.') {
			inorder(adj.get(curr).get(1), printed);
		}
		
		if (!printed.get(curr)) {
			System.out.print(curr);
			printed.put(curr, true);
		}
	}
	
	private static void postorder(char curr) {
		if (adj.get(curr).get(0) != '.') {
			postorder(adj.get(curr).get(0));
		}	
		if (adj.get(curr).get(1) != '.') {
			postorder(adj.get(curr).get(1));
		}
		
		System.out.print(curr);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		
		adj = new HashMap<>();
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
		
		preorder('A');
		System.out.println();
		
		Map<Character, Boolean> printed = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			c = 'A';
			c += i;
			printed.put(c, false);
		}
		
		inorder('A', printed);
		System.out.println();
		
		postorder('A');
	}

}
