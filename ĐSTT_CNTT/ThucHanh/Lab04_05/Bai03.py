from matplotlib import projections
import numpy as np
import math
import matplotlib .pyplot as plt
from mpl_toolkits .mplot3d import Axes3D
###############################################################
a1 = 1
a2 = 1
a3 = 1

b1 = 2
b2 = 2
b3 = 2

c1 = 3
c2 = 3
c3 = 3

d1= 4
d2 = 4
d3 = 0



x,y = np.meshgrid(np.arange(-5,5),np.arange(-5,5))

z1 = (d1-(a1*x+b1*y))/c1
z2 = (d2-(a2*x+b2*y))/c2
z3 = (d3-(a3*x+b3*y))/c3

fig = plt.figure()
ax = fig.add_subplot(111,projection = '3d')

ax.plot_surface(x,y,z1, cmap = plt.cm.ocean,alpha = 0.7)
ax.plot_surface(x,y,z2, cmap = plt.cm.hsv,alpha = 0.7)
ax.plot_surface(x,y,z3, cmap = plt.cm.gray,alpha = 0.7)

plt.show()


##################################

a1 = 1
a2 = 1
a3 = 1

b1 = 2
b2 = 3
b3 = 2

c1 = 3
c2 = 5
c3 = 8

d1= 4
d2 = 4
d3 = 0

x,y = np.meshgrid(np.arange(-5,5),np.arange(-5,5))

z1 = (d1-(a1*x+b1*y))/c1
z2 = (d2-(a2*x+b2*y))/c2
z3 = (d3-(a3*x+b3*y))/c3

fig = plt.figure()
ax = fig.add_subplot(111,projection = '3d')

ax.plot_surface(x,y,z1, cmap = plt.cm.ocean,alpha = 0.7)
ax.plot_surface(x,y,z2, cmap = plt.cm.hsv,alpha = 0.7)
ax.plot_surface(x,y,z3, cmap = plt.cm.gray,alpha = 0.7)

plt.show()


##################################

a1 = 1
a2 = 2
a3 = 1

b1 = 2
b2 = 4
b3 = 2

c1 = 3
c2 = 6
c3 = 3

d1= 4
d2 = 8
d3 = 4


x,y = np.meshgrid(np.arange(-5,5),np.arange(-5,5))

z1 = (d1-(a1*x+b1*y))/c1
z2 = (d2-(a2*x+b2*y))/c2
z3 = (d3-(a3*x+b3*y))/c3

fig = plt.figure()
ax = fig.add_subplot(111,projection = '3d')

ax.plot_surface(x,y,z1, cmap = plt.cm.ocean,alpha = 0.7)
ax.plot_surface(x,y,z2, cmap = plt.cm.hsv,alpha = 0.7)
ax.plot_surface(x,y,z3, cmap = plt.cm.gray,alpha = 0.7)

plt.show()
