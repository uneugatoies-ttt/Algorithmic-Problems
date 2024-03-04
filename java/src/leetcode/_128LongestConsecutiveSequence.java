package leetcode;

import java.util.Arrays;

public class _128LongestConsecutiveSequence {
	public static void main(String[] args) {
		_128Solution s = new _128Solution();
		int[] nums1 = { 100, 4, 200, 1, 3, 2 };
		int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		int[] nums3 = {};
		int[] nums4 = { 1, 0, 2, 1 };
		
		System.out.println(s.longestConsecutive(nums1));
		System.out.println(s.longestConsecutive(nums2));
		System.out.println(s.longestConsecutive(nums3));
		System.out.println(s.longestConsecutive(nums4));
	}
}

class _128Solution {
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int max = 1;
		int temp = 1;
		
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == nums[i - 1] + 1) {
				temp++;
			} else if (nums[i] == nums[i - 1]) {
				continue;
			} else {
				if (temp > max)
					max = temp;
				temp = 1;
			}
		}
		
		if (temp > max)
			max = temp;
		
		return max;
	}
}