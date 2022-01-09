import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
x=symbols("x")
def timmaxmin(f,a,b):
    df = diff(f,x,1)
    try:
        dx = solve(df,x)
    except:
        dx = nsolve(df,x,1)
    max = []
    min = []
    if type(dx) == list:
        for i in dx:
            if i.is_real:
                if diff(df,x,1).subs(x,i)<0:
                    max.append((i,f.subs(x,i)))
                if diff(df,x,1).subs(x,i)>0:
                    min.append((i,f.subs(x,i)))
    else:
        if dx.is_real:
            if diff(df,x,1).subs(x,dx)<0:
                max.append((dx,f.subs(x,dx)))
            if diff(df,x,1).subs(x,dx)>0:
                min.append((dx,f.subs(x,dx)))
    val=np.arange(a,b,0.01)
    f_val=lambdify(x,f,"numpy")(val)
    plt.plot(val,f_val)
    for i in max:
        plt.plot(i[1],f.subs(x,i[1]),"ro")
    plt.grid(linestyle = '-')
    plt.show()
#Câu a
print("Câu a")
timmaxmin(x**2-2*x-5,0,2)
#Câu b
print("Câu b")
timmaxmin(3*x+x**3+5,-4,4)
#Câu c
print("Câu c")
timmaxmin(sin(x)+3*x**2,-2,2)
#Câu d
print("Câu d")
timmaxmin(exp(x**2)+3*x,-1,1)
#Câu e
print("Câu e")
timmaxmin(x**3-3*x,-3,0)
#Câu f
print("Câu f")
timmaxmin(x**3-3*x,0,3)