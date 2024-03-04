package ict_practice;

public class Example3_1 {
	public static void main(String[] args) {
		int n = 1260;
		SolutionExample3_1 solution = new SolutionExample3_1();
		System.out.println(solution.solve(n));
	}

}

class SolutionExample3_1 {
	
	
	public int solve(int n) {
		int[] coins = { 500, 100, 50, 10 };
		int cnt = 0;
		int temp = n;
		for (int i = 0; i < coins.length; ++i) {
			cnt += temp / coins[i];
			temp %= coins[i];
		}
		
		return cnt;
	}
	
}
