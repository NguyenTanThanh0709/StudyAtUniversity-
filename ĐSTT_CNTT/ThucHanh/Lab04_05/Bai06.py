import numpy as np
import math
import matplotlib .pyplot as plt

A = np.array([[1,1,1],[1,2,4],[1,3,9]])
b = np.array([6,15,38])
a = np.linalg.solve(A,b.T)
print(a)
t = np.arange(-10,10)
yt = 11-12*t +7*t**2
t_s = -9.3
y_s = yt.subs(t,t_s)

fig = plt.figure()
plt.plot(t,yt)
plt.plot(t_s,y_s,'ro')
plt.show()