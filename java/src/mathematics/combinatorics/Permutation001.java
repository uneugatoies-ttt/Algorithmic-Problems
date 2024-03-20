package mathematics.combinatorics;

import java.util.List;
import java.util.ArrayList;

public class Permutation001 {
	
	private static List<List<Integer>> generatePermutations(List<Integer> elements) {
		List<List<Integer>> result = new ArrayList<>();
		generatePermutationsHelper(elements, new ArrayList<>(), result);
		return result;
	}
	
	private static void generatePermutationsHelper(
		List<Integer> elements,
		List<Integer> curr,
		List<List<Integer>> result
	) {
		if (curr.size() == elements.size()) {
			result.add(new ArrayList<>(curr));
			return;
		}
		
		for (Integer element : elements) {
			if (!curr.contains(element)) {
				curr.add(element);
				generatePermutationsHelper(elements, curr, result);
				curr.remove(curr.size() - 1);
			}
		}
	}
	
    public static void main(String[] args) {
        List<Integer> elements = List.of(1, 2, 3);
        List<List<Integer>> result = generatePermutations(elements);

        for (List<Integer> p : result) {
            System.out.println(p);
        }
    }

}
