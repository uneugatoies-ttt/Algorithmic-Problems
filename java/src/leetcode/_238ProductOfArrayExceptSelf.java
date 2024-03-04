package leetcode;

import java.util.Arrays;

public class _238ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		_238Solution2 s = new _238Solution2();
		
		int[] nums = {1,2,3,4};
		int[] nums2 = {-1,1,0,-3,3};
		
		int[] answer = s.productExceptSelf(nums2);
		
		for (int i : answer)
			System.out.print(i + " ");
		System.out.println();
	}
	

}

class _238Solution2 {
	public int[] productExceptSelf(int[] nums) {
		int[] answer = new int[nums.length];
		Arrays.fill(answer, 1);
		for (int i = 1; i < nums.length; ++i)
			answer[i] = answer[i - 1] * nums[i - 1];
		int prev = 1;
		int prod;
		for (int i = nums.length - 2; i > -1; --i) {
			prod = prev * nums[i + 1];
			answer[i] *= prod;
			prev = prod;
		}
		return answer;
	}
}