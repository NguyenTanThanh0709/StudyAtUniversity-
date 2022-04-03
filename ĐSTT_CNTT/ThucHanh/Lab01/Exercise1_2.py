import numpy as np

# EXERCISE 1
lst = [1,2,5,3,7,9,0]

s = set(lst)
t = tuple(lst)
d = dict()
for index, value in enumerate(lst):
    d[index] = value

print(s)
print(t)
print(d)

# EXERCISE 2
dictionary = {1 : 'hihi', 2 : 'haha', 3 : 'hehe'}

l = []
t = ()
s = {}

for i in dictionary:
    l.append(dictionary[i])
    t = t + (dictionary[i],)
    s[i] = dictionary[i]

print(l)
print(t)
print(s)