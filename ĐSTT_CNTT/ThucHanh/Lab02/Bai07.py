import numpy as np
from sympy import true

x = [3, 11, -9, -131, -1 ,1, -11, 91, -6, 407, -12, -11, 12, 153, 371]

#print(max(x))



def findMaxInTheVector(x):
    max = x[0]
    for i in range(len(x)):
        if x[i] > max:
            max = x[i]
    return max

def findMinInTheVector(x):
    min = x[0]
    for i in range(len(x)):
        if x[i] < min:
            min = x[i]
    return min

def findIndexOfTheValuesGreaterThan10(x):
    index = []
    for i in range(len(x)):
        if x[i] > 10:
            index.append(i)
    return index

def reverseVector(x):
    # d = np.flip(x)
    return x[::-1]

def sortAscendingVector(x):
    return sorted(x)

def sortDescendingVector(x):
    return sorted(x, reverse=True)

def countHowManyTimeHaveXiXj0(x):
    count = 0
    for i in range(len(x)):
        for j in range(i+1,len(x)):
            if x[i] + x[j] == 0:
                count += 1
    return count


def duplicateElements(x):
    duplicate = []
    for i in range(len(x)):
        check = True
        for j in range(i-1,0,-1):
            if x[i] == x[j]:
                check = False
                break
        if check == False:
            duplicate.append(x[i])
    
    return duplicate

def yVector(x):
    y = []
    n = len(x)
    for i in range(n):
        y.append(x[i] + x[n-i-1])
    return y

def armstrongNumberWVector(x):
    armstrong = []
    for i in range(len(x)):
        sum = 0
        temp = x[i]
        p = len(str(x[i]))
        while temp > 0:
            sum += (temp % 10) ** p
            temp //= 10
        if sum == x[i]:
            armstrong.append(x[i])
    return armstrong


def deleteAllNegativeNumber(x):
    for i in range(len(x)):
        if x[i] < 0:
            x.pop(i)
    return x

print(deleteAllNegativeNumber(x))

def findMediaValueInVector(_x):
    _x = sorted(_x)
    if(len(_x)%2!=0):
        return int(len(_x)/2)
    else:
        a = int(len(_x)/2)
        b = int(len(_x)/2) -1
        return (_x[a]+_x[b])/2

def findSumLessThanMedia(x):
    sum = 0
    for i in range(len(x)):
        if x[i] < findMediaValueInVector(x):
            sum += x[i]
    return sum

def creatNewVector(x):
    newVector = []
    for i in range(len(x)):
        if x[i] < 0:
            newVector.append(x[i]*-1)
    return newVector

