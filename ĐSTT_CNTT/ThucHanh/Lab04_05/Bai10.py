import numpy as np

A10 = np.array([[0.25,0.15,0.1],[0.4,0.15,0.2],[0.15,0.2,0.2]])
I3 = np.array([[1,0,0],[0,1,0],[0,0,1]])

Ihieu = I3 - A10
Ihieu1 = np.linalg.inv(Ihieu)
d10 = np.array([100,100,100])
d10T = np.transpose(d10)
p10 = Ihieu1.dot(d10T)
print(p10)