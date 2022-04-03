import numpy as np


A = np.array([[2,4,5/2],[-3/4,2,1/4],[1/4,1/2,2]])
B = np.array([[1,-1/2,3/4],[3/2,1/2,-2],[1/4,1,1/2]])

print("Cau A:")

print((A**-1)@(B**-1))

print((A@B)**-1)

print((B@A)**-1)

print("Cau B:")
print((A**-1).T)
print((A.T)**-1)