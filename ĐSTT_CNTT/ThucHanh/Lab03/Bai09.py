import numpy as np


T = np.array([[0.6,0.7],[0.4,0.3]])
p = np.array([[0.5],[0.5]])

def determine(T,p,k):
    for i in range(k):
        A = T@T
    B = np.dot(A,p)
    return B

print(determine(T,p,2))