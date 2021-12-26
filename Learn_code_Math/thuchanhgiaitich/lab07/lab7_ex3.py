import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
x, y = symbols('x,y')
def dh(f):
   fx = diff(f,x,1)
   fy = diff(f,y,1)
   print('Đạo hàm riêng của {} theo X = {}'.format(f,fx))
   print('Đạo hàm riêng của {} theo y = {}'.format(f,fy))
   ddd(fx)
   ddd(fy)
      
def ddd(f):
   try:
      fa = lambdify((x,y), f,"numpy")
      xa, ya = np.meshgrid(np.arange(-1,1,0.2),np.arange(-1,1,0.1))
      za = fa(xa,ya)
      fig =plt.figure()
      ax=fig.add_subplot(111,projection = "3d")
      ax.plot_surface(xa, ya, za, cmap = plt.cm.ocean, alpha = 0.8)
      plt.xlabel("@x")
      plt.ylabel('@y')
      plt.title(f)
   except:
      dif(f)
   else:
      plt.show() 
def dif(fx):
   try:
      val = np.arange(-10,10)
      fx_val = lambdify(x,fx,'numpy')(val)
      plt.plot(val,fx_val,'r')
      plt.title('Đồ thị của {} theo đạo hàm riêng '.format(fx))
   except:
      print('Hàm  khong vẽ được Đồ thị')
   else:
      plt.show()
# câu a
fa = 2*x**2 -3*y - 4
ddd(fa)
dh(fa)
# câu b
fb = (x**2 - 1)*(y + 2)
ddd(fb)
dh(fb)
# câu c
fc = x**2 - x*y + y**2 
ddd(fc)
dh(fc)
# câu d
fd = 5*x*y - 7*x**2 - y**2 +3*x - 6*y + 2
ddd(fd)
dh(fd)
# câu e
fe = (x*y - 1)**2 
ddd(fe)
dh(fe)
# câu f 
ff = (2*x - 3*y)**3 
ddd(ff)
dh(ff)
# câu g
fg = sqrt(x**2 + y**2)
ddd(fg)
dh(fg)
# câu h
fi = 1/(x+y)
ddd(fi)
dh(fi)
# câu j
fj = x/(x**2 + y**2)
ddd(fj)
dh(fj)
# câu k
fk =  (x+y)/(x*y -1) # khong có đồ thị 
ddd(fk)
dh(fk)
# câu l
fl = tan(x/y)**(-1)
ddd(fl)
dh(fl)
# câu m 
fm = exp(x+y+1)
ddd(fm)
dh(fm)
# câu n
fn = exp(-2)*sin(x+y)
ddd(fn)
dh(fn)
# câu o
fo = log(x+y) # khong có do thi
ddd(fo)
dh(fo)


















