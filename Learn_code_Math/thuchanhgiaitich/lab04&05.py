# -*- coding: utf-8 -*-
"""LAB04&05.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1pEGvMssBYTE0xj0NEEnY5kvljS3yMEMm
"""

########------------ EX4-------------############
from sympy import *
import math
import numpy as np
import matplotlib.pyplot as plt
x = symbols("x")

#### y = -2*x**2/3 + x, x= 0, denta = x-0

fx = -2*x**2/3 + x

daoham = (fx + fx.subs(x,0))/(x-0)

lim = limit(daoham,x,0)
print("dam ham f(x) = {}".format(lim))

#------------ EX5----------------#
###### câu A
print("CÂU A:")
fa = 4- x**2
fa1 = (fa - fa.subs(x,-3))/(x--3)
fa2 = (fa - fa.subs(x,0))/(x-0)
fa3 = (fa - fa.subs(x,1))/(x-1)

lima1 = limit(fa1,x,-3)
lima2 = limit(fa2,x,0)
lima3 = limit(fa3,x,1)

print("đạo hàm x = -3 là {}".format(lima1))
print("đạo hàm x = 0 là {}".format(lima2))
print("đạo hàm x = 1 là {}".format(lima3))

########### CÂU B

print("CÂU B:")
fb = (x-1)**2+1
fb1 = (fb - fb.subs(x,2))/(x-2)
fb2 = (fb - fb.subs(x,0))/(x-0)
fb3 = (fb - fb.subs(x,-1))/(x--1)

limb1 = limit(fb1,x,2)
limb2 = limit(fb2,x,0)
limb3 = limit(fb3,x,-1)

print("đạo hàm x = 2 là {}".format(limb1))
print("đạo hàm x = 0 là {}".format(limb2))
print("đạo hàm x = -1 là {}".format(limb3))

########### CÂU C

print("CÂU C:")
can3 = 3**(1/2)
fc = 1/x**2
fc1 = (fc - fc.subs(x,-1))/(x--1)
fc2 = (fc - fc.subs(x,2))/(x-2)
fc3 = (fc - fc.subs(x,can3))/(x-can3)

limc1 = limit(fc1,x,-1)
limc2 = limit(fc2,x,2)
limc3 = limit(fc3,x,can3)

print("đạo hàm x = -1 là {}".format(limc1))
print("đạo hàm x = 2 là {}".format(limc2))
print("đạo hàm x = căn 3 là {}".format(limc3))

########### CÂU D

print("CÂU D")
can2 = 2**(1/2)
fd = (1-x)/(2*x)
fd1 = (fd - fd.subs(x,-1))/(x--1)
fd2 = (fd - fd.subs(x,1))/(x-1)
fd3 = (fd - fd.subs(x,can2))/(x-can2)

limd1 = limit(fd1,x,-1)
limd2 = limit(fd2,x,1)
limd3 = limit(fd3,x,can2)

print("đạo hàm x = -1 là {}".format(limd1))
print("đạo hàm x = 1 là {}".format(limd2))
print("đạo hàm x = căn 2 là {}".format(limd3))

######### EX6 #########
z = symbols(" z ")
#######---------- câu a
print("câu a")
fa  = 1/(x+2)
faa = (fa.subs(x,z)-fa)/(z-x)
lima = limit(faa,z,x)
print("đạo hàm f(x) = {}".format(lima))

#######---------- câu b
print("câu B")
fb  = x**2 - 3*x +4
fbb = (fb.subs(x,z)-fb)/(z-x)
limb = limit(fbb,z,x)
print("đạo hàm f(x) = {}".format(limb))

#######---------- câu c
print("câu C")
fc  = x/(x-1)
fc = (fc.subs(x,z)-fc)/(z-x)
limc = limit(fc,z,x)
print("đạo hàm f(x) = {}".format(limc))

#######---------- câu d
print("câu d")
fd  = 1 + sqrt(x)
fdd = (fd.subs(x,z)-fd)/(z-x)
limd = limit(fdd,z,x)
print("đạo hàm f(x) = {}".format(limd))

#### EX7 ########
from sympy import *
import math
import numpy as np
import matplotlib.pyplot as plt

h = symbols(" h ")
x = symbols(" x ")
####### CÂU A ##############
print(" câu a")
fxa = x**3 +2*x
print("step 1")
x0a = 0
vala = np.arange(x0a-1/2,x0a + 3,0.01)
faval = lambdify(x,fxa,"numpy")(vala)

plt.plot(vala,faval,"black")
plt.title("fxa = x**3 +2*x")


print("step 2")
qha = (fxa.subs(x,h+x0a)- fxa.subs(x,x0a))/h
print("q(h) = ", qha)
print("step 3")
limqha = limit(qha,h,0)
print("lim của q(h) = {}".format(limqha))
print("step 4")
a = [0,1,2,3]
for i in a:
  qh_a = limit(qha,h,i) # hệ số góc
  ya = qh_a * (x-x0a) + fxa.subs(x,x0a) # đường tiếp tuyến
  ya_val = lambdify(x,ya,"numpy")(vala)
  plt.plot(vala,ya_val)
plt.grid()
plt.show()


####### CÂU B ##############
print(" câu B")
fxb = x + 5/x
print("step 1")
x0b = 1
valb = np.arange(x0b-1/2,x0b + 3,0.01)
fbval = lambdify(x,fxb,"numpy")(valb)

plt.plot(valb,fbval,"black")
plt.title("fxb = x + 5/x")


print("step 2")
qhb = (fxb.subs(x,h+x0b)- fxa.subs(x,x0b))/h
print("q(h) = ", qhb)
print("step 3")
limqhb = limit(qhb,h,0)
print("lim của q(h) = {}".format(limqhb))
print("step 4")
a = [x0b,1,2,3]
for i in a:
  qh_b = limit(qhb,h,i) # hệ số góc
  yb = qh_b * (x-x0b) + fxb.subs(x,x0b) # đường tiếp tuyến
  yb_val = lambdify(x,yb,"numpy")(valb)
  plt.plot(valb,yb_val)
plt.grid()
plt.show()



####### CÂU C ##############
print(" câu C")
fxc = x + sin(2*x)
print("step 1")
x0c = math.pi/2
valc = np.arange(x0c-1/2,x0c + 3,0.01)
fcval = lambdify(x,fxc,"numpy")(valc)

plt.plot(valc,fcval,"black")
plt.title("fxc = x + sin(2*x)")


print("step 2")
qhc = (fxc.subs(x,h+x0c)- fxa.subs(x,x0c))/h
print("q(h) = ", qhc)
print("step 3")
limqhc = limit(qhc,h,0)
print("lim của q(h) = {}".format(limqhc))
print("step 4")
a = [x0c,1,2,3]
for i in a:
  qh_c = limit(qhc,h,i) # hệ số góc
  yc = qh_c * (x-x0c) + fxc.subs(x,x0c) # đường tiếp tuyến
  yc_val = lambdify(x,yc,"numpy")(valc)
  plt.plot(valc,yc_val)
plt.grid()
plt.show()




####### CÂU D ##############
print(" câu D")
fxd = cos(x) + 4*sin(2*x)
print("step 1")
x0d = math.pi
vald = np.arange(x0d-1/2,x0d + 3,0.01)
fdval = lambdify(x,fxd,"numpy")(vald)

plt.plot(vald,fdval,"black")
plt.title("fxd = cos(x) + 4*sin(2*x)")


print("step 2")
qhd = (fxd.subs(x,h+x0d)- fxd.subs(x,x0d))/h ####
print("q(h) = ", qhd)
print("step 3")
limqhd = limit(qhd,h,0)
print("lim của q(h) = {}".format(limqhd))
print("step 4")
a = [x0d,1,2,3]
for i in a:
  qh_d = limit(qhd,h,i) # hệ số góc
  yd = qh_d * (x-x0d) + fxd.subs(x,x0d) # đường tiếp tuyến
  yd_val = lambdify(x,yd,"numpy")(vald)
  plt.plot(vald,yd_val)
plt.grid()
plt.show()

####### EXp 8
print("câu 8")
fx8 = x**3 -3*x +1
tieptuyen81 = diff(fx8,x).subs(x,3)*(x-3) + fx8.subs(x,3)
print("tiep tuyen x=3 là {}".format(tieptuyen81))
ttsongsong1 = 9*(x-2) + fx8.subs(x,2)
ttsongsong2 = 9*(x--2) + fx8.subs(x,-2)
y = 9*x + 2
print("tiep tuyen song song 1 la {}".format(ttsongsong1))
print("tiep tuyen song song 2 la {}".format(ttsongsong2))

tieptuyenc = diff(fx8,x).subs(x,2/3)*(x-2/3) + -1
print("tiep tuyen A(2/3;-1) c la {}".format(tieptuyenc))

val = np.arange(-10,10,0.01)
val1 = lambdify(x,tieptuyen81,"numpy")(val)
val2 = lambdify(x,ttsongsong1,"numpy")(val)
val3 = lambdify(x,ttsongsong2,"numpy")(val)
val4 = lambdify(x,y,"numpy")(val)
val5 = lambdify(x,tieptuyenc,"numpy")(val)


plt.plot(val,val1,"r")
plt.plot(val,val2,"blue")
plt.plot(val,val3,"g")
plt.plot(val,val4,"black")
plt.plot(val,val5,"y")
plt.title("full")
plt.grid()
plt.show()

# EX9 #
print("câu 9")
y9 = 4*x**2 -x**3
dfx = diff(y9,x)
print("dao  ham la",dfx)
tt1 = dfx.subs(x,2)*(x-2) + 8
tt2 = dfx.subs(x,3)*(x-3) + 9
print("tiep tuyen 1 {}".format(tt1))
print("tiep tuyen 2 {}".format(tt2))

val = np.arange(-5,5,0.01)
val1 = lambdify(x,tt1,"numpy")(val)
val2 = lambdify(x,tt2,"numpy")(val)
val3 = lambdify(x,y9,"numpy")(val)



plt.plot(val,val1,"r")
plt.plot(val,val2,"blue")
plt.plot(val,val3,"black")

plt.title("full")
plt.grid()
plt.show()

### câu 10 ###
print("cau A")
f1 = (x-1)**(1/3)
df1 = diff(f1,x).subs(x,1)
f11 = (f1 - fb.subs(x,1))/(x-1)
limtraia = limit(f11,x,1,'-')
limphaia = limit(f11,x,1,'+')
print("dao ham ",df1)
print("limtrai ",limtraia)
print("limphai ",limphaia)
if df1 == limtraia == limphaia:
  print("yes")
else :
  print("no")


print("cau b")
f21 = -(x+2)
f22 = x+2
f211 = (f21-f21.subs(x,-2))/(x--2)
f222 = (f22-f22.subs(x,-2))/(x--2)
limtraib = limit(f211,x,-2,'-')
limphaib = limit(f222,x,-2,'+')

print("limtrai ",limtraib)
print("limphai ",limphaib)

if limtraib == limphaib:
  print("yes")
else :
  print("no")

print("câu c")
f3 = x**2
d33 = (f3-f3.subs(x,0))/(x-0)
lim = limit(d33,x,0,'+')
print("lim phai = ",lim)

if 0 == lim:
  print("yes")
else:
  print("no")

