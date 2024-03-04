package ict_practice.part3.dfsbfs;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;


/*
// Plain graph searching with each case of 3 new walls.
public class Q16 {
	
	private static int n, m;
	private static int[][] graph;
	//private static boolean[][] visited;
	
	private static int res = Integer.MIN_VALUE;
	
	// Coordinates that correspond to viruses in "graph".
	private static List<int[]> viruses = new ArrayList<>();
	
	// Coordinates that correspond to empty space in "graph".
	private static List<Entry<Integer, Integer>> elements = new ArrayList<>();
	
	// 3 combinations chosen from "elements".
	private static List<List<Entry<Integer, Integer>>> combs = new ArrayList<>();
	
	
	private static int[][] direction = { {-1,0}, {0,1}, {1,0}, {0,-1} };
	
	private static void search() {
		for (List<Entry<Integer, Integer>> comb : combs) {
			for (int i = 0; i < 3; ++i)
				graph[comb.get(i).getKey()][comb.get(i).getValue()] = 1;
			int[][] temp = new int[n][m];
			for (int i = 0; i < n; ++i)
				System.arraycopy(graph[i], 0, temp[i], 0, m);
			
			searchHelper(temp);
			
			
			System.out.println("asdfasdfasdf");
			int tempRes = 0;
			for (int i = 0; i < n; ++i)
				for (int j = 0; j < m; ++j)
					if (temp[i][j] == 0)
						tempRes++;
			
			res = Math.max(res, tempRes);
			
			for (int i = 0; i < 3; ++i)
				graph[comb.get(i).getKey()][comb.get(i).getValue()] = 0;
		}
	}
	
	private static void searchHelper(int[][] temp) {
		for (int i = 0; i < viruses.size(); ++i) {
			Queue<Entry<Integer, Integer>> q = new ArrayDeque<>();
			q.add(new SimpleImmutableEntry<>(viruses.get(i)[0], viruses.get(i)[1]));
			
			int yy, xx, ny, nx;
			while (!q.isEmpty()) {
				yy = q.peek().getKey();
				xx = q.peek().getValue();
				q.poll();
				
				if (yy >= n || yy < 0 || xx >= m || xx < 0 ||
					temp[yy][xx] == 2 || temp[yy][xx] == 1)
					continue;
				
				temp[yy][xx] = 2;
				
				for (int j = 0; j < 4; ++j) {
					ny = yy + direction[j][0];
					nx = xx + direction[j][1];
					q.add(new SimpleImmutableEntry<>(ny, nx));
				}
			}
		}
	}
	
	private static void generateCombinations() {
		generateCombinationsHelper(0, new ArrayList<>());
	}
	
	private static void generateCombinationsHelper(
			int start, List<Entry<Integer, Integer>> curr
	) {
		if (curr.size() == 3)
			combs.add(new ArrayList<>(curr));
		
		for (int i = start; i < elements.size(); ++i) {
			curr.add(new SimpleImmutableEntry<>(
				elements.get(i).getKey(), elements.get(i).getValue())
			);
			
			System.out.println("something");
			
			generateCombinationsHelper(i + 1, curr);
			
			curr.remove(curr.size() - 1);
		}
	}
	
	
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		
		graph = new int[n][m];
		
		for (int i = 0; i < n; ++i)
		{
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; ++j)
			{
				graph[i][j] = Integer.parseInt(token.nextToken());
				if (graph[i][j] == 0)
				{
					elements.add(new SimpleImmutableEntry<>(i, j));
				} 
				else if (graph[i][j] == 2)
				{
					int[] v = {i, j};
					viruses.add(v);
				}
			}
		}
		
		
		generateCombinations();
		
		
		
		//search();
		
		writer.write(String.valueOf(res));
		writer.write('\n');
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}*/
