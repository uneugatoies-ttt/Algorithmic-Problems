package algorithm.search;

public class TernarySearch001 {
	
	double ternarySearch(double l, double r) {
		double eps = 1e-9;		// eps indicates the absolute error
		while (r - l > eps) {
			double m1 = l + (r - l) / 3;
			double m2 = r - (r - l) / 3;
			double f1 = correspondingFunction(m1);
			double f2 = correspondingFunction(m2);
			if (f1 < f2)
				l = m1;
			else
				r = m2;
		}
		
		return correspondingFunction(l);
	}
	
	// A unimodal function
	double correspondingFunction(double x) {
		// This is only a temporary value for suppressing errors.
		// Should be changed later.
		return 0.0;	
	}

}
