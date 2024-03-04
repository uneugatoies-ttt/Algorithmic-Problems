package ict_practice.part3.impl;

import java.util.ArrayList;
import java.util.List;

public class Q14_3 {
	
	public static void main(String[] args) {
		Q14_3 q = new Q14_3();
		
		int n = 12;
		int[] weak = {1,3,4,9,10};
		int[] dist = {3,5,7};
		
		System.out.println(q.solution(n, weak, dist));
	}
	
	public int solution(int n, int[] weak, int[] dist) {
		
		// For convenience's sake, double the original circumference.
		List<Integer> weakList = new ArrayList<>();
		for (int i = 0; i < weak.length; ++i)
			weakList.add(weak[i]);
		for (int i = 0; i < weak.length; ++i)
			weakList.add(weak[i] + n);
		
		int answer = dist.length + 1;
		
		Q14Permutation permutation = new Q14Permutation(dist.length, dist.length);
		permutation.generatePermutations(dist, 0);
		List<List<Integer>> distList = permutation.getResult();
		
		// Compute every case with each weak spot as a starting point
		for (int start = 0; start < weak.length; ++start) {
			
			for (int i = 0; i < distList.size(); ++i)
			{
				int cnt = 1; // the number of "friends" that will be committed
				
				// The extent of this friend's search capability
				int position = weakList.get(start) + distList.get(i).get(cnt - 1);
				
				for (int index = start; index < start + weak.length; ++index)
				{
					
					// If a weak spot is beyond this friend's reach
					if (position < weakList.get(index))
					{
						cnt++; // then commit another friend
						if (cnt > dist.length)
							break;
						position = weakList.get(index) + distList.get(i).get(cnt - 1);
					}
				}
				answer = Math.min(answer, cnt);
			}
			
		}
		
		if (answer > dist.length)
			return -1;
		
		return answer;
	}
}


class Q14Permutation {
	private int r;
	private int n;
	private int[] curr;
	private List<List<Integer>> result;
	
	public Q14Permutation(int r, int n) {
		this.r = r;
		this.n = n;
		this.curr = new int[r];
		this.result = new ArrayList<>();
	}
	
	public List<List<Integer>> getResult() {
		return this.result;
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void generatePermutations(int[] arr, int depth) {
		if (depth == r) {
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < r; ++i)
				temp.add(curr[i]);
			result.add(temp);
			return;
		}
		for (int i = depth; i < n; ++i) {
			swap(arr, i, depth);
			curr[depth] = arr[depth];
			generatePermutations(arr, depth + 1);
			swap(arr, i, depth);
		}
	}
}	
