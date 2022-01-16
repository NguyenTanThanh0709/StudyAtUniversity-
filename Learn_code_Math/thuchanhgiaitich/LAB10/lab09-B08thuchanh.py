import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
x=symbols("x")
def plotgraph(f,a,b,n):
    val=np.arange(-3,3,0.1)
    f_val=lambdify(x,f,"numpy")(val)
    plt.plot(val,f_val)
    plt.grid(linestyle = '-')
    delta_x = (b-a)/n
    xi = [a]
    yi = [f.subs(x,a).evalf()]
    area = 0.0
    for i in range(n):
        xi.append(xi[-1] + delta_x)
        yi.append(f.subs(x,xi[-1]).evalf())
        area += yi[-1]*delta_x
    for i in range(len(xi)):
        plt.plot([xi[i],xi[i]], [0,yi[i]], "-")
    plt.show()
def ave(f,a,b):
    return 1/(b-a)*integrate(f,(x,a,b))
print("Câu a")
plotgraph(1-x,0,1,4)
plotgraph(1-x,0,1,100)
plotgraph(1-x,0,1,200)
plotgraph(1-x,0,1,1000)
print("Trung binh cua ham:{}".format(ave(1-x,0,1)))
print("Câu b")
plotgraph(cos(x),-pi,pi,4)
plotgraph(cos(x),-pi,pi,100)
plotgraph(cos(x),-pi,pi,200)
plotgraph(cos(x),-pi,pi,1000)
print("Trung binh cua ham:{}".format(ave(cos(x),-math.pi,math.pi)))
print("Câu c")
plotgraph(x**2+1,0,1,4)
plotgraph(x**2+1,0,1,100)
plotgraph(x**2+1,0,1,200)
plotgraph(x**2+1,0,1,1000)
print("Trung binh cua ham:{}".format(ave(x**2+1,0,1)))
print("Câu d")
plotgraph(abs(x),-1,1,4)
plotgraph(abs(x),-1,1,100)
plotgraph(abs(x),-1,1,200)
plotgraph(abs(x),-1,1,1000)
print("Trung binh cua ham:{}".format(ave(abs(x),-1,1)))