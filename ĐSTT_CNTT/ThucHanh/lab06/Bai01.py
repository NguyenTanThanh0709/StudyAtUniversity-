import numpy as np

A1 = np.array([[1,-7],[-2,-3]])
A2 = np.array([[-2,8],[3,1]])
A3 = np.array([[2,-8],[3,1]])
A4 = np.array([[2,3],[1,-1]])
A5 = np.array([[1,-7,2],[-1,2,3],[-1,1,0]])

def norm_1(A):
    return np.sum(np.abs(A))

print("norm_1(A1) = ", norm_1(A1))
print("norm_1(A2) = ", norm_1(A2))
print("norm_1(A3) = ", norm_1(A3))
print("norm_1(A4) = ", norm_1(A4))
print("norm_1(A5) = ", norm_1(A5))