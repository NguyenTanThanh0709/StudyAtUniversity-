import math
from sympy import *
import numpy as np

x=symbols("x")
y=symbols("y")

def result(f):
    f3=diff(f,x,2)
    f5=diff(f3,y,3)
    f3x=diff(f,x,2)
    f2y=diff(f,y,3)
    return f5/(f3x*f2y)


print("Câu a")
fa=(y**2)*(x**4)*exp(x)+2
print(result(fa))

print("Câu b")
fb=y**4+y*(sin(x)-x**4)
print(result(fb))

print("Câu c")
fc=x**5+5*x**5*y**5+sin(x)+7*exp(x)
print(result(fc))

print("Câu d")
fd=x**3*exp(y**4/2)
print(result(fd))