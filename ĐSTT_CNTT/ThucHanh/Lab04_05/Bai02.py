import numpy as np
import matplotlib.pyplot as plt

a1 = 6
a2 = 2
b1 = 12
b2 = 4
c1 = 100
c2 = 50

x = np.arange(-5,50)

y1 = (c1-a1*x)/b1
y2 = (c2-a2*x)/b2

fig = plt.figure()
plt.plot(x,y1,'r')
plt.plot(x,y2,'c')
plt.show()

a1 = 6
a2 = 2
b1 = -12
b2 = 4
c1 = 100
c2 = 50

x = np.arange(-5,50)

y1 = (c1-a1*x)/b1
y2 = (c2-a2*x)/b2

fig = plt.figure()
plt.plot(x,y1,'r')
plt.plot(x,y2,'c')
plt.show()

a1 = 2
a2 = 4
b1 = 10
b2 = 20
c1 = 20
c2 = 40

x = np.arange(-5,50)

y1 = (c1-a1*x)/b1
y2 = (c2-a2*x)/b2

fig = plt.figure()
plt.plot(x,y1,'r')
plt.plot(x,y2,'c')
plt.show()