import math
from sympy import *
import numpy as np
x=symbols("x")
y=symbols("y")
def checkeq(f):
    fa=diff(f,x,1)
    fra=diff(fa,y,1) 
    fb=diff(f,y,1)
    frb=diff(fb,x,1)
    return fra==frb
def printeq(check):
    if(check):
        print("Đạo hàm của fxy = Đạo hàm của fyx")
    else:
        print("Đạo hàm của fxy khác Đạo hàm của fyx")
print("Câu a")
fa=y**2*x**4*exp(x)+2
printeq(checkeq(fa))
print("Câu b")
fb=log(2*x+3*y)
printeq(checkeq(fb))
print("Câu c")
fc=x*y**2+x**2*y**3+x**3*y**4
printeq(checkeq(fc))
print("Câu d")
fd=exp(x)+x*log(y)+y*log(x)
printeq(checkeq(fd))