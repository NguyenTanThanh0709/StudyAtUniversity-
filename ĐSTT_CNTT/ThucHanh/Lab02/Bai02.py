#Write a command to create the following vectors with n elements (user-defined variable)

import numpy as np



def CauA(lst):
    n = int(input("Enter the number of elements in vector A value even : "))
    for i in range(12,n+2,2):
        lst.append(i)
    return lst


def CauB(lst):
    n = int(input("Enter the number of elements in vector B value odd : "))
    for i in range(31,n+1,2):
        lst.append(i)
    return lst

def CauC(lst):
    n = int(input("Enter the number of elements in vector C value : "))
    for i in range(-n,n+1,1):
        lst.append(i)
    return lst

def CauD(lst):
    n = int(input("Enter the number of elements in vector D  : "))
    for i in range(n,-n-1,-1):
        lst.append(i)
    return lst

def CauE(lst):
    for i in range(10,-(4+2),-2):
        lst.append(i)
    return lst

def CauF(lst):
    n = int(input("Enter the number of elements in vector F  : "))
    for i in range(1,n+1,i):

        lst.append(2**i)
    return lst

def check_prime_number(n):
    
    flag = 1
    if (n <2):
        flag = 0
        return flag  
    

    for p in range(2, n):
        if n % p == 0:
            flag = 0
            break 
    return flag


def CauH(lst):
    n = int(input("Enter the number of elements in vector G  : "))
    count = 0
    for i in range(1000000):
        if check_prime_number(i) == 1:
            lst.append(1/i)
            count+= 1
        
        if(count == n):
            break
        
    return lst

lstH = []
print(CauH(lstH))

def fibonacci(n):
    f0 = 0
    f1 = 1
    fn = 1
 
    if (n < 0):
        return -1
    elif (n == 0 or n == 1):
        return n
    else:
        for i in range(2, n):
            f0 = f1
            f1 = fn
            fn = f0 + f1
        return fn

def CauG(lst):
    n = int(input("Enter the number of elements in vector H  : "))
    for i in range(0,n+1,1):
        try:
            lst.append(1/fibonacci(i))
        except:
            continue
    return lst

def CauI():
    lst = [1]
    n = int(input("Enter the number of elements in vector I  : "))
    
    for i in range(1,n+1,1):
        count = 2
        lst.append(lst[i-1] + count)
        count+=1

def CauK(lst):
    n = int(input("Enter the number of elements in vector K  : "))
    for i in range(0,n+1,1):
        lst.append(i/i+1)
    return lst

def CauL():
    lst = []
    for i in range(97,123,1):
        lst.append(chr(i))
    return lst

def CauM(lst):
    for i in range(65,91,1):
        lst.append(chr(i))
    return lst

lstA = []
lstB = []
lstC = []
lstD = []
lstE = []
lstM = []
lstG = []


# print("Vector A: ",CauA(lstA))
# print("Vector B: ",CauB(lstB))
# print("Vector C: ",CauC(lstC))
# print("Vector G: ",CauG(lstG))
# print("Vector D: ",CauD(lstD))
# print("Vector E: ",CauE(lstE))
# print("Vector F: ",CauF(lstF))
#print(CauL())
#print(CauM(lstM))
