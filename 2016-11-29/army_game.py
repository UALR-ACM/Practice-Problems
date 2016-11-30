#!/bin/python3
# https://www.hackerrank.com/contests/w26/challenges/game-with-cells
import sys


n,m = input().strip().split(' ')
n,m = [int(n),int(m)]

d, r = divmod(n*m, 4)

if n == 1:
    print(sum(divmod(m, 2)))
elif m == 1:
    print(sum(divmod(n, 2)))
else:
    print(d + sum(divmod(r, 2)))
