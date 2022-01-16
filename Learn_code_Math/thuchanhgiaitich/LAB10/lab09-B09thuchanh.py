import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
x=symbols("x")
def Trapezoidal(f,a,b,n):
    area=0.0
    for i in range(n):
        area+=(b-a)*(f.subs(x,i)/2)
    return area
print("Câu a")
print("{}".format(Trapezoidal(exp(-x**2),0,1,3)))
print("Câu b")
print("{}".format(Trapezoidal(2*x**2+5*x+12,-1,5,1)))
print("{}".format(Trapezoidal(2*x**2+5*x+12,-1,5,3)))
print("{}".format(Trapezoidal(2*x**2+5*x+12,-1,5,4)))
print("{}".format(Trapezoidal(2*x**2+5*x+12,-1,5,6)))
print("Câu c")
print("{}".format(Trapezoidal(x**3+2*x**2-5*x-2,0,2,2)))
print("{}".format(Trapezoidal(x**3+2*x**2-5*x-2,0,2,4)))
print("{}".format(Trapezoidal(x**3+2*x**2-5*x-2,0,2,6)))
print("{}".format(Trapezoidal(x**3+2*x**2-5*x-2,0,2,8)))
print("Câu d")
print("{}".format(Trapezoidal(x*exp(-x),0.2,3.8,2)))
print("{}".format(Trapezoidal(x*exp(-x),0.2,3.8,4)))
print("{}".format(Trapezoidal(x*exp(-x),0.2,3.8,6)))
print("{}".format(Trapezoidal(x*exp(-x),0.2,3.8,8)))
