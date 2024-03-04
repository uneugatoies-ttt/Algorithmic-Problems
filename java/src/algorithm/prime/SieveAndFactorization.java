package algorithm.prime;

import java.util.ArrayList;
import java.util.List;

public class SieveAndFactorization {
	
	// very simple prime factorization
	public static List<Integer> factorSimple(int n) {
		List<Integer> ret = new ArrayList<>();
		int sqrtn = (int) Math.sqrt(n);
		for (int div = 2; div <= sqrtn; ++div)
			while (n % div == 0) {
				n /= div;
				ret.add(div);
			}
		if (n > 1) ret.add(n);
		return ret;
	}
	
	// the simplest Sieve
	public static void sieveOfEratosthenes(boolean[] sieve, int n) {
		sieve[0] = sieve[1] = false;
		int sqrtn = (int) Math.sqrt(n);
		
		for (int i = 3; i <= sqrtn; ++i)
			if (sieve[i])
				for (int j = i * i; j <= n; j += i)
					sieve[j] = false;
	}
	
	// the modified Sieve for prime factorization
	public static void eratosthenes2(int[] minFactor, int n) {
		minFactor[0] = minFactor[1] = -1;
		
		for (int i = 2; i <= n; ++i)
			minFactor[i] = i;
		
		int sqrtn = (int) Math.sqrt(n);
		
		for (int i = 2; i <= sqrtn; ++i)
			if (minFactor[i] == i)
				for (int j = i * i; j <= n; j += i)
					if (minFactor[j] == j)
						minFactor[j] = i;
	}
	
	// prime factorization with Sieve
	public static List<Integer> factor(int[] minFactor, int n) {
		List<Integer> ret = new ArrayList<>();
		while (n > 1) {
			ret.add(minFactor[n]);
			n /= minFactor[n];
		}
		return ret;
	}
	
	public static void main(String[] args) {
		
		
	}

}
