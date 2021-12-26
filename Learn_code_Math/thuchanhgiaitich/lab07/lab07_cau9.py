import math
from sympy import *
import numpy as np
x,y,z=symbols("x,y,z")
def rueslt(f, a, b):  ## KHONG XOA
    fv=f.subs({x:a,y:b})
    fr=fv+diff(f,x,1).subs({x:a,y:b})*(x-a)+diff(f,y,1).subs({x:a,y:b})*(y-b)
    return fr
print(rueslt(2*x+3*y+4,2,-1))