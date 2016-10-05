
q = int(input())

for _ in range(q):
    n = int(input())
    m = []
    for _ in range(n*2):
        m.append(list(map(int, input().split(' '))))
       
        
    # Sorcery here...
    bigMax = 0
    
    for i in range(n):
        for j in range(n):
            try:
                bigMax += max(m[i][j], m[i][2*n-1-j], m[2*n-1-i][j], m[2*n-1-i][2*n-1-j])
            except:
                pass
                #print("(" + str(i) + ", " + str(j) + ")")
    print(bigMax)
