
q = int(input())

for _ in range(q):
    n = int(input())
    m = [list(map(int, input().split(' '))) for _ in range(n*2)]
    print(sum([max(m[i][j], m[i][2*n-1-j], m[2*n-1-i][j], m[2*n-1-i][2*n-1-j]) for i in range(n) for j in range(n)]))
