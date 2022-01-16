import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
x=symbols("x")
def simpson(f,a,b,n):
    area=0.0
    po=[]
    for i in range(0,n+1,2):
        po.append(f.subs(x,i))
        po.append(f.subs(x,i+1))
        area+=((b-a)/3)*(po[i-1]+po[i])
    return area
print("Câu a")
print("{}".format(simpson(exp(-x**2),0,1,3)))
print("Câu b")
print("{}".format(simpson(2*x**2+5*x+12,-1,5,1)))
print("{}".format(simpson(2*x**2+5*x+12,-1,5,3)))
print("{}".format(simpson(2*x**2+5*x+12,-1,5,4)))
print("{}".format(simpson(2*x**2+5*x+12,-1,5,6)))
print("Câu c")
print("{}".format(simpson(x**3+2*x**2-5*x-2,0,2,2)))
print("{}".format(simpson(x**3+2*x**2-5*x-2,0,2,4)))
print("{}".format(simpson(x**3+2*x**2-5*x-2,0,2,6)))
print("{}".format(simpson(x**3+2*x**2-5*x-2,0,2,8)))
print("Câu d")
print("{}".format(simpson(x*exp(-x),0.2,3.8,2)))
print("{}".format(simpson(x*exp(-x),0.2,3.8,4)))
print("{}".format(simpson(x*exp(-x),0.2,3.8,6)))
print("{}".format(simpson(x*exp(-x),0.2,3.8,8)))