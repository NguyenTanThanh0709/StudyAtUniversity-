import numpy as np

A1 = np.array([[1,-7],[-2,-3]])
A2 = np.array([[-2,8],[3,1]])
A3 = np.array([[2,-8],[3,1]])
A4 = np.array([[2,3],[1,-1]])
A5 = np.array([[1,-7,2],[-1,2,3],[-1,1,0]])

def infinity_norm(A):
    return np.max(np.abs(A))

print("infinity_norm(A1) = ", infinity_norm(A1))
print("infinity_norm(A2) = ", infinity_norm(A2))
print("infinity_norm(A3) = ", infinity_norm(A3))
print("infinity_norm(A4) = ", infinity_norm(A4))
print("infinity_norm(A5) = ", infinity_norm(A5))
