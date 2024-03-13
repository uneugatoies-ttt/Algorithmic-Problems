# a little bit more advanced solution





# simple but inefficient solution
'''
n, m, k = map(int, input().split())

arr = list(map(int, input().split()))

arr.sort(reverse=True)

mx = arr[0]
secondmax = arr[1]

res = 0
jj = 0
for j in range(0, m):
    if jj == k:
        jj = 0
        res += secondmax
    else:
        jj += 1
        res += mx

print(res)
'''