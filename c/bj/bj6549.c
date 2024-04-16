// Solution 1: following the divide and conquer "paradigm".

#include <stdio.h>
#include <stdlib.h>

int* histogram;
int n;
long long getMaxArea(int low, int high);
long long getMaxAreaConsecutive(int low, int mid, int high);
long long getmx(long long x, long long y);
long long getmn(long long x, long long y);

int main() {
	histogram = (int*)malloc(sizeof(int) * 100001);
	long long m;
	
	while (1) {
		scanf("%d", &n);
		if (n == 0) break;

		for (int i = 0; i < n; ++i)
			scanf("%d", &histogram[i]);
		m = getMaxArea(0, n - 1);
		printf("%lld\n", m);
	}

	free(histogram);

	return 0;
}

long long getmx(long long x, long long y) {
	return (x > y) ? x : y;
}

long long getmn(long long x, long long y) {
	return (x < y) ? x : y;
}

long long getMaxArea(int low, int high) {
	int mid;
	mid = (low + high) / 2;
	if (low == high) return histogram[low];

	long long left = getMaxArea(low, mid);
	long long right = getMaxArea(mid + 1, high);
	long long whole = getMaxAreaConsecutive(low, mid, high);

	long long mx = getmx(whole, getmx(left, right));

	return mx;
}

long long getMaxAreaConsecutive(int low, int mid, int high) {
	long long len = 0;
	long long leftward = mid;
	long long leftval = histogram[leftward];
	long long rightward = mid + 1;
	long long rightval = histogram[rightward];
	long long result = 2 * getmn(leftval, rightval);

	while (low < leftward && rightward < high) {
		if (leftval <= rightval) {
			if (rightval <= histogram[++rightward]) {
				result = getmx(rightval * (rightward - leftward), getmx(result, leftval * (rightward - leftward + 1)));
			} else {
				rightval = histogram[rightward];
				result = getmx(result, getmn(rightval, leftval) * (rightward - leftward + 1));
			}
		} else {
			if (leftval <= histogram[--leftward]) {
				result = getmx(leftval * (rightward - leftward), getmx(result, rightval * (rightward - leftward + 1)));
			} else {
				leftval = histogram[leftward];
				result = getmx(result, getmn(rightval, leftval) * (rightward - leftward + 1));
			}
		}
	}
	
	while (low < leftward) {
		leftval = getmn(leftval, histogram[--leftward]);
		if (leftval <= rightval)
			result = getmx(result, leftval * (rightward - leftward + 1));
		else
			result = getmx(result, getmx(rightval * (rightward - leftward + 1), leftval * (rightward - leftward)));
	}
	while (rightward < high) {
		rightval = getmn(rightval, histogram[++rightward]);
		if (rightval <= leftval)
			result = getmx(result, rightval * (rightward - leftward + 1));
		else
			result = getmx(result, getmx(leftval * (rightward - leftward + 1), rightval * (rightward - leftward)));
	}

	return result;
}
