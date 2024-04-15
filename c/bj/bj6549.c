#include <stdio.h>
#include <math.h>

// This one keeps failing; but I don't know what is wrong. IWAAIL.
long long getAreaConsecutive(int low, int high, int mid, long long* histogram) {
	int leftward = mid;
	int rightward = mid;
	long long height = histogram[mid];
	long long max = histogram[mid];
	
	int temp;
	while (low < leftward && rightward < high) {
		if (histogram[rightward + 1] > histogram[leftward - 1]) {
			rightward++;
			if (histogram[rightward] < height)
				height = histogram[rightward];
		} else {
			leftward--;
			if (histogram[leftward] < height)
				height = histogram[leftward];
		}
		temp = height * ((long long) rightward - leftward + 1);
		max = (max > temp) ? max : temp;
	}

	while (high > rightward) {
		rightward++;
		if (histogram[rightward] < height)
			height = histogram[rightward];
		temp = height * ((long long) rightward - leftward + 1);
		max = (max > temp) ? max : temp;
	}

	while (low < leftward) {
		leftward--;
		if (histogram[leftward] < height)
			height = histogram[leftward];
		temp = height * ((long long) rightward - leftward + 1);
		max = (max > temp) ? max : temp;
	}


	return max;
}

long long getArea(int low, int high, long long* histogram) {
	if (low == high) return histogram[low];

	int mid = (low + high) / 2;

	long long left = getArea(low, mid, histogram);
	long long right = getArea(mid + 1, high, histogram);
	long long whole = getAreaConsecutive(low, high, mid, histogram);

	long long max;
	max = (left > right) ? left : right;
	max = (max > whole) ? max : whole;

	return max;
}

int main() {
	long long histogram[100001];

	int n;
	scanf("%d", &n);
	while (n != 0) {
		for (int i = 0; i < n; ++i)
			scanf("%lld", &histogram[i]);
	
		printf("%lld\n", getArea(0, n - 1, histogram));
	
		scanf("%d", &n);
	}

	return 0;
}