# this is not an original idea, saw it in the solution set but recreated it in python 3
for i in range(int(input())):
    n = int(input())
    m = list(map(int, input().split(" ")))
    a = sum(m)
    b = 0
    ans = "NO"
    for x in range(n):
        a -= m[x]
        if (a == b):
            ans = "YES"
            break
        b += m[x]
    print(ans)
