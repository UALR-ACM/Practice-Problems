#!/bin/python3

# HackerRank Problem: https://www.hackerrank.com/challenges/beautiful-binary-string

import sys


n = int(input().strip())
B = input().strip()

total = 0
while '010' in B:
    total += 1
    i = B.index('010')
    B = B[:i] + '111' + B[i+3:]
    
print(total )

print([i for i in range(10)])