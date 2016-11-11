from itertools import permutations

s = int(input().strip())

cache = {1: 1, 2: 2, 3: 4}
def calc(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    elif n <= 0:
        return 0
    
    if n not in cache:
        cache[n] = calc(n-1) + calc(n-2) + calc(n-3)
    return cache[n]

for i in range(s):
    count = 0
    outputs = []
    n = int(input().strip())
    print(calc(n))