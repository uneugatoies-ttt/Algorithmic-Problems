// following the divide and conquer paradigm

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int hist[100001];
int n;

long long getMin(long long x, long long y) {
	return x < y ? x : y;
}

long long getMax(long long x, long long y) {
	return x > y ? x : y;
}

long long maxAreaRect(int low, int high) {
	// base case: there's only one bar
	if (low == high) return hist[low];

	int mid = (low + high) / 2;

	long long left = maxAreaRect(low, mid);
	long long right = maxAreaRect(mid + 1, high);

	int minHeight = hist[mid];
	long long crossing = minHeight;
	int l = mid;
	int r = mid;
	while (low < l && r < high) {
		if (hist[l - 1] <= hist[r + 1]) {
			r++;
			minHeight = getMin(hist[r], minHeight);
		} else {
			l--;
			minHeight = getMin(hist[l], minHeight);
		}
		crossing = getMax(crossing, minHeight * (r - l + 1));
	}
	while (r < high) {
		r++;
		minHeight = getMin(hist[r], minHeight);
		crossing = getMax(crossing, minHeight * (r - l + 1));
	}
	while (l > low) {
		l--;
		minHeight = getMin(hist[l], minHeight);
		crossing = getMax(crossing, minHeight * (r - l + 1));
	}

	return getMax(crossing, getMax(left, right));
}

long long maxArea(int n) {
	return maxAreaRect(0, n - 1);
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; ++i)
		scanf("%d", &hist[i]);
	long long mx = maxArea(n);
	printf("%lld\n", mx);
	return 0;
}