package ict_practice_revisit;

// passed the correctness; but wasn't efficient enough.
public class Q06 {
	
	private int increment(int n, int ind) {
		ind++;
		if (ind >= n)
			ind = 0;
		return ind;
	}
	
	public int solution(int[] food_times, long k) {
		int n = food_times.length;
		
		long time = 1;
		int ind = 0;
		while (time <= k) {
			int cnt = 0;
			while (food_times[ind] == 0) {
				cnt++;
				ind = increment(n, ind);
				if (cnt >= n)
					return -1;
			}
			
			food_times[ind]--;
			time++;
			ind = increment(n, ind);
		}
		
		int cnt = 0;
		while (food_times[ind] == 0) {
			cnt++;
			ind = increment(n, ind);
			if (cnt >= n)
				return -1;
		}
		
		return ind + 1;
	}
	
	
	public static void main(String[] args) {
		int[] ft = {3,1,2};
		Q06 q = new Q06();
		System.out.println(q.solution(ft, 5));
	}

}





















/*


class Solution {
    public int solution(int[] food_times, long k) {
		int len = food_times.length;
		
		int i;
		long thisk;
		while (true)
		{
			thisk = k;
			for (i = 0; i < len; ++i)
			{
				if (food_times[i] > 0) 
				{
					food_times[i]--;
					k--;
				}
				if (k <= 0)
					break;
			}
			
			if (thisk == k)
				return -1;
			if (k <= 0)
				break;
		}
		i++;
		
		if (i >= len)
			i = 0;
		
		int previ = i;
		for (; i < len; ++i)
			if (food_times[i] > 0)
				break;
		
		if (previ == i)
			return i + 1;
		
		if (i >= len)
		{
			i = 0;
			for (; i < previ; ++i)
				if (food_times[i] > 0)
					break;
		}
		
		if (previ == i)
			return -1;
		
		return i + 1;
    }
}


*/