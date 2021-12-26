from sympy import *
x = Symbol('x')
y = Symbol('y')
z = Symbol('z')
# câu a
def val(a,b):
   fxy = x**2 + x*y**3 
   f = fxy.subs({x:a,y:b})
   return print('Giá trị của f({},{}) = {}'.format(a,b,f))
val(0,0)
val(-1,1)
val(2,3)
val(-3,-2)
# câu b
def valb(a,b,c):
   fxyz = (x-y)/(y**2 + z**2)
   f = fxyz.subs({x:a,y:b,z:c})
   return print('Giá trị của f({},{},{}) = {}'.format(a,b,c,f))
valb(3,-1,2)
valb(1,1/2,1/4)
valb(0,-1/3,0)
valb(2,2,100)