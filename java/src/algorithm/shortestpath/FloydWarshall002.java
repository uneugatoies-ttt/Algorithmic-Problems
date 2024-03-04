package algorithm.shortestpath;

public class FloydWarshall002 {
	
	private static final int INF = 9999, vertices = 4;
	
	private static int[][] fw(int[][] graph) {
		int matrix[][] = new int[vertices][vertices];
		int i, j, k;
		
		for (i = 0; i < vertices; ++i)
			for (j = 0; j < vertices; ++j)
				matrix[i][j] = graph[i][j];
		
		for (k = 0; k < vertices; ++k)
			for (i = 0; i < vertices; ++i)
				for (j = 0; j < vertices; ++j)
					if (matrix[i][j] > matrix[i][k] + matrix[k][j])
						matrix[i][j] = matrix[i][k] + matrix[k][j];
		
		return matrix;
	}
	
	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < vertices; ++i) {
			for (int j = 0; j < vertices; ++j) {
				if (matrix[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int graph[][] = { 
				{ 0, 3, INF, 5 },
				{ 2, 0, INF, 4 },
				{ INF, 1, 0, INF },
				{ INF, INF, 2, 0 }
		};
		int[][] matrix = fw(graph);
		printMatrix(matrix);
	}

}
