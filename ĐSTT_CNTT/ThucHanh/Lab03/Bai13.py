import numpy as np


A = np.random.randint(0,10, size =(5,5))
B = np.random.randint(0,10, size =(5,5))

def def_1(A,B):
    return np.linalg.det(A+B) == np.linalg.det(A) + np.linalg.det(B)

print(def_1(A,B))

def def_2(A,B):
    return np.linalg.det(A-B) == np.linalg.det(A) - np.linalg.det(B)

print(def_2(A,B))