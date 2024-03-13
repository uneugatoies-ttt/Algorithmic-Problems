n = int(input())
data = list(map(int, input().split()))
data.sort()

result = 0
curr = 0

for i in data:
    curr += 1
    if curr >= i:
        result += 1
        curr = 0

print(result)