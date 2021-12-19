# -*- coding: utf-8 -*-
"""Lab07.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1zZJ4PtmTi08sEeAq8Sou2yHqs97iMmIn
"""

## Bài 1
from sympy import *
import math
import numpy as np
import matplotlib.pyplot as plt



print("bài 1")
x, y, z = symbols('x, y, z')

print("a)")
fa = x**2 + x*y**3
fa1 = fa.subs({x:0,y:0})
fa2 = fa.subs({x:-1,y:1})
fa3 = fa.subs({x:2,y:3})
fa4 = fa.subs({x:-3,y:-2})
print("f({},{}) = {}".format(0,0,fa1))
print("f({},{}) = {}".format(-1,1,fa2))
print("f({},{}) = {}".format(2,3,fa3))
print("f({},{}) = {}".format(-3,2,fa4))

fb = (x - y)/(y**2 + z**2)
fb1 = fb.subs({x:3,y:-1,z:2})
fb2 = fb.subs({x:1,y:1/2,z:1/4})
fb3 = fb.subs({x:0,y:-1/3,z:0})
fb4 = fb.subs({x:2,y:2,z:100})

print("b)")
print("f({},{},{}) = {}".format(3,-1,2,fb1))
print("f({},{},{}) = {}".format(1,1/2,1/4,fb2))
print("f({},{},{}) = {}".format(0,-1/3,0,fb3))
print("f({},{},{}) = {}".format(2,2,100,fb4))

# Bài 2
print("bài 2")
from mpl_toolkits.mplot3d import Axes3D
x,y = symbols("x y")

def vehinh(f):
  fa = lambdify((x,y),f,'numpy')
  xa,ya= np.meshgrid(np.arange(-1,1,0.1),np.arange(-1,1,0.2))

  za = fa(xa,ya)

  fig = plt.figure()

  ax = fig.add_subplot(111,projection = '3d')
  ax.plot_surface(xa,ya,za,cmap = plt.cm.ocean,alpha = 0.5)
  plt.xlabel("x0")
  plt.ylabel("y0")
  plt.title("...")
  plt.show()

fa = cos(x)*cos(y)*exp(-sqrt(x**2 + y**2)/4)
fb = -(x*y**2)/(x**2+y**2)
fc = (x*y*(x**2-y**2))/(x**2+y**2)
fd = y**2-y**4 -x**2
vehinh(fa)
vehinh(fb)
vehinh(fc)
vehinh(fd)

x,y = symbols('x y')

def daoham(f)
  dx = diff(f,x,1)
  dy = diff(f,y,1)
f = 2*x**2 -3*y -4