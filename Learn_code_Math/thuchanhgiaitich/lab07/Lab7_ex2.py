import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
x, y = symbols('x,y')
def ddd(f):
   fa = lambdify((x,y), f,"numpy")
   xa, ya = np.meshgrid(np.arange(-1,1,0.2),np.arange(-1,1,0.1))
   za = fa(xa,ya)
   fig =plt.figure()
   ax=fig.add_subplot(111,projection = "3d")
   ax.plot_surface(xa, ya, za, cmap = plt.cm.ocean, alpha = 0.8)
   plt.xlabel("@x")
   plt.ylabel('@y')
   plt.title(f)
   plt.show()
fa = cos(x)*cos(y)*exp(-(sqrt(x**2 + y**2))/4)
ddd(fa)
fb = (x*y*(x**2 - y**2))/(x**2 + y**2)
ddd(fb)
fc = (x*y**2)/(x**2 + y**2)
ddd(fc)
fd = y**2 - y**4 - x**2
ddd(fd)
