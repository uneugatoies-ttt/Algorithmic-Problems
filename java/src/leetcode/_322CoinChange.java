package leetcode;

import java.util.Arrays;

public class _322CoinChange {
	public static void main(String[] args) {
		
	}
}

class _322Solution {
	int[] dp = new int[10005];
	public int coinChange(int[] coins, int amount) {
		int temp = 20000;
		Arrays.fill(dp, temp);
		dp[0] = 0;
		for (int i = 1; i <= amount; ++i)
			for (int j = 0; j < coins.length; ++j)
				if (i - coins[j] >= 0 && dp[i - coins[j]] != temp)
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
		if (dp[amount] != temp)	return dp[amount];
		else					return -1;
	}
}






// I don't even understand why I wrote this kind of stupid code anyway.
// Why? Did my intelligence decline in the past few days? But that's ridiculous.
/*
class _322Solution {
    int[] dp = new int[10005];
	
	public void solve(int[] coins, int amount) {
		for (int i = coins[0]; i <= amount; ++i)
			dp[i] = 20000;
		for (int i = 0; i < coins.length; ++i)
			dp[coins[i]] = 1;
		for (int i = coins[0] + 1; i <= amount; ++i) {
			for (int j = 0; j < coins.length; ++j)
				if (i - coins[j] > 0 && dp[i - coins[j]] != 0)
					dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
			if (dp[i] == 20000)
				dp[i] = 0;
		}
	}

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;   
		Arrays.sort(coins);
		if (coins[0] > 10000)	return -1;
		solve(coins, amount);
		if (dp[amount] == 0)	return -1;
		else 					return dp[amount];
    }
}*/