package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q19 {
	
	private static int[] nums;
	private static int[] operators = new int[4];
	private static int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
	
	private static List<List<Integer>> permutations = new ArrayList<>();
	
	private static void compute() {
		int tempRes;
		for (List<Integer> p : permutations)
		{
			tempRes = nums[0];
			for (int i = 0; i < nums.length - 1; ++i)
			{
				if (p.get(i) == 0)
				{
					tempRes += nums[i + 1];
				}
				else if (p.get(i) == 1)
				{
					tempRes -= nums[i + 1];
				}
				else if (p.get(i) == 2)
				{
					tempRes *= nums[i + 1];
				}
				else if (p.get(i) == 3)
				{
					if (tempRes < 0) {
						tempRes *= -1;
						tempRes /= nums[i + 1];
						tempRes *= -1;
					} else {
						tempRes /= nums[i + 1];
					}
				}
			}
			mx = Math.max(mx, tempRes);
			mn = Math.min(mn, tempRes);
		}
	}
	
	private static void generatePermutations() {
		List<Integer> orig = new ArrayList<>();
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < operators[i]; ++j)
				orig.add(i);
		}
		Permutation p = new Permutation(orig.size(), orig.size());
		p.generatePermutations(orig, 0);
		permutations = p.result;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		nums = new int[n];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			nums[i] = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < 4; ++i)
			operators[i] = Integer.parseInt(token.nextToken());

		generatePermutations();
		compute();
		
		System.out.println(mx);
		System.out.println(mn);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
	private static class Permutation {
		int n;
		int r;
		int[] curr;
		List<List<Integer>> result;
		
		public Permutation(int n, int r) {
			this.n = n;
			this.r = r;
			this.curr = new int[r];
			this.result = new ArrayList<>();
		}
		
		public void swap(List<Integer> arr, int i, int j) {
			int temp = arr.get(i);
			arr.set(i, arr.get(j));
			arr.set(j, temp);
		}
		
		public void generatePermutations(List<Integer> orig, int depth) {
			if (depth == r)
			{
				List<Integer> temp = new ArrayList<>();
				for (int cc : curr)
					temp.add(orig.get(cc));
				result.add(temp);
				return;
			}
			for (int i = depth; i < n; ++i)
			{
				swap(orig, i, depth);
				curr[depth] = depth;
				generatePermutations(orig, depth + 1);
				swap(orig, i, depth);
			}
		}
		
	}
}
