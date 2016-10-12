#!/bin/python3

import sys


s,t = tuple(map(int, input().strip().split(' ')))
a,b = tuple(map(int, input().strip().split(' ')))
m,n = tuple(map(int, input().strip().split(' ')))
apples = [int(apple_temp) for apple_temp in input().strip().split(' ')]
oranges = [int(orange_temp) for orange_temp in input().strip().split(' ')]

apple_count = 0
orange_count = 0
for apple in apples:
    if (apple + a) >= s and (apple + a) <= t:
        apple_count += 1
for orange in oranges:
    if (orange + b) >= s and (orange + b) <= t:
        orange_count += 1
           
print(apple_count)
print(orange_count)