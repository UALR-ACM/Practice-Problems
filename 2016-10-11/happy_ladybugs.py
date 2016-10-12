#!/bin/python3

import sys
from collections import Counter

g = int(input().strip())

def isValid(s):
    prev = s[0]
    can_change = False
    for c in s[1:]:
        if c == prev:
            can_change = True
        else:
            if not can_change:
                return False
            can_change = False
            prev = c
    return True


def solve():
    n = int(input().strip())
    b = input().strip()

    c = Counter(b)
    space_count = c.pop('_', 0)
    if space_count == 0:
        return not isValid(b)

    return 1 in c.values()
        
        
        
print('\n'.join(['NO' if solve() else 'YES' for _ in range(g)]))
