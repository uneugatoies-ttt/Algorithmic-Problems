package ict_practice.part3.impl;

import java.util.ArrayList;
import java.util.List;

class Permutation {
	int n;
	int r;
	int[] curr;
	List<List<Integer>> result;
	
	public Permutation(int n, int r) {
		this.n = n;
		this.r = r;
		this.curr = new int[r]; // current permutation
		this.result = new ArrayList<>();
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void generatePermutations(int[] arr, int depth) {
		if (depth == r)
		{
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < curr.length; ++i)
				temp.add(curr[i]);
			result.add(temp);
			return;
		}
		for (int i = depth; i < n; ++i)
		{
			swap(arr, i, depth);
			curr[depth] = arr[depth];
			generatePermutations(arr, depth + 1);
			swap(arr, i, depth);
		}
	}
}

public class Q14_2 {
	
	public int solution(int n, int[] weak, int[] dist) {
		List<Integer> weakList = new ArrayList<>();
		for (int i = 0; i < weak.length; ++i)
			weakList.add(weak[i]);
		for (int i = 0; i < weak.length; ++i)
			weakList.add(weak[i] + n);
		
		int answer = dist.length + 1;
		Permutation permutation = new Permutation(dist.length, dist.length);
		permutation.generatePermutations(dist, 0);
		
		List<List<Integer>> distList = permutation.result;
		
		for (int start = 0; start < weak.length; ++start)
		{
			for (int i = 0; i < distList.size(); ++i)
			{
				int cnt = 1;
				int position = weakList.get(start) + distList.get(i).get(cnt - 1);
				
				for (int index = start; index < start + weak.length; ++index)
				{
					if (position < weakList.get(index))
					{
						cnt++;
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
