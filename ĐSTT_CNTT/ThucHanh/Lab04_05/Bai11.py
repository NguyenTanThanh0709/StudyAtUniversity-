import numpy as np
from sympy import *
from sympy.solvers.solveset import linsolve

x1,x2,x3,x4 = symbols('x1,x2,x3,x4')

X = linsolve([3*x1-x3,8*x1-2*x4,2*x2-2*x3-x4],(x1,x2,x3,x4))
print(X)