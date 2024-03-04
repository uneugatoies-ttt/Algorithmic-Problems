package etcetera;

import java.util.Arrays;
import java.util.Collections;

public class ArrayManipulation001 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		
		int[] reversed = Arrays.stream(arr)
								.boxed()
								.sorted(Collections.reverseOrder())
								.mapToInt(i -> i.intValue())
								.toArray();
		
		
		System.out.println(Arrays.toString(reversed));
	}

}
