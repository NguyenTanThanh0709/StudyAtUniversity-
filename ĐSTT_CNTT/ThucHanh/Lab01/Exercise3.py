import numpy as np


# CAU A
dictionary = {1: 1, 2: 4, 3: 9, 4: 16, 5: 1, 6: 36, 7: 1, 8: 64, 9: 81}
x = int(input("Enter a number x : "))


count = 0
for i in dictionary:
     if dictionary[i] == x:
         count+=1
print("so phan tu x xuat hien la : ", count)

# CAU B
dictionary = {1: 1, 2: 4, 3: 9, 4: 16, 5: 1, 6: 36, 7: 1, 8: 64, 9: 81}
dictionary[2] = 100
print(dictionary)


# CAU C
dictionary = {1: 1, 2: 4, 3: 9, 4: 16, 5: 1, 6: 36, 7: 1, 8: 64, 9: 81}
x = int(input("Enter a number x : "))

for key, value in dict(dictionary).items():
  if value == x:
    del dictionary[key]


print(dictionary)

# CAU D
dictionary = {1: 1, 2: 4, 3: 9, 4: 16, 5: 1, 6: 36, 7: 1, 8: 64, 9: 81}
dictionary1 = {10:12}

dictionary.update(dictionary1,2)
print(dictionary)