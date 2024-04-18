#include <stdio.h>

int arr[1000000];
int nge[1000000];
int stack[1000000];
int top = -1;

int main() {
	int n;

	scanf("%d", &n);
	for (int i = 0; i < n; ++i) {
		scanf("%d", &arr[i]);
		nge[i] = -1;
	}

	for (int i = 0; i < n; ++i) {
		while (top != -1 && arr[stack[top]] < arr[i])
			nge[stack[top--]] = arr[i];
		stack[++top] = i;
	}

	for (int i = 0; i < n - 1; ++i)
		printf("%d ", nge[i]);
	printf("%d\n", nge[n - 1]);

	return 0;
}
