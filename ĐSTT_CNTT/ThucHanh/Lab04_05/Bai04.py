import numpy as np

A = np.array([[1,1,2],[3,6,-5],[2,4,-3]])
b = np.array([1,-1,0])

#Find the determinant of A. Is A invertible?
detA = np.linalg.det(A)
print("The determinant of A is: " + str(detA))

#Use the inverse matrix to find the solution for this linear system.
invA = np.linalg.inv(A)
x = invA @ b
print("The solution to the linear system is: " + str(x))

#Use Gaussian elimination method to find the solution of this linear system.
A_aug = np.concatenate((A,b.reshape(3,1)),axis=1)
print("The augmented matrix is: " + str(A_aug))

#Use LU method to find the solution of this linear system.
L,U = np.linalg.lu(A)
print("The lower matrix is: " + str(L))
print("The upper matrix is: " + str(U))
