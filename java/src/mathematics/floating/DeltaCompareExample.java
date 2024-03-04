package mathematics.floating;

public class DeltaCompareExample {
	
	// Return true iff the difference between v1 and v2 is less than delta.
	private static boolean deltaCompare(double v1, double v2, double delta) {
		return Math.abs(v1 - v2) < delta;
	}
	
	public static void main(String[] args) {
		double[] doubles = {1.0, 1.0001, 1.0000001, 1.0000000001, 1.0000000000001};
		double[] deltas = {0.01, 0.00001, 0.0000001, 0.0000000001, 0};
		
		for (int j = 0; j < deltas.length; ++j) {
			double delta = deltas[j];
			System.out.println("delta: " + delta);
			
			for (int i = 0; i < doubles.length - 1; ++i) {
				double d1 = doubles[i];
				double d2 = doubles[i + 1];
				boolean result = deltaCompare(d1, d2, delta);
				System.out.println("" + d1 + " == " + d2 + " ? " + result);
			}
			System.out.println();
		}
	}

}
