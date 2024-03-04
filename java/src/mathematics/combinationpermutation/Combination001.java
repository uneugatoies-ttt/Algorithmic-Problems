package mathematics.combinationpermutation;

import java.util.ArrayList;
import java.util.List;

public class Combination001 {
	
	public static void main(String[] args) {
		List<Integer> elements = List.of(1, 2, 3, 4, 5);
		List<List<Integer>> result = generateCombinations(elements);
		
		for (List<Integer> c : result) {
			System.out.println(c);
		}
	}
	
	private static List<List<Integer>> generateCombinations(List<Integer> elements) {
		List<List<Integer>> result = new ArrayList<>();
		generateCombinationHelper(elements, 0, new ArrayList<>(), result);
		return result;
	}
	
	private static void generateCombinationHelper(
		List<Integer> elements, int start,
		List<Integer> current, List<List<Integer>> result
	) {
		result.add(new ArrayList<>(current));
		
		for (int i = start; i <elements.size(); ++i) {
			current.add(elements.get(i));
			generateCombinationHelper(elements, i + 1, current, result);
			current.remove(current.size() - 1);
		}
	}

}
