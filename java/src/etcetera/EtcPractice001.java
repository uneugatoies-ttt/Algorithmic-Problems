package etcetera;

public class EtcPractice001 {
	
	public static void main(String[] args) {
		
		double d = 1.0 / 3.0;
		System.out.println(d);
	}
	
	/*
	
	public static void main(String[] args) {
		List<Integer> orig = new ArrayList<>();
		orig.add(1);
		orig.add(2);
		orig.add(3);
		Permutation<Integer> p = new Permutation<>(3, 3);
		Combination<Integer> c = new Combination<>(3, 2);
		p.generatePermutations(orig, 0);
		c.generateCombinations(orig, 0, 0, 0);
		List<List<Integer>> result = p.result;
		List<List<Integer>> resultComb = c.result;
		for (List<Integer> r : resultComb)
			System.out.println(r.toString());
		
	}
	
	
	public static class Permutation<T> {
		int n; int r; int[] curr; List<List<T>> result;
		
		public Permutation(int n, int r) {
			this.n = n;
			this.r = r;
			this.curr = new int[r];
			this.result = new ArrayList<>();
		}
		
		public void swap(List<T> arr, int i, int j) {
			T temp = arr.get(i);
			arr.set(i, arr.get(j));
			arr.set(j, temp);
		}
		
		public void generatePermutations(List<T> orig, int depth) {
			if (depth == n) {
				List<T> temp = new ArrayList<>();
				for (int i = 0; i < r; ++i)
					temp.add(orig.get(curr[i]));
				result.add(temp);
				return;
			}
			for (int i = depth; i < n; ++i) {
				swap(orig, depth, i);
				curr[depth] = depth;
				generatePermutations(orig, depth + 1);
				swap(orig, depth, i);
			}
		}
	}
	
	
	public static class Combination<T> {
		int n; int r; int[] curr; List<List<T>> result;
		public Combination(int n, int r) {
			this.n = n;
			this.r = r;
			this.curr = new int[r];
			this.result = new ArrayList<>();
		}
		
		public void generateCombinations(List<T> orig, int index, int depth, int target) {
			if (depth == r) {
				List<T> temp = new ArrayList<>();
				for (int i = 0; i < r; ++i)
					temp.add(orig.get(curr[i]));
				result.add(temp);
				return;
			}
			
			if (target == n) return;
			
			curr[index] = target;
			generateCombinations(orig, index + 1, depth + 1, target + 1);
			generateCombinations(orig, index, depth, target + 1);
		}
	}
	
	
	
	/*
	public static void main(String[] args) {
		
		Queue<Integer>[] q = new ArrayDeque[3];
		
		for (int i = 0; i < 3; ++i)
			q[i] = new ArrayDeque<>();
		
		q[0].add(3);
		q[0].add(5);
		q[0].add(6);
		
		q[1].add(6);
		q[1].add(6);
		q[1].add(6);
		q[1].add(6);
		q[1].add(6);
		
		q[2].add(6);
		
		System.out.println(q[0].size());
		System.out.println(q[1].size());
		System.out.println(q[2].size());
		
	}*/

}
