import numpy as np

Y = np.array([[1,2,16,31,22],[2,8,12,21,23],[4,9,11,14,25],[3,6,10,16,34]])

print("Câu A")
A = Y[1,1:4]
print(A)


print("Câu B")

C = Y[:,2]
print(C)


print("Câu C")


C = Y[1:3,1:4]
print(C)


print("Câu D")
D = Y[:,0::2]
print(D)

print("CAU E")
E = Y[0:4,0:5]
E = E[1:4,0:5]
print(E)

print("Câu F")

import random
a = 5
b = 5
R = np.random.randint(12,100, size =(a ,b))
print(R)