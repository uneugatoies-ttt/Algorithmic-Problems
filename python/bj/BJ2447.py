import sys

n = int(sys.stdin.readline().rstrip())
result = [[0 for _ in range(n)] for _ in range(n)]

def make_void(n, y, x):
    tri = int(n / 3)
    for i in range(y + tri, y + (tri * 2)):
        for j in range(x + tri, x + (tri * 2)):
            result[i][j] = 2

def do_recursively(n, y, x):
    make_void(n, y, x)
    if n == 3: return
    tri = int(n / 3)
    for i in range(0, n, tri):
        for j in range(0, n, tri):
            if i == tri and j == tri: continue
            do_recursively(tri, y + i, x + j)

do_recursively(n, 0, 0)

for i in range(n):
    for j in range(n):
        if result[i][j] == 0:
            print('*', end='')
        else:
            print(' ', end='')
    print()