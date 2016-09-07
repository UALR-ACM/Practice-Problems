#!/bin/python3

# HackerRank Problem: https://www.hackerrank.com/challenges/handshake

import sys

def getShakes(n):
    return int(n * ((n+1) / 2))

T = int(input().strip())
for a0 in range(T):
    N = int(input().strip())
    print(getShakes(N-1))