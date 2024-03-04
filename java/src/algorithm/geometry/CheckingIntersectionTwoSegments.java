package algorithm.geometry;

public class CheckingIntersectionTwoSegments {

	// Algorithm for checking whether two segments intersect; it works, I think.
	// Mainly, this utilizes orientation; but my understanding
	// on the concept lacks. IWAAIL
	private static int orientation(int[] p, int[] q, int[] r) {
		int val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
		
		if (val == 0)		return 0;	// Collinear
		else if (val > 0)	return 1;	// Clockwise
		else				return 2;	// Counterclockwise
	}
	
	private static boolean onSegment(int[] p, int[] q, int[] r) {
		return (
				q[0] <= Math.max(p[0], r[0]) &&
				q[0] >= Math.min(p[0], r[0]) &&
				q[1] <= Math.max(p[1], r[1]) &&
				q[1] >= Math.min(p[1], r[1])
		);
	}
	
	private static boolean doIntersect(int[][] seg1, int[][] seg2) {
		int[] p1 = { seg1[0][0], seg1[0][1] };
		int[] q1 = { seg1[1][0], seg1[1][1] };
		int[] p2 = { seg2[0][0], seg2[0][1] };
		int[] q2 = { seg2[1][0], seg2[1][1] };
		
		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);
		
		if (o1 != o2 && o3 != o4)
			return true;
		
		if (o1 == 0 && onSegment(p1, p2, q1))
			return true;
		
		if (o2 == 0 && onSegment(p1, q2, q1))
			return true;
		
		if (o3 == 0 && onSegment(p2, p1, q2))
			return true;
		
		if (o4 == 0 && onSegment(p2, q1, q2))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] seg1 = {{0,0},{5,20}};
		int[][] seg2 = {{30,0},{55,34}};
		
		if (doIntersect(seg1, seg2))
			System.out.println("INTERSECT");
		else
			System.out.println("DO NOT INTERSECT");
	}

}


// Original pseudocode:
/*
def orientation(p, q, r) {
	val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])

	if (val == 0):	return 0		// collinear	
	else if (val > 0):	return 1		// clockwise	
	else			return 2		// counterclockwise
}

def on_segment(p, q, r) {
	return (q[0] <= max(p[0], r[0]) && 
		q[0] >= min(p[0], r[0]) &&
		q[1] <= max(p[1], r[1]) &&
		q[1] >= min(p[1], r[1])
}

// true: they intersect
def do_intersect(segment1, segment2) {
	p1, q1 = segment1
	p2, q2 = segment2

	o1 = orientation(p1, q1, p2)
	o2 = orientation(p1, q1, q2)
	o3 = orientation(p2, q2, p1)
	o4 = orientation(p2, q2, q1)

	if (o1 != o2 && o3 != o4)
		return true

	if (o1 == 0 && on_segment(p1, p2, q1))
		return true

	if (o2 == 0 && on_segment(p1, q2, q1))
		return true

	if (o3 == 0 && on_segment(p2, p1, q2))
		return true

	if (o4 == 0 && on_segment(p2, q1, q2))
		return true

	return false
}
*/