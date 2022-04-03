from asyncio.windows_events import NULL
import numpy as np

A = np.array([[-1,4,8],[-9,1,2]])
B = np.array([[5,8],[0,-6],[5,6]])
C = np.array([[-4,1],[6,5]])
D = np.array([[-6,3,1],[8,9,-2],[6,-1,5]])

print("Cau A:")
def CauA(A,B):
    try:
        return np.dot(A,B.T)
    except:
        NULL
print(CauA(A,B))

print("Cau B:")
print(np.dot(B,C.T))

print("Cau C:")
print(C-C.T)

print("Cau D:")
print(D-D.T)

print("Cau E")
print((D.T).T)

print("Cau F")
print(2*C.T)

print("Cau G")
print(A.T+B)

print("Cau H")
print((A.T+B).T)

print("caum I")
print((2*A.T-5*B).T)

print("caum J")
print((-1*D).T)

print("caum K")
print(-1*(D).T)

print("caum L")
print((C@C).T)

print("caum M")
print((C.T)@(C.T))