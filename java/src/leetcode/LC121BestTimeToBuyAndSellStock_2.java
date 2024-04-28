package leetcode;

public class LC121BestTimeToBuyAndSellStock_2 {

    private static class Solution {

        private int[] changes;
        private static final int INF = (int) -1e9;

        private int getMaxProfitCrossing(int low, int mid, int high) {
            int left = INF, right = INF;
            int sum = 0;
            for (int i = mid; i >= low; --i) {
                sum += changes[i];
                if (sum > left)
                    left = sum;
            }
            sum = 0;
            for (int i = mid + 1; i <= high; ++i) {
                sum += changes[i];
                if (sum > right)
                    right = sum;
            }

            return left + right;
        }

        private int getMaxProfit(int low, int high) {
            // base case
            if (low >= high) return changes[low];

            int mid = (low + high) / 2;

            int left = getMaxProfit(low, mid);
            int right = getMaxProfit(mid + 1, high);
            int crossing = getMaxProfitCrossing(low, mid, high);

            return Math.max(crossing, Math.max(left, right));
        }

        public int maxProfit(int[] prices) {
            if (prices.length == 1) return 0;

            changes = new int[prices.length - 1];
            for (int i = 0; i < prices.length - 1; ++i)
                changes[i] = prices[i + 1] - prices[i];
            int mx = getMaxProfit(0, changes.length - 1);

            if (mx < 0) return 0;

            return mx;
        }
    }


    public static void main(String[] args) {

    }

}
