import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
x=symbols("x")
y=symbols("y")
def plotgraph(f,a,b,sym):
    val=np.arange(-10,10,0.1)
    f_val=lambdify(x,f,"numpy")(val)
    plt.plot(val,f_val)
    plt.grid(linestyle = '-')
    plt.show()
    return 1/(b-a)*integrate(f,(sym,a,b))
print("Câu a")
print(plotgraph(x**2-1,0,sqrt(3),x))
print("Câu b")
print(plotgraph(-3*x**2-1,0,1,x))
print("Câu c")
print(plotgraph(-x**2,0,3,x))
print("Câu d")
print(plotgraph(x**2-x,-2,1,x))