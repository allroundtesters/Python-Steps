# -*- coding:utf-8 -*-

test = 0
Test = 1

if None == test:
    print(test)
else:
    print(test - 1)

# demo = []
# print(demo.__class__)
# print(dir())

if None == False:  # null
    print("test")
else:
    print("not test")

x = 3
y = 10
print(type(x + y))
print(y // x)
print(y / x)
print(type(10 / 1))
print(type(10 // 1))

s = "I'm a \"tester\""

list_demo = []
if None == list_demo:
    print(list_demo)
CONST_VALUE = 100
test = '''
testhi
teshit
tesht
steasgf
sdsafdsaf
safa
'''
print(test)

a = 1
b = 2
(a, b) = (b, a)

print(a)
print(b)


def swap(a, b):
    return (b, a)


t = swap(1, 2)
print(t[0], t[1])

t1 = 1 if a == b else 2
list_demo = [1, 2, 5, 3, 4]
demo = [x for x in list_demo if x < 3]
print(demo)
###########
result = []
for x in list_demo:
    if x < 3:
        result.append(x)
#######
print(demo)

demo_sort = [1, 2, 4, 3, 5.6]
# 求和
# 去重
demo = [1, 2, 3, 1, 2, 3]

print(demo_sort.sort())
print(demo_sort)
demo_sort.sort(reverse=False)
print(demo_sort)
print(print(1))
