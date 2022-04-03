import numpy as np

A = np.array([[1,2,1],[2,-1,1],[2,1,0]])
B  = np.array([0,0,0])

x = np.linalg.solve(A,B.T)
print(x)

C = np.array([[2,1,1,1],[1,2,1,1],[1,1,2,2],[1,1,1,2]])
D = np.array([1,1,1,1])

y = np.linalg.solve(C,D.T)

print(y)