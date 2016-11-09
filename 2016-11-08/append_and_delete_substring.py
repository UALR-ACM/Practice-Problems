#!/bin/python3

import sys


s = input().strip()
t = input().strip()
k = int(input().strip())

n = 0

# Pad the shorter input so s and t are equal length
if len(s) < len(t):
    s += ' ' * (len(t) - len(s))
elif len(t) < len(s):
    t += ' ' * (len(s) - len(t))


for i in range(len(s)):
    if s[i] != t[i]:
        # Unpad the inputs
        s = s.strip()
        t = t.strip()
        n = (len(s) - i) + (len(t) - i)
        break
        
if s == t:
    print('Yes')
elif k >= n and ((k - n) % 2 == 0 or s[0] != t[0]):
    print('Yes')
else:
    print('No')