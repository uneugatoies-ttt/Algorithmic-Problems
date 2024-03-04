package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11662_2 {
	
	public static void main(String[] args) throws IOException {
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

        // Find the time at which the distance is minimized
        double minTime = findMinDistanceTime(ax, ay, bx, by, cx, cy, dx, dy);

        // Calculate the positions of the objects at the minimized distance
        double[] positionObject1 = getPosition(ax, ay, bx, by, minTime);
        double[] positionObject2 = getPosition(cx, cy, dx, dy, minTime);

        // Calculate the minimum distance
        double minDistance = calculateDistance(positionObject1[0], positionObject1[1],
                positionObject2[0], positionObject2[1]);

        writer.write(String.valueOf(minDistance));
        writer.flush();
        writer.close();
        reader.close();
    }

    // Function to find the time at which the distance is minimized
    private static double findMinDistanceTime(
    	double ax, double ay, double bx, double by,
    	double cx, double cy, double dx, double dy
    ) {
        double minTime = 0.0;
        double epsilon = 1e-6; // Error tolerance

        // Use golden section search to find the minimum distance
        double a = 0.0, b = 1.0;

        while ((b - a) > epsilon) {
            double t1 = a + (3 - Math.sqrt(5)) / 2 * (b - a);
            double t2 = a + b - t1;

            double distance1 = calculateDistance(ax + (bx - ax) * t1, ay + (by - ay) * t1,
                    cx + (dx - cx) * t1, cy + (dy - cy) * t1);

            double distance2 = calculateDistance(ax + (bx - ax) * t2, ay + (by - ay) * t2,
                    cx + (dx - cx) * t2, cy + (dy - cy) * t2);

            if (distance1 < distance2) {
                b = t2;
            } else {
                a = t1;
            }
        }

        minTime = (a + b) / 2;
        return minTime;
    }

    // Function to calculate the Euclidean distance between two points
    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Function to calculate the positions of the objects at a given time
    private static double[] getPosition(double x1, double y1, double x2, double y2, double t) {
        double[] position = new double[2];
        position[0] = x1 + (x2 - x1) * t;
        position[1] = y1 + (y2 - y1) * t;
        return position;
    }
    
}








/*
public static void main(String[] args) throws IOException {
    // Input coordinates
    double ax = 1.0, ay = 2.0;
    double bx = 4.0, by = 6.0;
    double cx = 5.0, cy = 1.0;
    double dx = 2.0, dy = 5.0;

    // Find the time at which the distance is minimized
    double minTime = findMinDistanceTime(ax, ay, bx, by, cx, cy, dx, dy);

    // Calculate the positions of the objects at the minimized distance
    double[] positionObject1 = getPosition(ax, ay, bx, by, minTime);
    double[] positionObject2 = getPosition(cx, cy, dx, dy, minTime);

    // Calculate the minimum distance
    double minDistance = calculateDistance(positionObject1[0], positionObject1[1],
            positionObject2[0], positionObject2[1]);

    System.out.println("Minimum distance: " + minDistance);
}

// Function to find the time at which the distance is minimized
private static double findMinDistanceTime(double ax, double ay, double bx, double by,
                                          double cx, double cy, double dx, double dy) {
    double minTime = 0.0;
    double epsilon = 1e-6; // Error tolerance

    // Use golden section search to find the minimum distance
    double a = 0.0, b = 1.0;

    while ((b - a) > epsilon) {
        double t1 = a + (3 - Math.sqrt(5)) / 2 * (b - a);
        double t2 = a + b - t1;

        double distance1 = calculateDistance(ax + (bx - ax) * t1, ay + (by - ay) * t1,
                cx + (dx - cx) * t1, cy + (dy - cy) * t1);

        double distance2 = calculateDistance(ax + (bx - ax) * t2, ay + (by - ay) * t2,
                cx + (dx - cx) * t2, cy + (dy - cy) * t2);

        if (distance1 < distance2) {
            b = t2;
        } else {
            a = t1;
        }
    }

    minTime = (a + b) / 2;
    return minTime;
}

// Function to calculate the Euclidean distance between two points
private static double calculateDistance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
}

// Function to calculate the positions of the objects at a given time
private static double[] getPosition(double x1, double y1, double x2, double y2, double t) {
    double[] position = new double[2];
    position[0] = x1 + (x2 - x1) * t;
    position[1] = y1 + (y2 - y1) * t;
    return position;
}*/
