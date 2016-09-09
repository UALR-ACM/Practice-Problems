#!/usr/bin/py
# Head ends here

def lonelyinteger(b):
    b = list(b)
    for item in b:
        if b.count(item) == 1:
            return item
    return None

# Tail starts here
if __name__ == '__main__':
    a = int(input())
    b = map(int, input().strip().split(" "))
    print(lonelyinteger(b))
