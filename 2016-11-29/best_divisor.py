#!/bin/python3
# https://www.hackerrank.com/contests/w26/challenges/best-divisor
import sys, math


n = int(input().strip())


def divisors(x):
    for i in range(2, (x//2)+1):
        if x % i == 0:
            yield i
    yield x
           


greatest = 1
for div in divisors(n):
    power = sum([int(c) for c in str(div)])
    if power > greatest:
        greatest = div
        
print(greatest)
