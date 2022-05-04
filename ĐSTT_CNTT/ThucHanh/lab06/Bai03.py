import numpy as np

A1 = np.array([[1,-7],[-2,-3]])
A2 = np.array([[-2,8],[3,1]])
A3 = np.array([[2,-8],[3,1]])
A4 = np.array([[2,3],[1,-1]])
A5 = np.array([[1,-7,2],[-1,2,3],[-1,1,0]])


def frobenius_norm(A):
    return np.sqrt(np.sum(np.abs(A) ** 2))


print("frobenius_norm(A1) = ", frobenius_norm(A1))
print("frobenius_norm(A2) = ", frobenius_norm(A2))
print("frobenius_norm(A3) = ", frobenius_norm(A3))
print("frobenius_norm(A4) = ", frobenius_norm(A4))
print("frobenius_norm(A5) = ", frobenius_norm(A5))
