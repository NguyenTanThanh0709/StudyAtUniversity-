import numpy as np

A7 = np.array([[3,3.2],[3.5,3.6]])
A72 = np.array([118.4,135.2])
A72T = np.transpose(A72)

x7 = np.linalg.solve(A7,A72T)
print(x7)