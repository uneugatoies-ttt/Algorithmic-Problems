package etcetera;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;

public class PriorityQueuePractice001 {
	
	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<>();
		Queue<Entry<Integer, Integer>> pq2 = new PriorityQueue<>(
				(s1, s2) -> Integer.compare(s1.getValue(), s2.getValue())
			);
	}

	/*
	public static void main(String[] args) {
		Queue<Integer> priorityQueue1 = new PriorityQueue<>();
		Queue<String> pq2 = new PriorityQueue<>((s1, s2) -> Integer.compare(s1.length(), s2.length()));
	}*/

}
