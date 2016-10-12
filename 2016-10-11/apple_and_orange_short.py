s, t = tuple(map(int, input().strip().split(' ')))
a, b = tuple(map(int, input().strip().split(' ')))
input()
apples, oranges = [int(apple_temp) for apple_temp in input().strip().split(' ')], [int(orange_temp) for orange_temp in input().strip().split(' ')]
print(str(len([apple for apple in apples if (apple + a) >= s and (apple + a) <= t])) + '\n' + str(len([orange for orange in oranges if (orange + b) >= s and (orange + b) <= t])))