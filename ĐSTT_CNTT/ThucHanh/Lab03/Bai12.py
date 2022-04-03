import numpy as np

def determine(A):
    return np.linalg.det(A)

print(determine(np.array([[1,2,3],[4,5,6],[7,8,9]])))
C = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print(determine(C))