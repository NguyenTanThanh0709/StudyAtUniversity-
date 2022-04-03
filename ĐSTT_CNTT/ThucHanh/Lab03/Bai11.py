import numpy as np


A = np.array([[2,4,1],[6,7,2],[3,5,9]])

def isAMatrixSquareOrNot(A):
    return A.shape[0] == A.shape[1]
print(isAMatrixSquareOrNot(A))


def isAMatrixSymmetricOrNot(A):
    return (A.T == A).all()
print(isAMatrixSymmetricOrNot(A))


def isAMatrixSkewSymmetricOrNot(A):
    return (A.T == -A).all()
print(isAMatrixSkewSymmetricOrNot(A))

def findUpperTriangularMatrix(A):
    return np.triu(A)
print(findUpperTriangularMatrix(A))

def findLowerTriangularMatrix(A):
    return np.tril(A)
print(findLowerTriangularMatrix(A))


