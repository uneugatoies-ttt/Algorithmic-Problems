
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct {
	int x, y;
} Point;

Point* points;

int compareX(const void* a, const void* b) {
	Point* as = (Point*)a;
	Point* bs = (Point*)b;
	return as->x - bs->x;
}
int compareY(const void* a, const void* b) {
	Point* as = (Point*)a;
	Point* bs = (Point*)b;
	return as->y - bs->y;
}

int getDistSquare(Point a, Point b) {
	return pow(a.x - b.x, 2) + pow(a.y - b.y, 2);
}

int doBruteForce(int low, int high) {
	int mn = (int)1e9;

	for (int i = low; i <= high - 1; ++i) {
		for (int j = i + 1; j <= high; ++j) {
			int dist = getDistSquare(points[i], points[j]);
			if (mn > dist) mn = dist;
		}
	}

	return mn;
}

int getClosestDistCrossing(int low, int mid, int high, int mn) {
	Point* candidates = malloc(sizeof(Point));

	int size = 0;
	int capacity = 1;

	int midx = points[mid].x;
	int xd;
	for (int i = low; i <= high; ++i) {
		xd = points[i].x - midx;
		if (xd * xd < mn) {
			if (size == capacity) {
				capacity *= 2;
				candidates = realloc(candidates, capacity * sizeof(Point));
			}
			candidates[size++] = points[i];
		}
	}

	qsort(candidates, size, sizeof(Point), compareY);

	int yd;
	int ds;
	for (int i = 0; i < size - 1; ++i) {
		for (int j = i + 1; j < size; ++j) {
			yd = candidates[j].y - candidates[i].y;
			if (yd * yd >= mn)
				break;
			else {
				ds = getDistSquare(candidates[i], candidates[j]);
				mn = mn < ds ? mn : ds;
			}
		}
	}

	free(candidates);
	return mn;
}

int getClosestDist(int low, int high) {
	if (high - low + 1 < 4) return doBruteForce(low, high);

	int mid = (low + high) / 2;
	int left = getClosestDist(low, mid);
	int right = getClosestDist(mid + 1, high);
	int mn = left < right ? left : right;
	int crossing = getClosestDistCrossing(low, mid, high, mn);

	return mn < crossing ? mn : crossing;
}

int main() {
	int n;
	scanf("%d", &n);
	points = (Point*)malloc(n * sizeof(Point));
	if (points == NULL)
		return 1;
	
	for (int i = 0; i < n; ++i)
		scanf("%d %d", &points[i].x, &points[i].y);

	qsort(points, n, sizeof(Point), compareX);

	printf("%d", getClosestDist(0, n - 1));

	free(points);
	return 0;
}