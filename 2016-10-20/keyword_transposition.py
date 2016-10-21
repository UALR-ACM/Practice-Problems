from string import ascii_uppercase

N = int(input())
for i in range(N):
    key = input()
    ciphertext = input()
    
    # Get unique letters
    for c in key:
        if c not in new_key:
            new_key += c
    key = new_key
    
    matrix = [key,]
    new_letters = list(ascii_uppercase)
    for letter in key:
        new_letters.remove(letter)
    
        
    row = ''
    for i, c in enumerate(new_letters):
        if i % len(key) == len(key) - 1:
            matrix.append(row+c)
            row = ''
        else:
            row += c
    matrix.append(row)
       
    subs = ''
    for c in sorted(key):
        i = key.index(c)
        
        for row in matrix:
            if i < len(row):
                subs += row[i]
    
    decoded = ''
    for c in ciphertext:
        if c == ' ':
            decoded += ' '
            continue
        decoded += ascii_uppercase[subs.index(c)]
    print(decoded)
        