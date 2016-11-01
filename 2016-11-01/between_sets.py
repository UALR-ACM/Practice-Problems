#!/bin/python3
# Problem: https://www.hackerrank.com/contests/w25/challenges/between-two-sets/submissions/code/7607875
import sys


n,m = tuple(map(int, input().strip().split(' ')))
a = [int(a_temp) for a_temp in input().strip().split(' ')]
b = [int(b_temp) for b_temp in input().strip().split(' ')]

def gcd(x, y):
    while(y):
        x, y = y, x % y
    return x

def lcm(x, y):
    lcm = (x*y) // gcd(x,y)
    return lcm

lowest = a[0]
for i in a:
    lowest = lcm(i, lowest)
    

def get_between():
    global lowest
    i = 1
    while True:
        yield i * lowest
        i += 1
        
gen = get_between()
between = set()

x = next(gen)
while x <= min(b):
    between.add(x)
    x = next(gen)
    
answer = 0
for i in between:
    multiple = True
    for y in b:
        if y % i != 0:
            multiple = False
    if multiple:
        answer += 1
            
print(answer)
