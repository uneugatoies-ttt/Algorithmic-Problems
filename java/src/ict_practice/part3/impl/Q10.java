package ict_practice.part3.impl;

public class Q10 {
	

	
	private int[][] rotateBy90ClockWise(int[][] orig)
	{
		int n = orig.length;
		int m = orig[0].length;
		int[][] result = new int[n][m];
		
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < m; ++j)
				result[j][n - i - 1] = orig[i][j];
		
		return result;
	}
	
	private boolean check(int[][] newLock, int locklen)
	{
		for (int i = locklen; i < locklen * 2; ++i)
			for (int j = locklen; j < locklen * 2; ++j)
				if (newLock[i][j] != 1)
					return false;
		return true;
	}

	public boolean solution(int[][] key, int[][] lock)
	{
		int n = lock.length;
		int m = key.length;
		
		int[][] newLock = new int[n * 3][n * 3];
		
		for (int i = 0; i < n; ++i) 
			for (int j = 0; j < n; ++j)
				newLock[i + n][j + n] = lock[i][j];
		
		for (int rotation = 0; rotation < 4; ++rotation)
		{
			key = rotateBy90ClockWise(key);
			
			for (int y = 0; y < n * 2; ++y)
			{
				
				for (int x = 0; x < n * 2; ++x)
				{
					for (int i = 0; i < m; ++i)
						for (int j = 0; j < m; ++j)
							newLock[y + i][x + j] += key[i][j];
					
					if (check(newLock, lock.length))
						return true;
					
					for (int i = 0; i < m; ++i)
						for (int j = 0; j < m; ++j)
							newLock[y + i][x + j] -= key[i][j];
				}
				
			}
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] key = { {0, 0, 0}, {1, 0, 0}, {0, 1, 1} };
		int[][] lock = { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} };
		
		Q10 q = new Q10();
		
		
		System.out.println(q.solution(key, lock));
		
	}

}
