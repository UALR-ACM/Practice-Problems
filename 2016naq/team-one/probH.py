import itertools
from pprint import pprint

in1 = raw_input().split(' ')
in2 = raw_input().split(' ')

n1 = int(in1[0])
n2 = int(in2[0])

hotdogs = list(map(int, in1[1:]))
buns = list(map(int, in2[1:]))

# All combinations of hotdog packs
hpacks = list()
for i in range(1, n1+1):
    hpacks += [set(itertools.combinations(hotdogs, i))]

bpacks = list()
for i in range(1, n2+1):
    bpacks += [set(itertools.combinations(buns, i))]


# Get sums for each combination
hsums = set()
bsums = set()

for comb in hpacks:
    for c in comb:
        hsums.add(sum(c))

for comb in bpacks:
    for c in comb:
        bsums.add(sum(c))

inter = hsums.intersection(bsums)
try:
    print(min(inter))
except:
    print('impossible')