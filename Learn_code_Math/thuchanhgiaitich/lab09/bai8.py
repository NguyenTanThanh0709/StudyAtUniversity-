import math
from sympy import *
import numpy as np
import matplotlib.pyplot as plt
x=symbols("x")
def goldensearch(f,a,b,e):
    d=b-a
    while True:
        if b-a<e:
            break
        d=0.618*d
        x1=b-d
        x2=a+d
        if f.subs(x,x1)<=f.subs(x,x2):
            b=x2
        else:
            a=x1
        min=a
    val=np.arange(-10,10,0.1)
    f_val=lambdify(x,f,"numpy")(val)
    plt.plot(val,f_val)
    plt.plot(min,f.subs(x,min),"ro")
    plt.grid(linestyle = '-')
    plt.show()
def fibosearch(f,a,b,e):
    fibo=[2,3]
    n=2
    while True:
        if b-a<e:
            break
        d=b-a
        x1=b-d*(fibo[n-2]/fibo[n-1])
        x2=a+d*(fibo[n-2]/fibo[n-1])
        if f.subs(x,x1)<=f.subs(x,x2):
            b=x2
        else:
            a=x1
        min=a
        fibo.append(fibo[n-2]+fibo[n-1])
        n=n+1
    val=np.arange(-10,10,0.1)
    f_val=lambdify(x,f,"numpy")(val)
    plt.plot(val,f_val)
    plt.plot(min,f.subs(x,min),"ro")
    plt.grid(linestyle = '-')
    plt.show()
print("Câu a")
goldensearch(-2*x**2+x+4,-5,5,1/9)
fibosearch(-2*x**2+x+4,-5,5,1/9)
print("Câu b")
goldensearch(-4*x**2+2*x+2,-6,6,1/10)
fibosearch(-4*x**2+2*x+2,-6,6,1/10)
print("Câu c")
goldensearch(x**3+6*x**2+5*x-12,-5,2,1/10)
fibosearch(x**3+6*x**2+5*x-12,-5,2,1/10)
print("Câu d")
goldensearch(2*x-x**2,0,3,1/100)
fibosearch(2*x-x**2,0,3,1/100)
print("Câu e")
goldensearch(x**2-x-10,-10,10,1/5)
fibosearch(x**2-x-10,-10,10,1/5)