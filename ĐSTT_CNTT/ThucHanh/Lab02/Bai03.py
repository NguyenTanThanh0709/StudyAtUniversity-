import numpy as np
 
def log_spacing2(lst):
    n = int(input("Enter the number of elements in vector : "))
    for i in range(1,n+1,1):
        lst.append(np.log(i))
    return lst

def log_spacing1(lst):
    n = int(input("Enter the number of elements in vector : "))
    for i in range(1,n+1,1):
        lst.append(10**i)
    return lst

bai3 = []
bai33 = []

print(log_spacing1(bai3))

print(log_spacing2(bai33))