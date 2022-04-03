import numpy as np
from sympy import Matrix

A = np.array([[1,2,1],[2,2,2],[2,4,1]])
B = np.array([1,1,2])

x1 = np.linalg.solve(A,B.T)
print(x1)

x2 = np.linalg.inv(A)@B
print(x2)

x3 = Matrix([[1,2,1,1],[2,2,2,1],[2,4,1,2]])
Mr, pivot = x3.rref()
print(Mr)