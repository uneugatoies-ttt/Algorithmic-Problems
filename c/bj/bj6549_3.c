// Solution 3: using the stack data structure.

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define GREATEST_POSSIBLE_SIZE 100000
#define	EMPTY -1

struct candidate_rect {
	int height;
	int width;
};

int n;
int hist[GREATEST_POSSIBLE_SIZE];
struct candidate_rect stack[GREATEST_POSSIBLE_SIZE];
int top = EMPTY;

long get_max_rect() {
	long mx = 0;
	long curr;
	int width;
	for (int i = 0; i < n; ++i) {
		struct candidate_rect new_rect;
		new_rect.height = hist[i];
		new_rect.width = 1;
		width = 0;
		while (top != EMPTY && stack[top].height >= new_rect.height) {
			if (stack[top].height != new_rect.height) {
				width += stack[top].width;
				curr = (long) width * stack[top].height;
				mx = mx > curr ? mx : curr;
			}
			new_rect.width += stack[top--].width;
		}
		stack[++top] = new_rect;
	}

	width = 0;
	while (top != EMPTY) {
		width += stack[top].width;
		curr = (long) width * stack[top].height;
		mx = mx > curr ? mx : curr;
		top--;
	}
	
	return mx;
}

void solve() {
	while (1) {
		scanf("%d", &n);
		if (n == 0) break;
		for (int i = 0; i < n; ++i)
			scanf("%d", &hist[i]);
		printf("%ld\n", get_max_rect());
	}
}

int main() {
	solve();
	return 0;
}
