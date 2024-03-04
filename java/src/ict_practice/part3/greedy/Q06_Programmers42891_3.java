package ict_practice.part3.greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q06_Programmers42891_3 {
	
	private int solution(int[] food_times, long k) {
		List<Food> list = new LinkedList<>();
		int len = food_times.length;
		for (int i = 0; i < len; ++i)
			list.add(new Food(i + 1, food_times[i]));
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.time, o2.time));
		
		int currtime = 0;
		int ind = 0;
		for (Food f : list) {
			long diff = f.time - currtime;
			if (diff != 0) {
				long spend = diff * len;
				if (spend <= k) {
					k -= spend;
					currtime = f.time;
				} else {
					k %= len;
					list.subList(ind, food_times.length)
						.sort((o1, o2) -> (Integer.compare(o1.num, o2.num)));
					return list.get(ind + (int) k).num;
				}
			}
			ind++;
			len--;
		}
		return -1;
	}
	
	private class Food {
		int num, time;
		
		public Food(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
	
}










// This one passes the "correctness" checking; but the "efficiency" checking fails.
/*
public class Q06_Programmers42891_3 {
	
    public int solution(int[] food_times, long k) {
    	int sum = 0;
    	for (int i : food_times)
    		sum += i;
    	if (sum <= k)
    		return -1;
    	
    	Queue<int[]> q = new PriorityQueue<>((e1, e2) -> (Integer.compare(e1[0], e2[0])));
    	
    	int[] e;
    	for (int i = 0; i < food_times.length; ++i) {
    		e = new int[2];
    		e[0] = food_times[i];
    		e[1] = i + 1;
    		q.add(e);
    	}

    	int sumval = 0;
    	int prev = 0;
    	int len = food_times.length;
    	
    	int curr;
    	while (sumval + ((q.peek()[0] - prev) * len) <= k) {
    		curr = q.poll()[0];
    		sumval += (curr - prev) * len;
    		len--;
    		prev = curr;
    	}
    	
    	List<int[]> res = new ArrayList<>();
    	
    	while (!q.isEmpty())
    		res.add(q.poll());
    	
    	Collections.sort(res, (a1, a2) -> (Integer.compare(a1[1], a2[1])));
    	int resind = (int) ((k - sumval) % len);
    	return res.get(resind)[1];
    }
    
    public static void main(String[] args) {
    	Q06_Programmers42891_3 s = new Q06_Programmers42891_3();
    	int[] ft = {8, 6, 4};
    	long k = 15;
    	System.out.println(s.solution(ft, k));
	}
   
}*/


























// Another fucking failed attempt.
/*
public class Q06_Programmers42891_3 {
	
    public int solution(int[] food_times, long k) {
    	Queue<Entry<Integer, Integer>> q =
    			new PriorityQueue<>((e1, e2) -> (Integer.compare(e1.getKey(), e2.getKey())));
    	
    	for (int i = 1; i <= food_times.length; ++i)
    		q.add(new SimpleImmutableEntry<>(food_times[i - 1], i));
    	int res;
    	int curr, rem;
    	while (true) {
    		curr = q.peek().getKey();
    		rem = q.size();
    		k = k - curr * rem;
    		if (k > 0) {
    			q.poll();
    		} else if (k == 0) {
    			q.poll();
    			break;
    		} else {
    			k = k + curr * rem;
    			break;
    		}
    	}
    	Entry<Integer, Integer>[] inter = new SimpleImmutableEntry[q.size()];
    	Entry<Integer, Integer>[] qa = q.toArray(inter);
    	Arrays.sort(qa, (e1, e2) -> (Integer.compare(e1.getValue(), e2.getValue())));
    	
    	int resind = -1;
    	while (k-- > 0) {
    		resind++;
    		if (resind >= qa.length)
    			resind = 0;
    	}
    	
		resind++;
		if (resind >= qa.length)
			resind = 0;
    	
    	return qa[resind].getValue();
    }
    

    
}*/
