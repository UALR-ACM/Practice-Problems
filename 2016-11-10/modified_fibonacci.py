
def fib_generator(t1, t2):
    while True:
        yield t1
        t1, t2 = t2, t1+(t2**2)
        

t1, t2, n = list(map(int, input().split(' ')))
my_gen = fib_generator(t1, t2)
for i in range(n-1):
    next(my_gen)
print(next(my_gen))