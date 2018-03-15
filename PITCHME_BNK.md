---

## Python Data Type

- int 整数
- float 浮点数
- string 字符串
- None NoneType
- boolean: True or False
- dict/list/set
- ......
```python
print(type(123))
print(type(12.0))
print(type('string'))
print(type("string"))
print(type('s'))
print(type("s"))
print(type(None))
print(type(True))
print(type({}))
demo = []
print(type(demo))
print(type(set([])))
```
---

## Python variable

定义变量：
```python
x=10
print(x)
print(type(x))
x="98932"
print(type(x)) ## x 类型不固定
```
---

## Python Encoding

- 计算机内存保存Unicode，保存到硬盘为utf-8/或者输出至网页也是utf-8
- ascii 1个字节/unicode 2 个字节/可变长unicode
```python
print("中文")
print("chinese")
```

```python
print(ord('a'))
print(chr(3243))
```

```python
print(b'abcd') # bytes
print(type(b'abcd'))
```

```python
print('ABC'.encode('ascii'))
print('ABC'.encode('utf-8'))
print('中文'.encode('utf-8'))
print('中文'.encode('ascii'))
```

```python
print(b'acc'.decode('ascii'))
print(b'\xe4\xb8\xad\xe6\x96\x87'.decode('utf-8',errors='ignore'))
```

```python
print(len('abc中文'))
print(len('abc'))
print(len(('abc中文').encode('utf-8')))
```
- Tips: 强制python文件UTF-8编码

```python
# -*-* coding:utf-8 -*-
```

## Python字符串Format
```python
print('%.2f' % 3.1415926)
s1="this is "
s2="%2d-%2d"%(3,1)
s3="%s-%s"%("s1","s2")
s4 = "{s1}={s2}"
print(s1)
print(s2)
print(s3)
print("{s1}={s2}".format(s1="t1",s2="t2"))
```
---

## Python list/tuple

- list: 集合，添加删除其中元素,可以重复的值
- tuple：元组，可以理解和list类似
- list 的访问: 下标(index)访问/append 添加/pop()
- list的属性
- list 切片(slice)
```python
fruit_list = ['apple','banana','orange']
print(len(fruit_list))
print(fruit_list[0])
fruit_list.append('watermelon')
fruit_list.extend({"k1":"v1"})
print('water'[0])
print(fruit_list)
print(len(fruit_list))
print(fruit_list.pop())
print(len(fruit_list))
print("===========list slice===========")
print(fruit_list[1:3]) 
print(fruit_list[1:2])
print(fruit_list[:-1])
print(fruit_list[:-2])
print(fruit_list[:3])
print(fruit_list[2:])
matrix_2 = [
    ['a','m','s'],
    ['j','p','r','p'],
    ['a','b','l']
]
print(matrix_2[0])
print(matrix_2[2][1])
matrix_2.extend([['ads','ds'],['ds','ds']])
print(matrix_2)
```
---

## Python tuple

- tuple 定义
- tuple 操作，类似list
- tuple 不能append
```python
t1=(2,34)
print(t1[0])
print(t1[1])
t2=(2,[23,345])
print(t2[1][1])
t3=(1,[23,45,67],[4,67,90])
print(t3[2][1])
print(t1.extend([1,2])) ## error
print(t1.append(4)) ## error
print(t1)
```
---

## Python Control Flow

- if/else/elif
- for-in/for
- while
- break
- continue
```python
n=0
while n<10:
    print(n)
    n=n+1
    if n%3==0:
        continue
    if n%4==0:
        break

print("==== for in loop=======")
for i in range(1,10):
    print(i)

# for(i=0;i<10;i++): # error python not support
#     print(i)
```
---

## Python dict 

- 键值对 key/value pair
- dict 访问/扩展
- key 是不可变对象(list/set/dict不能作为key)
```python
dict_demo = {"k1":"v1","k2":"v2"}
print(dict_demo)
print(type(dict_demo))
print(len(dict_demo))
print(dict_demo["k1"])
print(dict_demo.get("k3","none"))
try:
    print(dict_demo["k3"]) ## keyindex error
except Exception as e:
    print(e)
for k,v in dict_demo.items():
    print("{key}={value}".format(key=k,value=v))

dict_demo.update({"k3":"v3"})
dict_demo["k4"]="v4"
print(dict_demo)


```
---

## python set

- set 不可重复
- set 值是不可变
- 其他操作类似约list
```python
set_demo = set([1,2,3,9])
set_demo.add(4)
set_demo.add(2)
set_demo2= set([1,2,3,4,3,4,5])
print(set_demo2)
print(set_demo)
print(set_demo.add(100))
print(set_demo.remove(1))
print(set_demo & set_demo2)
print(set_demo | set_demo2)
```
