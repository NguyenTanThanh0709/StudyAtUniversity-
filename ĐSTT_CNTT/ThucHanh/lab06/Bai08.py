import numpy as np
from sympy import *
A8 = np.array([[3,4,5],[1,3,1],[1,1,2]])
lchar = list(map(chr, range(97 - 32, 123 - 32)))
lchar.append(" ")
print(lchar)
s1 = "ATTACK"
s2 = "LINEAR ALGEBRA LABORATORY"
#A_1*E = D => E = AD
#D_T = D.T

#D_T = F => D = F.T => E = 
E = []
for i in s1:
  for j in range(0,len(lchar)):
    if i == lchar[j]:
      E.append(j+4)
print(E)
E = np.array(E)
E_1 = E.reshape(len(A8),int(len(E)/len(A8)))
print(A8.dot(E_1))


# A8_inv = np.linalg.inv(A8)
# D = A8_inv.dot(A8.dot(E_1))
# D_T = D.T
# print("D = ",D)
# print("D_T = ",D_T)
# lchar = list(map(chr, range(97 - 32, 123 - 32)))
# lchar.append(" ")
# print("lchar = ",lchar)
# s = ""
# for i in range(0,3):
#     for j in range(0,2):
#         k = int(round(D[i,j],0))
#         s = s + lchar[k - 4]
# print("Tin nhắn đã mã hóa:",s)