import numpy as np


A = np.array([[2,7,9,7],[3,1,5,6],[8,1,2,5]])


print("Cau A")
a = A[:,0::2]
a = np.array(a)
print(a)

print("cau b")
b = A[1::2,:]
print(b)


print("cau c")
print(A.T)