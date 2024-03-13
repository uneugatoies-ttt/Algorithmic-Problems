n, m = map(int, input().split())
grid = []
houses = []
chickens = []
for i in range(n):
    row = list(map(int, input().split()))
    grid.append(row)
    for j in range(n):
        if grid[i][j] == 1:
            houses.append([i, j])
        elif grid[i][j] == 2:
            chickens.append([i, j])

combination_result = []
csize = len(chickens)
curr = []
for _ in range(m):
    curr.append(0)

def _generate_combination(orig, depth, index, target):
    if depth == m:
        temp = []
        for i in range(m):
            temp.append(orig[curr[i]])
        combination_result.append(temp)
        return

    if target == csize: return

    curr[index] = target
    _generate_combination(orig, depth + 1, index + 1, target + 1)

    _generate_combination(orig, depth, index, target + 1)


_generate_combination(chickens, 0, 0, 0)

result = 1e9

for combination in combination_result:
    temp = 0
    for house in houses:
        tempdist = 1e9
        for eachc in combination:
            eachdist = abs(house[0] - eachc[0]) + abs(house[1] - eachc[1])
            if eachdist < tempdist:
                tempdist = eachdist
        temp += tempdist

    if temp < result:
        result = temp

print(result)
