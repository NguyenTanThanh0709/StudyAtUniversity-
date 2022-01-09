import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
x=symbols("x")
m=symbols("m")
def findmax(f,xo):
    fo=diff(f,x,1).subs(x,xo)
    dm=solve(fo,m)
    max=[]
    for i in dm:
        df=f.subs(m,i)
        if diff(df,x,1).subs(x,i)<0:
            max.append(i)
    return max
print(findmax(x**3-3*m*x**2+3*(m**2-1)*x-m**2-1,1))
