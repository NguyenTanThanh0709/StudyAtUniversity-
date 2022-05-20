import numpy as np
def area(r, c, A):
    if r >= len(A) or r < 0 or c >= len(A[0]) or c < 0 or A[r][c] == 0:
        return 0
    A[r][c] = 0
    return 1 + area(r-1,c,A) + area(r+1,c,A) + area(r,c-1,A) + area(r,c+1,A)
def maxArea(A):
    maxAr = 0
    for i in range(len(A)):
        for j in range(len(A[0])):
            if A[i,j] == 1:
                maxAr = max(maxAr,area(i,j,A))
    return maxAr


print(np.array([[1,1,1,0],[0,1,1,1],[0,1,1,0],[1,0,0,0]]))
maxArea(np.array([[1,1,1,0],[0,1,1,1],[0,1,1,0],[1,0,0,0]]))