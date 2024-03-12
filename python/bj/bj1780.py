n = int(input())
orig = []
colors = [0, 0]

for _ in range(n):
    row = list(map(int, input().split()))
    orig.append(row)


def check_color(y, x, size):
    color = orig[y][x]

    for i in range(y, y + size):
        for j in range(x, x + size):
            if orig[i][j] != color:
                return False

    return True


def divide(y, x, size):
    if check_color(y, x, size) == True:
        if orig[y][x] == 1:
            colors[0] += 1
        else:
            colors[1] += 1
        return

    newsize = int(size / 2)
    for i in range(0, size, newsize):
        for j in range(0, size, newsize):
            divide(y + i, x + j, newsize)


divide(0, 0, n)

print(colors[1])
print(colors[0])
