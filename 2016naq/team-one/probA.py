

orig = 'abcdefghijklmnopqrstuvwxyz'
new = ['@', '8', '(', '|)', '3', '#', '6', '[-]', '|', '_|', '|<', '1', '[]\/[]', '[]\[]', '0', '|D', '(,)', '|Z', '$', '\'][\'', '|_|', '\/', '\/\/', '}{', '`/', '2']


line = raw_input().lower()
trans = ''

for ch in line:
    try:
        trans += new[orig.index(ch)]
    except:
        trans += ch

print(trans)