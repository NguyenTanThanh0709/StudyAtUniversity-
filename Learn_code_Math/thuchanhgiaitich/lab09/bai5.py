import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
x=symbols("x")
def goldensearch(f,a,b,e):
    d=b-a
    while True:
        if b-a<e:
            break
        d=0.618*d
        x1=b-d
        x2=a+d
        if f.subs(x,x1)<=f.subs(x,x2):
            b=x2
        else:
            a=x1
        min=a
        val=np.arange(-10,10,0.1)
        f_val=lambdify(x,f,"numpy")(val)
        plt.plot(val,f_val)
        plt.plot(min,f.subs(x,min),"ro")
    plt.grid(linestyle = '-')
    plt.show()
goldensearch(x**2,-2,1,0.3)

