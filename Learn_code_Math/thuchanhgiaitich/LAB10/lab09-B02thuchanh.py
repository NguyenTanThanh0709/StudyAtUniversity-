import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
x=symbols("x")
y=symbols("y")
def plotgraph(f,a,b,sym):
    val=np.arange(-10,10,0.1)
    f_val=lambdify(x,f,"numpy")(val)
    plt.plot(val,f_val)
    plt.grid(linestyle = '-')
    plt.show()
    return integrate(f,(sym,a,b))
def plotgraph3d(f,a,b,sym):
    falam = lambdify((x,y),f,"numpy")
    xa, ya = np.meshgrid(np.arange(-1,1,0.2), np.arange(-1,1,0.1))
    # thay xa, ya vao f
    za = falam(xa,ya)
    # ve hinh
    fig = plt.figure()
    ax = fig.add_subplot(111,projection = "3d")
    ax.plot_surface(xa, ya, za, cmap = plt.cm.ocean, alpha = 0.8)
    plt.xlabel("0x")
    plt.ylabel("0y")
    plt.title("Cau d")
    plt.show()
    return integrate(f,(sym,a,b))
print("Câu a")
print(plotgraph(x**3-3*sin(x)*cos(x),0,pi/2,x))
print("Câu b")
print(plotgraph(sqrt(1+x**2+1+(x+1)**2),0,3,x))
print("Câu c")
print(plotgraph(sin(x**2)**2,0,1,x))
print("Câu d")
print(plotgraph3d(plotgraph3d(x**2*y,0,3,x),1,2,y))