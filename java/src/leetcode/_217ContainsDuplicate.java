package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _217ContainsDuplicate {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 1 };
		int[] nums2 = { 1, 2, 3, 4 };
		int[] nums3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		
		_217Solution s = new _217Solution();
		
		System.out.println( s.containsDuplicate(nums1) );
		System.out.println( s.containsDuplicate(nums2) );
		System.out.println( s.containsDuplicate(nums3) );
		
	}
	

}

class _217Solution {
	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i< nums.length; ++i) {
			if (map.containsKey(nums[i]))
				return true;
			
			map.put(nums[i], nums[i]);
		}
		
		return false;
	}
}
