def main():
    n = input()
    div = 2
    bestFact = 2.6313083693369353016721801216e+35

    if n > bestFact:
        div = 32
    elif n == bestFact:
        print('32')
        return
    print(div)
    print(n)
    while (n != div):
        n = n / div
        div += 1
        # print(div)
        #print(n)

    print(div)


main()