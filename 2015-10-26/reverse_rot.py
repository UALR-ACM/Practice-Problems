mapping = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_."
with open("input.txt", 'r') as f:
	for line in f:
		try:
			rot, message = line.strip().split(' ')
			finalMsg = ""
			message = message[::-1]
			for letter in message:
				i = mapping.index(letter)
				finalMsg += mapping[(int(rot) + i) % len(mapping)]
			print(finalMsg)
		except:
			pass