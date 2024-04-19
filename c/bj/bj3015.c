#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define GREATEST_POSSIBLE_NUM 500000
#define EMPTY -1

struct group_by_height {
	int height;
	int number;
};

int n;
int line[GREATEST_POSSIBLE_NUM];
struct group_by_height stack[GREATEST_POSSIBLE_NUM];
int top = EMPTY;

long count_pairs() {
	long cnt = 0;
	struct group_by_height new_group;
	for (int i = 0; i < n; ++i) {
		new_group.height = line[i];
		new_group.number = 1;
		while (top != EMPTY && stack[top].height <= line[i]) {
			cnt += stack[top].number;
			if (stack[top].height == line[i])
				new_group.number += stack[top].number;
			top--;
		}
		if (top != EMPTY)
			cnt++;
		stack[++top] = new_group;
	}
	return cnt;
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; ++i)
		scanf("%d", &line[i]);
	printf("%ld\n", count_pairs());
	return 0;
}