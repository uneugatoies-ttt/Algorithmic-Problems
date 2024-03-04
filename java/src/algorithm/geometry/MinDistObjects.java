package algorithm.geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/*
	# Things I should learn and investigate:
		-> What is the golden section search?
		
		-> What is the error tolerance? How should you use it in this problem?
		
 
 
*/

public class MinDistObjects {
	
	private static double findMinDistanceTime(
		double ax, double ay, double bx, double by,
		double cx, double cy, double dx, double dy
	) {
		double mintime = 0.0;
		double epsilon = 1e-8;	// error tolerance
		
		// Use golden section search to find the minimum distance
		double a = 0.0, b = 1.0;
		
		while ((b - a) > epsilon) {
			double t1 = a + (3 - Math.sqrt(5)) / 2 * (b - a);
			double t2 = a + b - t1;
			
			double dist1 = calculateDistance(
				ax + (bx - ax) * t1,
				ay + (by - ay) * t1,
				cx + (dx - cx) * t1,
				cy + (dy - cy) * t1
			);
			
			double dist2 = calculateDistance(
				ax + (bx - ax) * t2,
				ay + (by - ay) * t2,
				cx + (dx - cx) * t2,
				cy + (dy - cy) * t2
			);
			
			if (dist1 < dist2)
				b = t2;
			else
				a = t1;
		}
		
		mintime = (a + b) / 2;
		return mintime;
	}
	
	// calculate the Euclidean distance between two points
	private static double calculateDistance(
		double x1, double y1, double x2, double y2
	) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	// calculate the positions of the objects at a given time
	private static double[] getPosition(
		double x1, double y1, double x2, double y2, double t	
	) {
		double[] pos = new double[2];
		pos[0] = x1 + (x2 - x1) * t;
		pos[1] = y1 + (y2 - y1) * t;
		return pos;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		double ax = Integer.parseInt(token.nextToken());
		double ay = Integer.parseInt(token.nextToken());
		double bx = Integer.parseInt(token.nextToken());
		double by = Integer.parseInt(token.nextToken());
		double cx = Integer.parseInt(token.nextToken());
		double cy = Integer.parseInt(token.nextToken());
		double dx = Integer.parseInt(token.nextToken());
		double dy = Integer.parseInt(token.nextToken());
		
		double mintime = findMinDistanceTime(ax, ay, bx, by, cx, cy, dx, dy);
		
		double[] posObj1 = getPosition(ax, ay, bx, by, mintime);
		double[] posObj2 = getPosition(cx, cy, dx, dy, mintime);
		
		double mindist = calculateDistance(posObj1[0], posObj1[1], posObj2[0], posObj2[1]);

		writer.write(String.valueOf(mindist));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
