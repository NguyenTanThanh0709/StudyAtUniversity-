import numpy as np

u = np.array([[2],[3]]).T
u1 = np.array([1,2,3]).T
u2 = np.array([1/2,-1/2,1/4]).T

def determine_unit(u):
    return u/np.linalg.norm(u,2)

print("determine_unit(u) = ", determine_unit(u))
print("determine_unit(u1) = ", determine_unit(u1))
print("determine_unit(u2) = ", determine_unit(u2))