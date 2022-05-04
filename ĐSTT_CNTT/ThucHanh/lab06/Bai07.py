import numpy as np
from sympy import *
A7 = np.array([[1,2,3],[2,1,2],[3,2,4]])
E7 = np.array([[80,98,99,85,106,94],[71,92,76,95,100,92],[124,163,140,160,176,161]])
A_inv = np.linalg.inv(A7)
D = A_inv.dot(E7)
print(D)
D_T = D.T
print("D = ",D)
print("D_T = ",D_T)
lchar = list(map(chr, range(97 - 32, 123 - 32)))
lchar.append(" ")
print("lchar = ",lchar)
s = ""
for i in range(0,6):
    for j in range(0,3):
        k = int(round(D_T[i,j],0))
        s = s + lchar[k - 4]
print("Tin nhắn đã mã hóa:",s)