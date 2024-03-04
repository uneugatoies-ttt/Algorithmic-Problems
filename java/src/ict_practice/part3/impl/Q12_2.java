package ict_practice.part3.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Q12Entry implements Comparable<Q12Entry> {
	
	int x;
	int y;
	// A pillar or a beam?
	// p: 0 | b: 1
	int pob;
	
	public Q12Entry(int x, int y, int pob) {
		this.x = x;
		this.y = y;
		this.pob = pob;
	}
	
	@Override
	public int compareTo(Q12Entry other) {
		if (this.x == other.x && this.y == other.y) {
			return Integer.compare(this.pob, other.pob);
		}
		
		if (this.x == other.x) {
			return Integer.compare(this.y, other.y);
		}
		return Integer.compare(this.x, other.x);
	}
	
}

public class Q12_2 {
	
	// Every time we build or delete something in the structure,
	// we check whether the operation is possible or not;
	// if not, just revert that and skip the operation.
	public boolean isPossibleToDoThat(List<List<Integer>> resultList) {
		for (int i = 0; i < resultList.size(); ++i)
		{
			int x = resultList.get(i).get(0);
			int y = resultList.get(i).get(1);
			int pob = resultList.get(i).get(2);
			
			// This is a pillar
			if (pob == 0)
			{
				boolean check = false;
				if (y == 0) check = true;
				
				for (List<Integer> j : resultList) 
				{
					// There is a beam at (x-1, y)
					if (x - 1 == j.get(0) && y == j.get(1) && 1 == j.get(2))
						check = true;
					// There is a beam at (x, y)
					if (x == j.get(0) && y == j.get(1) && 1 == j.get(2))
						check = true;
					// There is a pillar at (x, y-1)
					if (x == j.get(0) && y - 1 == j.get(1) && 0 == j.get(2))
						check = true;
				}
				
				if (!check) return false;
			}
			// This is a beam
			else if (pob == 1)
			{
				boolean check = false;
				boolean left = false;
				boolean right = false;
				
				for (List<Integer> j : resultList)
				{
					if (x == j.get(0) && y - 1 == j.get(1) && 0 == j.get(2))
						check = true;
					if (x + 1 == j.get(0) && y - 1 == j.get(1) && 0 == j.get(2))
						check = true;
					if (x - 1 == j.get(0) && y == j.get(1) && 1 == j.get(2))
						left = true;
					if (x + 1 == j.get(0) && y == j.get(1) && 1 == j.get(2))
						right = true;
				}
				
				if (left && right) check = true;
				if (!check) return false;
			}
		}
		return true;
	}
	
	public int[][] solution(int n, int[][] build_frame) {
		List<List<Integer>> res = new ArrayList<>();
		
		for (int i = 0; i < build_frame.length; ++i)
		{
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int pob = build_frame[i][2];
			int oper = build_frame[i][3];
			
			// Deleting operation
			if (oper == 0)
			{
				int ind = 0;
				for (int j = 0; j < res.size(); ++j)
					if (x == res.get(j).get(0) && y == res.get(j).get(1) && pob == res.get(j).get(2))
						ind = j;
				List<Integer> erased = res.get(ind);
				res.remove(ind);
				
				// If the operation is not possible, then re-add it.
				if (!isPossibleToDoThat(res))
					res.add(erased);
			}
			// Adding operation
			else if (oper == 1)
			{
				List<Integer> inserted = new ArrayList<>();
				inserted.add(x);
				inserted.add(y);
				inserted.add(pob);
				res.add(inserted);
				
				// If the operation is not possible, then revert it.
				if (!isPossibleToDoThat(res))
					res.remove(res.size() - 1);
			}
		}
		
		List<Q12Entry> resultList = new ArrayList<>();
		for (List<Integer> i : res)
			resultList.add(new Q12Entry(i.get(0), i.get(1), i.get(2)));
		
		Collections.sort(resultList);
		
		int[][] result = new int[resultList.size()][3];
		
		for (int i = 0; i < resultList.size(); ++i)
		{
			result[i][0] = resultList.get(i).x;
			result[i][1] = resultList.get(i).y;
			result[i][2] = resultList.get(i).pob;
		}
		return result;
	}
}
