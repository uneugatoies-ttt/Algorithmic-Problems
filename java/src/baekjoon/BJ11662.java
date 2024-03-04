package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11662 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double aX1 = Double.parseDouble(st.nextToken());
        double aY1 = Double.parseDouble(st.nextToken());
        double aX2 = Double.parseDouble(st.nextToken());
        double aY2 = Double.parseDouble(st.nextToken());
        double cX1 = Double.parseDouble(st.nextToken());
        double cY1 = Double.parseDouble(st.nextToken());
        double cX2 = Double.parseDouble(st.nextToken());
        double cY2 = Double.parseDouble(st.nextToken());
        
        int interval = 1000000;
        
        double aDX = (aX2 - aX1) / interval;
        double aDY = (aY2 - aY1) / interval;
        double cDX = (cX2 - cX1) / interval;
        double cDY = (cY2 - cY1) / interval;
        
        double t = -1 * ((aX1 - cX1) * (aDX - cDX) + (aY1 - cY1) * (aDY - cDY)) / (Math.pow(aDX - cDX, 2) + Math.pow(aDY - cDY, 2));
        
        if(!Double.isNaN(t) && t < interval && t > 0) {
            double min = getDistance(aX1 + aDX * t, aY1 + aDY * t, cX1 + cDX * t, cY1 + cDY * t);
            System.out.println(min);
        } else {
            double min1 = getDistance(aX1, aY1, cX1, cY1);
            double min2 = getDistance(aX2, aY2, cX2, cY2);
            
            System.out.println(Math.min(min1, min2));
        }
    }
    
    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
	
}







	/*
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
		
		double adx = (bx - ax);
		double cdx = (dx - cx);
		double ady = (by - ay);
		double cdy = (dy - cy);
		
		double numerator = -1 * ((ax - cx) * (adx - cdx) + (ay - cy) * (ady - cdy));
		double denominator = Math.pow(adx - cdx, 2) + Math.pow(ady - cdy, 2);
		
		double t = numerator / denominator;
	
		
		double res = Math.sqrt(Math.pow((ax - cx) + (adx - cdx) * t, 2) + Math.pow((ay - cy) + (ady - cdy) * t, 2));
		
		System.out.println(res);
		
	}	

*/

/*
	-> I was getting something wrong with the problem;
	it is not a problem that merely requires you to earn the shortest 
	distance between two points on two segments. It is requiring you
	to consider the two objects that are moving on two segments.
*/

// Probably failed attempt.
/*
public class BJ11662 {
	
	private static double ax, ay, bx, by, cx, cy, dx, dy;
	
	private static double bs() {
		
		
		double leftx = Math.min(ax, bx);
		double lefty = Math.min(ay, by);
		double rightx = Math.max(ax, bx);
		double righty = Math.max(ay, by);
		
		double midx, midy;
		double temp, res = Double.MAX_VALUE;
		
		double ir = (dy - cy) / (dx - cx);
		
		while (leftx <= lefty && rightx <= righty) {
			midx = (leftx + rightx) / 2;
			midy = (lefty + righty) / 2;
			
			temp = Math.abs((ir * -1 * midx) + midy + (ir * cx) - cy) / Math.sqrt((Math.pow(ir, 2)) + 1);
			
			if (temp < res) {
				res = temp;
				
			}
		}
		
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		ax = Integer.parseInt(token.nextToken());
		ay = Integer.parseInt(token.nextToken());
		bx = Integer.parseInt(token.nextToken());
		by = Integer.parseInt(token.nextToken());
		cx = Integer.parseInt(token.nextToken());
		cy = Integer.parseInt(token.nextToken());
		dx = Integer.parseInt(token.nextToken());
		dy = Integer.parseInt(token.nextToken());
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
}
*/