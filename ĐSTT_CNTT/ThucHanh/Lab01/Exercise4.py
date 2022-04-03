

set1 = {1,2,3,4,5,6,7,8,9,10}
set2 = {2,4,6,8}

# CAU A
set3 = {0.101}
for i in set2:
    boolean1 = True
    for j in set1:
        if i == j:
            boolean = False
            break
    if boolean == False:
        set3.add(i)
set3.remove(0.101)
print(set3)

# CAU B
set4 ={0.101}
for i in set1:
    boolean2 = True
    for j in set2:
        if i == j:
            boolean2 = False
            break
    if boolean2:
        set4.add(i)
set4.remove(0.101)
print(set4)

# CAU C
x = int(input("Enter a number x : "))

set2.add(x)
print(set2)

# CAU D
x = int(input("Enter a number x : "))
set1.remove(x)
print(set1)




