package leetcode;

import java.io.BufferedReader;

public class LC121BestTimeToBuyAndSellStock {

    private static class Solution {

        private int[] changes;
        private int INF = (int) -1e9;

        private int findMaxCrossing(int low, int mid, int high) {
            int leftSum = INF, rightSum = INF;
            int sum = 0;
            for (int i = mid; i >= low; --i) {
                sum += changes[i];
                if (sum > leftSum)
                    leftSum = sum;
            }
            sum = 0;
            for (int i = mid + 1; i <= high; ++i) {
                sum += changes[i];
                if (sum > rightSum)
                    rightSum = sum;
            }
            return leftSum + rightSum;
        }

        private int findMaxProfit(int low, int high) {
            if (high <= low) return changes[low];

            int mid = (low + high) / 2;

            int leftProfit = findMaxProfit(low, mid);
            int rightProfit = findMaxProfit(mid + 1, high);
            int crossingProfit = findMaxCrossing(low, mid, high);

            return Math.max(crossingProfit, Math.max(leftProfit, rightProfit));
        }

        public int maxProfit(int[] prices) {
            if (prices.length == 1) return 0;
            changes = new int[prices.length - 1];
            for (int i = 0; i < prices.length - 1; ++i)
                changes[i] = prices[i + 1] - prices[i];
            int maxProfit = findMaxProfit(0, changes.length - 1);
            if (maxProfit < 0) return 0;
            return maxProfit;
        }

    }

    public static void main(String[] args) {
        int[] testCase = {7,6,4,3,1};
        Solution s = new Solution();
        System.out.println(s.maxProfit(testCase));
    }

}