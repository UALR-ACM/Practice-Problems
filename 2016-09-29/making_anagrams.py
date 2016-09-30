a = input()
b = input()

for ch in a:
    if ch in b:
        a = a.replace(ch, '', 1)
        b = b.replace(ch, '', 1)
    
for ch in b:
    if ch in a:
        b = b.replace(ch, '', 1)
        a = a.replace(ch, '', 1)
    

print(len(a) + len(b))