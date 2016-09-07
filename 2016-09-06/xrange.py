# HackerRank Problem: https://www.hackerrank.com/contests/infinitum16-firsttimer/challenges/xrange-and-pizza
# Note: This only passed the first two test cases

n, m = [int(x) for x in input().split(' ')]
polygon = str(''.join([str(x) for x in range(n)]))

for action in range(m):
    tipe, k = [int(x) for x in input().split(' ')]
    if tipe == 1: # rotator
        polygon = polygon[k:] + polygon[:k]
    else:
        polygon = polygon[::-1]
        

asc_counter = 0
des_counter = 0
for i, ch in enumerate(polygon[:-1]):
    if ch > polygon[i+1]:
        des_counter += 1
        
for i, ch in enumerate(polygon[:-1]):
    if ch < polygon[i+1]:
        asc_counter += 1
        
if asc_counter > des_counter:
    print('1 ' + str(min(polygon.index('0'), len(polygon) - polygon.index('0'))))
else:
    print('2 ' + str(polygon.index('0')))
    