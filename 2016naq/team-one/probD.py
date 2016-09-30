



def main():
    line = raw_input()

    if line == '':
        print('possible')
        return
    if len(line) % 2 == 1:
        print('impossible')
        return


    i = 0
    j = len(line) - 1

    swapped = False
    poss = True

    while i < j:
        ch1 = line[i]
        ch2 = line[j]

        if ch1 == ')' and ch2 == '(':
            if swapped:
                poss = False
                break
            swapped = True
        elif ch1 == ')' and ch2 == ')':
            if swapped:
                poss = False
                break
            swapped = True
        elif ch1 == '(' and ch2 == '(':
            if swapped:
                poss = False
                break
            swapped = True

        i += 1
        j -= 1

    if poss:
        print('possible')
    else:
        print('impossible')


main()