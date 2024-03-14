from itertools import permutations
def solution(n, weak, dist):
    length = len(weak)
    for i in range(length):
        weak.append(weak[i] + n)

    result = len(dist) + 1

    for start in range(length):
        for friends in list(permutations(dist, len(dist))):
            count = 1
            current_position = weak[start] + friends[count-1]
            for index in range(start, start + length):
                if current_position < weak[index]:
                    count += 1
                    if count > len(dist):
                        break
                    current_position = weak[index] + friends[count-1]

            result = min(result, count)

    if result > len(dist):
        return -1
    return result


print(solution(12, [1,5,6,10], [1,2,3,4]))