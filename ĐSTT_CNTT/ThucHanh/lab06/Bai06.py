
import numpy as np
v1 = [1, 2,3].T
u1 = [4, 5,6].T
u2 = [6, 2,5].T
def numpy_euclidian_distance(point_1, point_2):
    array_1, array_2 = np.array(point_1), np.array(point_2)
    squared_distance = np.sum(np.square(array_1 - array_2))
    distance = np.sqrt(squared_distance)
    return distance
print(numpy_euclidian_distance(v1, u1))
print(numpy_euclidian_distance(v1, u2))
