package ict_practice.part3.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Q13 {
	
	private static int n, m;
	
	private static int minDist = Integer.MAX_VALUE;
	
	// Representing the map; 1-base index.
	private static int[][] map;
	
	// Holding all chicken restraunts' locations.
	private static List<Entry<Integer, Integer>> chickens = new ArrayList<>();
	
	// Holding all combinations of "chickens".
	private static List<List<Entry<Integer, Integer>>> combinations = new LinkedList<>();
	
	private static void computeCombinationHelper(
		int start,
		List<Entry<Integer, Integer>> curr
	) {
		if (curr.size() <= m && curr.size() != 0)
			combinations.add(new ArrayList<>(curr));
		
		for (int i = start; i < chickens.size(); ++i) {
			curr.add(chickens.get(i));
			computeCombinationHelper(i + 1, curr);
			curr.remove(curr.size() - 1);
		}
	}
	
	private static void computeCombination() {
		computeCombinationHelper(0, new ArrayList<>());
	}
	
	private static void getMinDist() {
		for (List<Entry<Integer, Integer>> comb : combinations)
		{
			if (comb.size() == 0) continue;
			int sum = 0;
			for (int i = 1; i <= n; ++i)
			{
				for (int j = 1; j <= n; ++j)
				{
					if (map[i][j] == 1)
						sum += getMinDistLocal(i, j, comb);
				}
			}
			
			minDist = Math.min(minDist, sum);
		}
	}
	
	private static int getMinDistLocal(int y, int x, List<Entry<Integer, Integer>> comb) {
		int mn = Integer.MAX_VALUE;
		for (Entry<Integer, Integer> e : comb)
		{
			int dist = Math.abs(y - e.getKey()) + Math.abs(x - e.getValue());
			if (dist < mn)
				mn = dist;
		}
		if (mn == Integer.MAX_VALUE) throw new RuntimeException("something went wrong");
		
		return mn;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());

		// Forming the "map"; forming
		map = new int[n + 1][n + 1];
		Arrays.fill(map[0], -1);
		for (int i = 1; i <= n; ++i)
		{
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j <= n; ++j)
			{
				if (j == 0) 
				{
					map[i][j] = -1;
					continue;
				}
				map[i][j] = Integer.parseInt(token.nextToken());
				
				if (map[i][j] == 2)
					chickens.add(new SimpleImmutableEntry<>(i, j));
			}
		}
		
		computeCombination();
		getMinDist();
		
		writer.write(String.valueOf(minDist));
		writer.write('\n');
		
		writer.flush();
		writer.close();
		reader.close();
	}
	
	
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
}
