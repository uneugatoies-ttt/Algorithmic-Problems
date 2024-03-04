package ict_practice.part3.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// This approach is not entired wrong, but there are cases that are 
// not covered by this logic; so it seems that there are loopholes.
public class Q14 {

	public int solution(int n, int[] weak, int[] dist) {		
		Arrays.sort(dist);
		int[] sortedDist = Arrays.stream(dist)
								.boxed()
								.sorted(Collections.reverseOrder())
								.mapToInt(i -> i.intValue())
								.toArray();
		

		
		int result = dist.length;
		
		// clockwise
		result = search(n, result, weak, sortedDist);
		
		int[] reversedWeak = Arrays.stream(weak)
									.boxed()
									.sorted(Collections.reverseOrder())
									.mapToInt(i -> n - i)
									.toArray();
		// counter clockwise
		result = search(n, result, reversedWeak, sortedDist);
		
		if (result == Integer.MAX_VALUE)
			return -1;
		
		return result;
	}
	
	
	public int search(int n, int result, int[] weak, int[] sortedDist) {
		boolean[] weakchecked = new boolean[weak.length];
		boolean allchecked = false;
		
		// clockwise
		for (int i = 0; i < sortedDist.length; ++i)
		{
			allchecked = false;
			// Each element of "weak" must be checked as a starting point
			for (int j = 0; j < weak.length; ++j)
			{		
				Arrays.fill(weakchecked, false);
				int ind = j;
				
				for (int k = 0; k <= i; ++k)
				{
					int extent = weak[ind] + sortedDist[k];
					
					if (extent >= n)
					{
						while (ind < weakchecked.length) 
						{
							weakchecked[ind] = true;
							ind++;
						}
						ind = 0;
						if (extent == n) 
							extent = 0;
						else 
							extent = extent % n;
					}
					
					while (ind < weak.length && !weakchecked[ind] && weak[ind] <= extent)
					{
						weakchecked[ind] = true;
						ind++;
					}
					
					if (ind >= weak.length)
						ind = 0;
					
					allchecked = true;
					for (int m = 0; m < weakchecked.length; ++m)
					{
						if (!weakchecked[m])
						{
							allchecked = false;
							break;
						}
					}
					
					if (allchecked)
					{
						result = Math.min(result, i + 1);
						break;
					}
				}
				if (allchecked)
					break;
			}
			if (allchecked)
				break;
		}
		
		if (!allchecked)
			result = Integer.MAX_VALUE;
		
		return result;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Q14 q = new Q14();
		
		int n = Integer.parseInt(reader.readLine());
		int weakLen = Integer.parseInt(reader.readLine());
		int distLen = Integer.parseInt(reader.readLine());
		
		
		int[] weak = new int[weakLen];
		int[] dist = new int[distLen];
		
		StringTokenizer token = new StringTokenizer( reader.readLine() );
		
		for (int i = 0; i < weakLen; ++i)
			weak[i] = Integer.parseInt(token.nextToken());
		
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < distLen; ++i)
			dist[i] = Integer.parseInt(token.nextToken());
		
		
		System.out.println(q.solution(n, weak, dist));
	}

}


