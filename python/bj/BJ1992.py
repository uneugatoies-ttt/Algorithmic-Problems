n = int(input())
orig = []
for _ in range(n):
    row = list(input())
    orig.append(row)

def check_identity(side, y, x) -> bool:
    val = orig[y][x]
    for i in range(y, y+side):
        for j in range(x, x+side):
            if orig[i][j] != val:
                return False
    return True

def quadrisect(side, y, x):
    if (side == 1 or check_identity(side, y, x)):
        print(orig[y][x], end='')
        return

    newside = int(side / 2)
    print('(', end='')
    for i in range(0, side, newside):
        for j in range(0, side, newside):
            quadrisect(newside, y+i, x+j)
    print(')', end='')

quadrisect(n, 0, 0)