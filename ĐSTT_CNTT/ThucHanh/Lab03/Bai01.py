import numpy as np

x = np.arange(1,6)
y = np.arange(1,7)
c= np.arange(1,31)
d= np.arange(1,26)

print("A")
A = np.repeat(x,5,axis=0)
A = A.reshape(5,5)
print(A)
print()

print("B")
B = np.repeat(y,6,axis=0)
B = B.reshape(6,6)
B = B.T
print(B)
print()

print("C")
C = c.reshape(6,5)
print(C.T)

print("D")
D = d.reshape(5,5)
print(D)


