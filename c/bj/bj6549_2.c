// Solution 2: following the divide and conquer paradigm ver. 2.

/*
	-> The reason why the former code kept failing:
		-> It was because the upper part of "maxAreaRect".
		The former code goes like this:

long maxAreaRect(int low, int high) {
	// base case: there's only one bar
	if (low == high) return hist[low];

	int mid = (low + high) / 2;

	long left = maxAreaRect(low, mid);
	long right = maxAreaRect(mid + 1, high);
	// ... the rest of the code
}
	
		After I changed it into the following, I could pass the judge:
long maxAreaRect(int low, int high) {
	int mid = (low + high) / 2;
	long minHeight = hist[mid];
	long mx = minHeight;

	if (low < high) {
		long left = maxAreaRect(low, mid);
		long right = maxAreaRect(mid + 1, high);
		mx = MAX(mx, MAX(left, right));
	}
	// ... the rest of the code
}

		But I don't fully understand the change yet. The former code worked well
		in BJ1725, which is very similar to this problem, except for the number of test cases.


	-> Additionally, I made the following changes, but I doubt if they affected the result:
		1) changed the "long long" type into the "long" type
		2) deleted the initial function calling for the recursive calling
		3) replaced the plain functions "getMax" and "getMin" with the macros "MAX" and "MIN"
		4) replaced the usage of "malloc()" and "free()" with the plain array

*/

#define _CRT_SECURE_NO_WARNINGS
#define MAX(a, b) (a > b ? a : b)
#define MIN(a, b) (a < b ? a : b)
#include <stdio.h>

int hist[100001];

long maxAreaRect(int low, int high) {
	int mid = (low + high) / 2;
	long minHeight = hist[mid];
	long mx = minHeight;

	if (low < high) {
		long left = maxAreaRect(low, mid);
		long right = maxAreaRect(mid + 1, high);
		mx = MAX(mx, MAX(left, right));
	}

	int l = mid;
	int r = mid;
	while (low < l && r < high) {
		if (hist[l - 1] <= hist[r + 1]) {
			r++;
			minHeight = MIN(hist[r], minHeight);
		}
		else {
			l--;
			minHeight = MIN(hist[l], minHeight);
		}
		mx = MAX(mx, minHeight * (r - l + 1));
	}

	if (r < high) {
		while (r < high) {
			r++;
			minHeight = MIN(hist[r], minHeight);
			mx = MAX(mx, minHeight * (r - l + 1));
		}
	} else if (l > low) {
		while (l > low) {
			l--;
			minHeight = MIN(hist[l], minHeight);
			mx = MAX(mx, minHeight * (r - l + 1));
		}
	}

	return mx;
}

int main() {
	while (1) {
		int n;
		scanf("%d", &n);
		if (n == 0) break;
		for (int i = 0; i < n; ++i)
			scanf("%d", &hist[i]);
		long mx = maxAreaRect(0, n - 1);
		printf("%ld\n", mx);
	}
	return 0;
}