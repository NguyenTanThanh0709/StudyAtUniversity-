import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
x=symbols("x")
def fibosearch(f,a,b,e):
    fibo=[2,3]
    n=2
    while True:
        if b-a<e:
            break
        d=b-a
        x1=b-d*(fibo[n-2]/fibo[n-1])
        x2=a+d*(fibo[n-2]/fibo[n-1])
        if f.subs(x,x1)<=f.subs(x,x2):
            b=x2
        else:
            a=x1
        min=a
        val=np.arange(-10,10,0.1)
        f_val=lambdify(x,f,"numpy")(val)
        plt.plot(val,f_val)
        plt.plot(min,f.subs(x,min),"ro")
        fibo.append(fibo[n-2]+fibo[n-1])
        n=n+1
    plt.grid(linestyle = '-')
    plt.show()
fibosearch(x**2,-2,1,0.3)