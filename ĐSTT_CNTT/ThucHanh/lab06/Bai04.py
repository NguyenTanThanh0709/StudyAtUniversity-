import numpy as np

u = np.array([[1],[1]])
v = np.array([[0],[1]])

u1 = np.array([[-2],[3]])
v1 = np.array([[0.5],[-0.5]])

def determine_angle(u, v):
    return np.arccos(np.dot(u, v) / (np.linalg.norm(u,2) * np.linalg.norm(v,2)))

print("determine_angle(u, v) = ", determine_angle(u, v))
print("determine_angle(u1, v1) = ", determine_angle(u1, v1))