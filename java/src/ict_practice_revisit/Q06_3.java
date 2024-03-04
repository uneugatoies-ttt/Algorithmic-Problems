package ict_practice_revisit;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q06_3 {
	
	private class Food {
		int ind, time;
		public Food(int ind, int time) {
			this.ind = ind;
			this.time = time;
		}
	}
	
	public int solution(int[] food_times, long k) {
		List<Food> list = new LinkedList<>();
		int origlen = food_times.length;
		int len = food_times.length;
		for (int i = 0; i < len; ++i)
			list.add(new Food(i + 1, food_times[i]));
		
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.time, o2.time));
		
		int curr = 0;
		int ind = 0;
		for (Food f : list) {
			long diff = f.time - curr;
			if (diff != 0) {
				long spend = diff * len;
				if (spend <= k) {
					k -= spend;
					curr = f.time;
				} else {
					k %= len;
					list.subList(ind, origlen).sort((o1, o2) -> Integer.compare(o1.ind, o2.ind));
					return list.get(ind + (int)k).ind;
				}
			}
			ind++;
			len--;
		}
		return -1;
	}

}
