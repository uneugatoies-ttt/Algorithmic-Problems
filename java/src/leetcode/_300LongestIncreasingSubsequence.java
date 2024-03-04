package leetcode;

import java.util.Arrays;

public class _300LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums1 = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int[] nums2 = { 0, 1, 0, 3, 2, 3 };
		int[] nums3 = { 7, 7, 7, 7, 7, 7,  7 };
		int[] nums4 = new int[2500];
		for (int i = 0; i < 2500; ++i)
			nums4[i] = 2500 - i;
		
		int[] nums5 = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		_300Solution s = new _300Solution();
		System.out.println(s.lengthOfLIS(nums5));
	}
}

class _300Solution {
	int[] len = new int[2500];
    public int lengthOfLIS(int[] nums) {
        Arrays.fill(len, 1);
        int mx = 0;
        for (int i = 1; i < nums.length; ++i) {
        	for (int j = 0; j < i; ++j) {
        		if (nums[i] > nums[j])
        			len[i] = Math.max(len[i], len[j] + 1);
        		else if (nums[i] == nums[j])
        			len[i] = len[j];
        	}
        	if (len[mx] < len[i])
        		mx = i;
        }
        
        return len[mx];
    }
}
