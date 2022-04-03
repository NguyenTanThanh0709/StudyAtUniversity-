import numpy as np


a = np.array([[12,5,8],[15,9,12],[10,14,10],[16,7,9],[12,10,15]])
print(a)
b = np.array([2,1,3])
print(b)
c = a@b.T
print(c)