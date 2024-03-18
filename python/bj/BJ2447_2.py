import sys

n = int(sys.stdin.readline().rstrip())
result = [[' '] * n for _ in range(n)]

def solve(n, x, y):
    if n == 1:
        result[y][x] = '*'
        return

    tri = int(n/3)
    for j in range(3):
        for i in range(3):
            if i == 1 and j == 1:
                continue
            solve(tri, x + i * tri, y + j * tri)

solve(n, 0, 0)
for b in result:
    print(''.join(b))