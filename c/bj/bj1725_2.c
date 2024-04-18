// Using the stack data structure

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int n;
int hist[100001];
int stack[100001];
int top = -1;

long getMaxVal(long x, long y) {
	return x > y ? x : y;
}

long getMaxArea() {
	long mx = 0;
	for (int i = 0; i < n; ++i) {
		while (top != -1 && hist[stack[top]] >= hist[i]) {
			int height = hist[stack[top--]];
			int width = (top == -1) ? i : i - 1 - stack[top];
			mx = getMaxVal(mx, height * width);
		}
		stack[++top] = i;
	}

	while (top != -1) {
		int height = hist[stack[top--]];
		int width = (top == -1) ? n : n - 1 - stack[top];
		mx = getMaxVal(mx, height * width);
	}

	return mx;
}

void solve() {
	scanf("%d", &n);
	for (int i = 0; i < n; ++i)
		scanf("%d", &hist[i]);
	printf("%ld\n", getMaxArea());
}

int main() {
	solve();
	return 0;
}
