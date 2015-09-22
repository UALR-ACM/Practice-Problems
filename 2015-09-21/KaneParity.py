# -*- coding: utf-8 -*-

#open the file to read
with open("parity.in", 'r') as numbers:
    # loop through each line
    for line in numbers:
        # strip the newlines off each line
        num = line.strip()
        # quit if the character is a #
        if num == '#': break
        # get the total number of ones  in the number
        num_ones = sum(1 for i in num if i == '1')

        # if there's an even number of one and we want an even number,
        # we're fine. Just add a zero
        if num_ones % 2 == 0 and num[-1] == 'e':
            print(num[:-1] + '0')
        # if it needs to be odd, add a one
        elif num_ones % 2 == 0 and num[-1] == 'o':
            print(num[:-1] + '1')
        # same for odd number of ones, just the reverse
        elif num_ones % 2 == 1 and num[-1] == 'e':
            print(num[:-1] + '1')
        else:
            print(num[:-1] + '0')

# The above is ACM quality code. It's fast to write, but not necessarily the
# shortest or most elegant.
# On the other hand, we can do too much on one line as well...

# with open("parity.in", 'r') as numbers:
#     for line in numbers:
#         num = line.strip()
#         if num == '#': break
#         # I wrote this, and an hour later I'm not entirely sure what it does...
#         print(num[:-1] + str(int(sum(1 for i in num if i == '1') % 2 == int(num[-1] == 'e'))))


