package ict_practice.part3.greedy;

public class Q06_4 {
	
	public int solution(int[] food_times, long k)
	{
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
		
		// FINAL CHECKING 1 - WHETHER THE INDEX'S ELEMENT IS 0
		i++;
		
		if (i >= len)
			i = 0;
		
		int previ = i;
		for (; i < len; ++i)
			if (food_times[i] > 0)
				break;
		
		if (previ == i)
			return i + 1;
		
		// FINAL CHECKING 2 - FROM INDEX 0 TO INDEX "previ"
		if (i >= len)
		{
			i = 0;
			for (; i < previ; ++i)
				if (food_times[i] > 0)
					break;
		}
		
		// if "i" hits "previ" again, then it means that the all elements are 0.
		if (previ == i)
			return -1;
		
		return i + 1;
	}
	
	
	public static void main(String[] args) {
		Q06_4 q = new Q06_4();
		
		int[] food_times = { 3, 1, 2 };
		long k = 5;
		
		System.out.println(q.solution(food_times, k));
		
	}

}