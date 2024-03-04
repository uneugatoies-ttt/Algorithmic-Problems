package leetcode;

public class _463IslandPerimeter {
	
	public static void main(String[] args) {
		//int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		int[][] grid = {{0,1}};
		Solution463 s = new Solution463();
		System.out.println(s.islandPerimeter(grid));
	}

}

class Solution463 {
	private int[] dy = {-1, 1, 0, 0};
	private int[] dx = {0, 0, -1, 1};
	
    public int islandPerimeter(int[][] grid) {
    	int height = grid.length;
    	int width = grid[0].length;
    	
    	int yy, xx;
    	int cnt = 0;
    	int tempCnt;
    	for (int i = 0; i < height; ++i) {
    		for (int j = 0; j < width; ++j) {
    			if (grid[i][j] == 0) continue;
    			tempCnt = 0;
    			for (int k = 0; k < 4; ++k) {
    				yy = i + dy[k];
    				xx = j + dx[k];
    				
    				if (yy < 0 || yy >= height || xx < 0 || xx >= width ||
    					grid[yy][xx] == 0)
    					tempCnt++;
    			}
    			cnt += tempCnt;
    		}
    	}
    	
    	return cnt;
    }
}
