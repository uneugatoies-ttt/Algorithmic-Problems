package mathematics.combinationpermutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationBetter {
	
	public static void main(String[] args) {
		List<Integer> arr1 = new ArrayList<>();
		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
		Permutation<Integer> permutation = new Permutation<>(arr1.size(), 2);
		permutation.generatePermutations(arr1, 0);
		
		
		System.out.println(permutation.getResult().toString());
		
		
		
		
	}

}


class Permutation<T> {
	int n;
	int r;
	int[] curr;
	List<List<T>> result;
	
	public Permutation(int n, int r) {
		this.n = n;
		this.r = r;
		this.curr = new int[r]; // current permutation
		this.result = new ArrayList<>();
	}
	
	public List<List<T>> getResult() {
		return this.result;
	}
	
	public void swap(List<T> arr, int i, int j) {
		T temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
	public void generatePermutations(List<T> arr, int depth) {
		if (depth == r)
		{
			List<T> temp = new ArrayList<>();
			for (int i = 0; i < r; ++i)
				temp.add(arr.get(curr[i]));
			result.add(temp);
			return;
		}
		for (int i = depth; i < n; ++i)
		{
			swap(arr, i, depth);
			curr[depth] = depth;
			generatePermutations(arr, depth + 1);
			swap(arr, i, depth);
		}
	}
}
