#include <stdlib.h>
#define INF -1000000000

int getMaxProfitCrossing(int* changes, int low, int mid, int high) {
	int left, right;
	left = right = INF;
	int sum = 0;
	for (int i = mid; i >= low; --i) {
		sum += changes[i];
		if (sum > left)
			left = sum;
	}
	sum = 0;
	for (int i = mid + 1; i <= high; ++i) {
		sum += changes[i];
		if (sum > right)
			right = sum;
	}
	return left + right;
}

int getMaxProfit(int* changes, int low, int high) {
	if (low >= high) return changes[low];

	int mid = (low + high) / 2;
	
	int left = getMaxProfit(changes, low, mid);
	int right = getMaxProfit(changes, mid + 1, high);
	int crossing = getMaxProfitCrossing(changes, low, mid, high);

	int mx = left > right ? left : right;
	mx = mx > crossing ? mx : crossing;

	return mx;
}

int maxProfit(int* prices, int pricesSize) {
	if (pricesSize == 1) return 0;

	int* changes = (int*) malloc(sizeof(int) * (pricesSize - 1));
	if (changes == NULL) {
		fprintf(stderr, "Malloc failed\n");
		return -1; // or handle error in other way
	}
	for (int i = 0; i < pricesSize - 1; ++i)
		changes[i] = prices[i + 1] - prices[i];
	int mx = getMaxProfit(changes, 0, pricesSize - 2);
	free(changes);
	
	if (mx < 0) return 0;

	return mx;
}
