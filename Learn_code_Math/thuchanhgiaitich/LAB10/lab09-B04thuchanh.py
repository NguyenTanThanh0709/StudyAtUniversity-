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
print("Câu a")
print(plotgraph(x**2*cos(x),-4,9,x))
print("Câu b")
print(plotgraph(exp(-1/2*x**2),-oo,oo,x))
