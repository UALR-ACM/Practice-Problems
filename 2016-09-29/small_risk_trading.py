n, k = map(int, input().split(' '))

successes = list(map(float, input().split(' ')))
maxProfits = map(float, input().split(' '))
losses = map(float, input().split(' '))

profits = list()

for s, m, l in zip(successes, maxProfits, losses):
    profits.append(s * m - (1 - s) * l)
    
maximum = 0
for i in range(k):
    m = max(profits)
    if m < 0:
        break

    profits.remove(m)
    maximum += m

print('%.2f' % maximum)