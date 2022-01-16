import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
x=symbols("x")
print("c(100)-c(1)={}".format(integrate(1/2*sqrt(x),(x,100,1))))
print("Tien lam poster 2-100={}".format(integrate(1/2*sqrt(x),(x,100,2))))