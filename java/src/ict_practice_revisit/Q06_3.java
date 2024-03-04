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
		int len = food_times.length;
		int origlen = food_times.length;
		List<Food> list = new LinkedList<>();
		for (int i = 0; i < origlen; ++i)
			list.add(new Food(i + 1, food_times[i]));

		Collections.sort(list, (f1, f2) -> Integer.compare(f1.time, f2.time));

		int currtime = 0;
		int ind = 0;
		for (Food f : list) {
			long diff = f.time - currtime;
			if (diff != 0) {
				long cost = diff * len;
				if (cost <= k) {
					k -= cost;
					currtime = f.time;
				} else {
					k %= len;
					list.subList(ind, origlen).sort((f1, f2) -> Integer.compare(f1.ind, f2.ind));
					return list.get(ind + (int)k).ind;
				}
			}
			ind++;
			len--;
		}

		return -1;
	}

	public static void main(String[] args) {
		Q06_3 q = new Q06_3();

	}

}









// This still fails one case in the efficiency test.
// I got the reason: this was because I didn't define "diff" as the type "long"
/*
public class Q06_3 {

	private class Food {
		int ind, time;
		public Food(int ind, int time) {
			this.ind = ind;
			this.time = time;
		}
	}

	public int solution(int[] food_times, long k) {
		int len = food_times.length;
		int origlen = food_times.length;
		List<Food> list = new LinkedList<>();
		for (int i = 0; i < origlen; ++i)
			list.add(new Food(i + 1, food_times[i]));

		Collections.sort(list, (f1, f2) -> Integer.compare(f1.time, f2.time));

		int currtime = 0;
		int ind = 0;
		for (Food f : list) {
			int diff = f.time - currtime;
			if (diff != 0) {
				long cost = diff * len;
				if (cost <= k) {
					k -= cost;
					currtime = f.time;
				} else {
					k %= len;
					list.subList(ind, origlen).sort((f1, f2) -> Integer.compare(f1.ind, f2.ind));
					return list.get(ind + (int)k).ind;
				}
			}
			ind++;
			len--;
		}

		return -1;
	}

	public static void main(String[] args) {
		Q06_3 q = new Q06_3();

	}

}*/









/*
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
*/