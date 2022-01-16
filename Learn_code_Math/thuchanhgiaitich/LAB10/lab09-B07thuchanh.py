import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
t=symbols("t")
fa=sqrt(t+1)+5*(t**1/3)
print("Chieu cao cua cay khi t=0:{}".format(fa.subs(t,0)))
print("Chieu cao cua cay khi t=4:{}".format(fa.subs(t,4)))
print("Chieu cao cua cay khi t=8:{}".format(fa.subs(t,8)))
print("Chieu cao trung binh cua cay la:{}".format(1/(8-0)*integrate(fa,(t,0,8))))