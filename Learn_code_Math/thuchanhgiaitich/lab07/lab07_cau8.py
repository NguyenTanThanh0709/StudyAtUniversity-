import math
from sympy import *
import numpy as np
x=symbols("x")
y=symbols("y")



def cau8(f,x0,y0):
    dfx = (f.subs(y,y0) - f.subs({x:x0,y:y0}))/(x - x0)
    dfxdn = limit(dfx,x,x0)
    dfy = (f.subs(x,x0) - f.subs({x:x0,y:y0}))/(y - y0)
    dfydn = limit(dfy,y,y0)

    return dfxdn,dfydn

print("câu A ")
print(cau8(1-x+y-3*x**2*y,1,2))

print("câu B ")
print(cau8(4+2*x-3*y,-2,1))