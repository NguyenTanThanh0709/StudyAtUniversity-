import math
from sympy import *
import numpy as np
x=symbols("x")


def timcuctri(f):
    df = diff(f,x,1)
    dx = solve(df,x)
    max = []
    min = []
    for i in dx:
        if diff(df,x,1).subs(x,i)<0:
            max.append((i,f.subs(x,i)))
        if diff(df,x,1).subs(x,i)>0:
            min.append((i,f.subs(x,i)))
    print("Tọa độ các điểm cực đại là:{}".format(max))
    print("Tọa độ các điểm cực tiểu là:{}".format(min))
    
print("Câu a")
timcuctri(18*x**2-9)
print("Câu b")
timcuctri((x+2)/(2*x**2))
print("Câu c")
timcuctri(-x**3/3+x**2+3*x+4)
print("Câu d")
timcuctri((5*x**2+5)/x)