from collections import deque

n, m, targetDist, sourceNode = map(int, input().split())
sourceNode -= 1

adj = [[] for _ in range(n)]
for _ in range(m):
    node1, node2 = map(int, input().split())
    adj[node1 - 1].append(node2 - 1)

dist = [-1] * n
dist[sourceNode] = 0

q = deque([sourceNode])
while q:
    curr = q.popleft()
    for nextnext in adj[curr]:
        if dist[nextnext] == -1:
            dist[nextnext] = dist[curr] + 1
            q.append(nextnext)

flag = False
for i in range(n):
    if dist[i] == targetDist:
        print(i + 1)
        flag = True

if flag == False:
    print(-1)


