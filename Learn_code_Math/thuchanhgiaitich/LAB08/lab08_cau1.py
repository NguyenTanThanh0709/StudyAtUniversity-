import math
from sympy import *
import numpy as np

x=symbols("x")

def timcuctri(f):
    fd=diff(f,x,1)
    rx=solve(fd,x)
    print("Các điểm cực trị là {}".format(rx))

print("Câu a")
timcuctri(18*x**2-9)
print("Câu b")
timcuctri((x+2)/2*x**2)
print("Câu c")
timcuctri((-x**3/3)+(x**2)+3*x+4)
print("Câu d")
timcuctri((5*x**2+5)/x)

