import math
from sympy import *
import numpy as np
x=symbols("x")
def timmaxmin(f,a,b):
    df = diff(f,x,1)
    dx = solve(df,x)
    find=[f.subs(x,a),f.subs(x,b)]
    for i in dx:
        c=f.subs(x,i)
        find.append(c)
    print("Giá trị lớn nhất là:{}".format(max(find)))
    print("Giá trị nhỏ nhất là:{}".format(min(find)))
#Câu a
timmaxmin(x**3-27*x,0,5)
#Câu b
timmaxmin(1/2*x**4-4*x**2+5,1,3)
#Câu c
timmaxmin(3/2*x**4-4*x**3+4,0,3)
#Câu d
timmaxmin(5/2*x**4-20/3*x**3+6,0,3)