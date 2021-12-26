import math
from sympy import *
import numpy as np
x=symbols("x") 
y=symbols("y")
z=symbols("z")
t=symbols("t")
def chain(w, f1, f2, f3, a):  
    w = w.subs({x:f1,y:f2,z:f3})
    dw = diff(w,t)
    return dw.subs(t,a)
print("Câu a")
print(chain(x**2+y**2,cos(t),sin(t),0,math.pi))
print("Câu b")
print(chain(x**2+y**2,cos(t)+sin(t),cos(t)-sin(t),0,0))
print("Câu c")
print(chain(x/z+y/z,cos(t)**2,sin(t)**2,1/t,3))
print("Câu d")
print(chain(2*y*exp(x)-log(z),log(t**2+1),atan(t),exp(t),1))
print("Câu e")
print(chain(z-sin(x*y),t,log(t),exp(t-1),1))    