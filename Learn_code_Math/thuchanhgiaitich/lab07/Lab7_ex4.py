print("câu 4 : ")

from sympy import *
import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
x, y = symbols('x,y')

def vehinh4(f):
    xplot,yplot = np.meshgrid(np.arange(-3,3,0.2), np.arange(-3,3,0.1))
    flam = lambdify((x,y),f,"numpy")
    dflamx = lambdify((x,y),diff(diff(f,x),x,1),"numpy")
    dflamxy = lambdify((x,y),diff(diff(f,x),y,1),"numpy")
    dflamy = lambdify((x,y),diff(diff(f,y),y,1),"numpy")
    dflamyx = lambdify((x,y),diff(diff(f,y),x,1),"numpy")
    #thay x0,y0 vao f
    
     #thay x0,y0 vao f
    delta = 10**(-5)
    zplot = (flam(xplot,yplot))*yplot/(yplot+delta)
    zplotx = (dflamx(xplot,yplot))*yplot/(yplot+delta)
    zploty = (dflamy(xplot,yplot))*yplot/(yplot+delta)
    zplotxy = (dflamxy(xplot,yplot))*yplot/(yplot+delta)
    zplotyx = (dflamyx(xplot,yplot))*yplot/(yplot+delta)
    #ve hinh
    fig = plt.figure()
    fig = fig.add_subplot(111,projection = "3d")
    fig.plot_surface(xplot,yplot,zplot,cmap = plt.cm.ocean, alpha = 0.5)
    fig.plot_surface(xplot,yplot,zplotx,cmap = plt.cm.rainbow, alpha = 0.5)
    fig.plot_surface(xplot,yplot,zploty,cmap = plt.cm.Spectral, alpha = 0.5)
    fig.plot_surface(xplot,yplot,zplotxy,cmap = plt.cm.Spectral, alpha = 0.5)
    fig.plot_surface(xplot,yplot,zplotyx,cmap = plt.cm.Spectral, alpha = 0.5)
    plt.xlabel("Ox")
    plt.ylabel("Oy")
    plt.title(display(f))
    plt.show()
    return
vehinh4(x+y+x*y)
vehinh4(sin(x*y))
vehinh4(x**2*y+cos(y)+y*sin(x))
vehinh4(x*exp(y)+y+1)
vehinh4(log(x+y))
vehinh4(atan(y/x))
vehinh4(x**2*tan(x*y))
vehinh4(y*exp(x**2-y))
vehinh4(x*sin(x**2*y))
vehinh4((x-y)/(x**2+y))