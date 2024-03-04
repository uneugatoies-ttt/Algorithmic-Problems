package ict_practice.part3.impl;

// This approach was doomed because I didn't consider whether indices like y + 1 or x - 2 exceed 
// the given extent or not. I was stupid for sure, but I really don't like the problem itself.
/*
public class Q12 {
	
	
	public void deleteThis(int y, int x, int[][] grid, int pog) {
		// delete a pillar (0)
		if (pog == 0) 
		{
			if (grid[y][x] == 2)
				grid[y][x] = 1;
			else 
				grid[y][x] = -1;
		}
		// delete a beam (1)
		else 
		{
			if (grid[y][x] == 2)
				grid[y][x] = 0;
			else 
				grid[y][x] = -1;
		}
	}
	
	public int[][] solution(int n, int[][] bf) {
		
		// -1 : none
		// 0  : a pillar
		// 1  : a beam
		// 2  : a pillar and a beam at this coordinate
		int[][] grid = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			Arrays.fill(grid[i], -1);
		}
		
		int x = 0, y = 0;
		for (int i = 0; i < bf.length; ++i) {
			x = bf[i][0];
			y = bf[i][1];
			
			// extent checking
			if (x < 0 || x > n - 1 || y < 0 || y > n - 1)
				continue;
			
			// Deleting
			if (bf[i][3] == 0)
			{
				// Delete a pillar
				if (bf[i][2] == 0)
				{
					// There is a pillar at the top.
					if ((grid[y + 1][x] == 0 || grid[y + 1][x] == 2))
					{
						// There are 2 beams at both sides.
						if (grid[y + 1][x - 1] >= 1 && grid[y + 1][x] >= 1)
						{
							if (grid[y + 1][x - 2] >= 1)
							{
								if ((grid[y][x + 1] == 0 || grid[y][x + 1] == 2) || grid[y + 1][x + 1] >= 1)
								{
									deleteThis(y, x, grid, 0);
								}
							}
							else if (grid[y][x - 1] == 0 || grid[y][x - 1] == 2)
							{
								if ((grid[y][x + 1] == 0 || grid[y][x + 1] == 2) || grid[y + 1][x + 1] >= 1)
								{
									deleteThis(y, x, grid, 0);
								}
							}
						}
						// There is a beam at the left side.
						else if (grid[y + 1][x - 1] >= 1)
						{
							if (grid[y][x - 1] == 0 || grid[y][x - 1] == 2)
							{
								deleteThis(y, x, grid, 0);
							}
						}
						// There is a beam at the right side.
						else if (grid[y + 1][x] >= 1)
						{
							if (grid[y][x + 1] == 0 || grid[y][x + 1] == 2)
							{
								deleteThis(y, x, grid, 0);
							}
						}
					}
					// There is no pillar at the top; but there are 2 beams at both sides.
					else if (grid[y + 1][x - 1] >= 1 && grid[y + 1][x] >= 1)
					{
						if (grid[y + 1][x - 2] >= 1)
						{
							if ((grid[y][x + 1] == 0 || grid[y][x + 1] == 2) || grid[y + 1][x + 1] >= 1)
							{
								deleteThis(y, x, grid, 0);
							}
						}
						else if (grid[y][x - 1] == 0 || grid[y][x - 1] == 2)
						{
							if ((grid[y][x + 1] == 0 || grid[y][x + 1] == 2) || grid[y + 1][x + 1] >= 1)
							{
								deleteThis(y, x, grid, 0);
							}
						}
					}
					// There is no pillar at the top; but there is a beam at the left side.
					else if (grid[y + 1][x - 1] >= 1)
					{
						if (grid[y][x - 1] == 0 || grid[y][x - 1] == 2)
						{
							deleteThis(y, x, grid, 0);
						}
					}
					// There is no pillar at the top; but there is a beam at the right side.
					else if (grid[y + 1][x] >= 1)
					{
						if (grid[y][x + 1] == 0 || grid[y][x + 1] == 2)
						{
							deleteThis(y, x, grid, 0);
						}
					}
				}
				// Delete a beam
				else 
				{
					if (grid[y][x - 1] >= 1 && grid[y][x + 1] >= 1)
					{
						if (grid[y - 1][x - 1] == 0 || grid[y - 1][x - 1] == 2)
						{
							if (
								(grid[y - 1][x + 1] == 0 || grid[y - 1][x + 1] == 2) ||
								(grid[y - 1][x + 2] == 0 || grid[y - 1][x + 2] == 2)
							) {
								deleteThis(y, x, grid, 1);
							}
						}
						else if (grid[y - 1][x] == 0 || grid[y - 1][x] == 2)
						{
							if (
									(grid[y - 1][x + 1] == 0 || grid[y - 1][x + 1] == 2) ||
									(grid[y - 1][x + 2] == 0 || grid[y - 1][x + 2] == 2)
							) {
								deleteThis(y, x, grid, 1);
							}
						}
					}
					else if ((grid[y - 1][x] == 0 || grid[y - 1][x] == 2) && (grid[y - 1][x + 1] == 0 || grid[y - 1][x + 1] == 2))
					{
						deleteThis(y, x, grid, 1);
					}
					else if (grid[y - 1][x] == 0 || grid[y - 1][x] == 2)
					{
						if (grid[y][x + 1] == 0 || grid[y][x + 1] == 2)
						{
							if (grid[y][x + 1] == 2 && (grid[y - 1][x + 2] == 0 || grid[y - 1][x + 2] == 2))
							{
								deleteThis(y, x, grid, 1);	
							}
						}
						else if (grid[y][x + 1] == 1 && (grid[y - 1][x + 2] == 0 || grid[y - 1][x + 2] == 2))
						{
							deleteThis(y, x, grid, 1);
						}
					}
					else if (grid[y - 1][x + 1] == 0 || grid[y - 1][x + 1] == 2)
					{
						if (grid[y][x] == 0 || grid[y][x] == 2)
						{
							if (grid[y][x - 1] == 2 && (grid[y - 1][x - 1] == 0 || grid[y - 1][x - 1] == -1))
							{
								deleteThis(y, x, grid, 1);	
							}
						}
						else if (grid[y][x - 1] == 1 && (grid[y - 1][x - 1] == 0 || grid[y - 1][x - 1] == 2))
						{
							deleteThis(y, x, grid, 1);
						}
					}
				}
			}
			// Constructing
			else
			{
				// New pillar
				if (bf[i][2] == 0)
				{
					// On the ground
					// or there is a pillar at the bottom 
					// or there is a beam at either side
					if (y == 0 || 
					   (grid[y - 1][x] == 0 || grid[y - 1][x] == 2) ||
					   (grid[y][x - 1] == 1 || grid[y][x + 1] == 1))
					{
						if (grid[y][x] == 1)
							grid[y][x] = 2;
						else 
							grid[y][x] = 0;
					}
				}
				// New beam
				else 
				{
					// There are beams at both sides
					// Or, there is a pillar at either side
					if (
						(grid[y][x - 1] >= 1 && grid[y][x + 1] >= 1) ||
						(
							(grid[y - 1][x] == 0 || grid[y - 1][x] == 2) ||
							(grid[y - 1][x + 1] == 0 || grid[y - 1][x + 1] == 2)
						)
					)
					{
						if (grid[y][x] == 0)
							grid[y][x] = 2;
						else
							grid[y][x] = 1;
					}
				}
			}
		}
		
		List<Entry<int[], Integer>> list = new ArrayList<>();
		int[] temppos;
		
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 2) {
					temppos = new int[2];
					temppos[0] = i;
					temppos[1] = j;
					list.add(new SimpleImmutableEntry<>(temppos, 0));
					list.add(new SimpleImmutableEntry<>(temppos, 1));
				}
				if (grid[i][j] == 1) {
					temppos = new int[2];
					temppos[0] = i;
					temppos[1] = j;
					list.add(new SimpleImmutableEntry<>(temppos, 1));
				}
				if (grid[i][j] == 0) {
					temppos = new int[2];
					temppos[0] = i;
					temppos[1] = j;
					list.add(new SimpleImmutableEntry<>(temppos, 0));
				}
			}
		}
		
		// You have to inverse the order of y and x.
		int[][] result = new int[list.size()][3];
		
		for (int i = 0; i < list.size(); ++i) {
			result[i][0] = list.get(i).getKey()[1];
			result[i][1] = list.get(i).getKey()[0];
			result[i][2] = list.get(i).getValue();
		}
		
		return result;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		int[][] bf = new int[n][4];
		
		StringTokenizer token;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			bf[i][0] = Integer.parseInt(token.nextToken());
			bf[i][1] = Integer.parseInt(token.nextToken());
			bf[i][2] = Integer.parseInt(token.nextToken());
			bf[i][3] = Integer.parseInt(token.nextToken());
		}
		
		Q12 q = new Q12();
		int[][] result = q.solution(n, bf);
		for (int i = 0; i < result.length; ++i) {
			writer.write(Arrays.toString(result[i]));
			writer.write('\n');
		}
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
*/
