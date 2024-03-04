package mathematics.combinationpermutation;

import java.util.ArrayList;
import java.util.List;

public class CombinationBetter {

	public static void main(String[] args) {
		List<Integer> arr1 = List.of(1, 2, 3);
		Combination<Integer> comb1 = new Combination<>(arr1.size(), 2);
		comb1.generateCombination(arr1, 0, 0, 0);
		System.out.println(comb1.getResult().toString());
		
		

		
		/*
		List<Position> arr2 = new ArrayList<>();
		arr2.add(new Position(9, 23));
		arr2.add(new Position(6, 71));
		arr2.add(new Position(80, 49));
		Combination002<Position> comb2 = new Combination002<>(arr2.size(), 2);
		comb2.generateCombination(arr2, 0, 0, 0);
		List<List<Position>> comb2Result = comb2.getResult();
		
		for (int i = 0; i < comb2Result.size(); ++i)
		{
			for (Position p : comb2Result.get(i))
			{
				System.out.print("(" + p.getX() + ", " + p.getY() + ") ");
			}
			System.out.println();
		}
		*/
	}
	
}

class Combination<T> {
	private int n;
	private int r;
	private int[] curr;
	private List<List<T>> result;
	public List<List<T>> getResult() {
		return this.result;
	}
	public Combination(int n, int r) {
		this.n = n;
		this.r = r;
		this.curr = new int[r];
		this.result = new ArrayList<>();
	}
	public void generateCombination(List<T> arr, int depth, int index, int target) {
		// Base case: if depth is equal to "r", a combination is complete
		if (depth == r) {
			List<T> temp = new ArrayList<>();
			for (int i = 0; i < r; ++i)
				temp.add(arr.get(curr[i]));
			result.add(temp);
			return;
		}
		// Base case: if "target" is equal to "n", return
		if (target == n) return;
		// Include the current element in the combination
		curr[index] = target;
		generateCombination(arr, depth + 1, index + 1, target + 1);
		// "Exclude" the current element from the combination
		generateCombination(arr, depth, index, target + 1);
	}
}


class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}


