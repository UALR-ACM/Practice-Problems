'''
File: knight-coins.py
Author: Zachary King
Description: Knight's coins ACM practice problem
'''

def getRich(n):
	days = list(range(n))
	pay, days_until_pay_increase = 1, 1
	total = 0
	for day in days:
		total += pay
		days_until_pay_increase -= 1
		if days_until_pay_increase == 0:
			pay += 1
			days_until_pay_increase = pay
	return total


def main():
	input_f = open("GoldCoinsInput.txt", 'r')
	output_f = open("GoldCoinsOutput.txt", 'w')

	for n in input_f:
		n = int(n)
		if n == 0: break
		output_f.write(str(getRich(n)) + "\n")

	input_f.close()
	output_f.close()

if __name__ == "__main__":
	main()