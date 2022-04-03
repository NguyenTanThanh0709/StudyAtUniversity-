from re import T
import numpy as np


t = 3
t1 = 0.077*t
t2 = -0.056*t

A = np.array([[2,-4,4],[0,-2,2],[2,-2,0]])
B = np.array([3.86-t1,-3.47-t2,0])

x = np.linalg.solve(A,B.T)
print(x)