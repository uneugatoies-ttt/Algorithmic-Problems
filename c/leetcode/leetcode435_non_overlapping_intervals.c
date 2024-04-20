// Following the greedy methodology; note that you don't have to actually build the resulting array that contains all the intervals.

#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
	int* ia = *(int**)a;
	int* ib = *(int**)b;
	return ia[1] - ib[1];
}

int eraseOverlapIntervals(int** intervals, int intervalsSize, int* intervalsColSize) {
	qsort(intervals, intervalsSize, sizeof(int*), &compare);
	int i, cnt = 0, end = intervals[0][1];

	for (i = 1; i < intervalsSize; ++i) {
		if (intervals[i][0] < end)
			cnt++;
		else
			end = intervals[i][1];
	}

	return cnt;
}