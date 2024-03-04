package ict_practice.part3.dp;


public class Q36 {
	
	private static int moddist(String A, String B) {
		int n = A.length();
		int m = B.length();
		
		int[][] dp = new int[n + 1][m + 1];
		
		for (int i = 1; i < n + 1; ++i)
			dp[i][0] = i;
		for (int j = 1; j < m + 1; ++j)
			dp[0][j] = j;
		
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < m + 1; ++j) {
				if (A.charAt(i) == B.charAt(j))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
			}
		}
		
		return dp[n][m];
	}
	
	
}

// Drasticaly failed attempt
/*
public class Q36 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String A = s.next();
		String B = s.next();
		
		if (B.length() > A.length()) {
			String temp = B.substring(0);
			B = A.substring(0);
			A = temp.substring(0);
		}
		
		List<Integer>[] mat = new ArrayList[A.length()];
		for (int i = 0; i < A.length(); ++i)
			mat[i] = new ArrayList<>();
		
		int cnt = 0;
		for (int i = 0; i < A.length(); ++i) {
			int j;
			if (i == 0) j = 0;
			else {
				if (mat[i-1].get(0) == -1) {
					int temp = i-2;
					while (temp > -1 && mat[temp].get(0) == -1)
						temp--;
					if (temp == -1)
						j = 0;
					else 
						j = mat[temp].get(0) + 1;
				} else {
					j = mat[i-1].get(0) + 1;
				}
			}
			
			for (; j < B.length(); ++j) {
				if (A.charAt(i) == B.charAt(j)) {
					mat[i].add(j);
					break;
				}
			}
			
			if (j == B.length()) {
				mat[i].add(-1);
				cnt++;
			}
		}
		
		if (mat[A.length() - 1].get(0) < B.length() - 1 && mat[A.length() - 1].get(0) != -1) {
			cnt += ((B.length() - 1) - mat[A.length() - 1].get(0));
		}
		
		System.out.println(cnt);
	}

}*/
