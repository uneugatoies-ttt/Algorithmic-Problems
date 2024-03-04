package leetcode;

import java.util.Arrays;

public class _377CombinationSumIV {
	public static void main(String[] args) {
		int[] nums = { 9 };
		int target = 3;
		
		_377SolutionI solution = new _377SolutionI();
		System.out.println(solution.combinationSum4(nums, target));
	}
}

class _377SolutionI {
	int[] dp = new int[1001];
	
    public int combinationSum4(int[] nums, int target) {
    	Arrays.sort(nums);
    	if (nums[0] > target) return 0;
    	for (int i = 0; i < nums[0]; ++i)
    		dp[i] = 0;
    	for (int i = 0; i < nums.length; ++i)
    		dp[nums[i]] = 1;
    	
    	for (int i = nums[0] + 1; i <= target; ++i)
    		for (int j = 0; j < nums.length; ++j)
    			if (i - nums[j] > 0)
    				dp[i] += dp[i - nums[j]];
    	
    	return dp[target];
    }
	
	
}