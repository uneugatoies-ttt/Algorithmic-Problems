package ict_practice_revisit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// This one passes all the cases except for one; it causes a runtime error.
public class Q06_2 {
	
	private class Food implements Comparable<Food> {
		int time, ind;
		public Food(int time, int ind) {
			this.time = time;
			this.ind = ind;
		}
		
		@Override
		public int compareTo(Food o) {
			return Integer.compare(this.time, o.time);
		}
	}
	
	public int solution(int[] food_times, long k) {
		long summary = 0;
		int n = food_times.length;
		for (int i = 0; i < n; ++i)
			summary += food_times[i];
		if (summary <= k) return -1;
		
		Queue<Food> q = new PriorityQueue<>();
		for (int i = 0; i < n; ++i)
			q.add(new Food(food_times[i], i + 1));
		
		// the time hitherto spent
		summary = 0;
		// the remaining time of food previously eaten
		long previous = 0; 
		// the number of remaining foods
		int remain = food_times.length;
		
		// comparing "k" and
		// "current time + (current food's remaining time - previous food's remaining time) * number of remaining foods"
		while (summary + ((q.peek().time - previous) * remain) <= k) {
			int curr = q.poll().time;
			summary += (curr - previous) * remain;
			remain--;
			previous = curr;
		}
		
		List<Food> result = new ArrayList<>();
		while (!q.isEmpty())
			result.add(q.poll());
		
		Collections.sort(result, (f1, f2) -> Integer.compare(f1.ind, f2.ind));
		
		return result.get((int) (k - summary) % remain).ind;
		
	}

}
