# -*- coding: utf-8 -*-
"""lab01.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1c4XifvO2fA2kTRpx84pe9Zdj4T2SQMel
"""

## excercies 1
##a)
import math

def exponential_functions_a(x):
  return math.sqrt(x)
x= 4
ca = exponential_functions_a(x)
print("a) f(x) = ",ca)

## cau b
def exponentialfunctions_b(x):
  return x**(1/3)
x = 4
cb = exponential_functions_b(x)
print("b) f(x) = ",cb)

## cau c
def exponential_functions_c(x):
  return x**(2/3)
x = 4
cc = exponential_functions_c(x)
print("c) f(x) = ",cc)

## cau d
def polynomial_functions_d(x):
  return (x**3)/3 - (x**2)/2 - 2*x +1/3
x = 4
caud = polynomial_functions_d(x)
print("d) f(x) = ",caud)

## cau e
def rational_function_e(x):
  return (2*x**2-3)/(7*x+4)
x = 4
caue = rational_function_e(x)
print("e) f(x) = ",caue)

## cau f
def rational_function_f(x):
  return (5*x**2+8*x-3)/(3*x**2+2)
cauf = rational_function_f(x)
print("f) f(x) = ", cauf)

## cau g 
def trigonometric_functions_g(x):
    return math.sin(x)
x = 4
caug = trigonometric_functions_g(x)
print("g) fx = ", caug)

## cau h
def trigonometric_functions_h(x):
  return math.cos(x)
cauh = trigonometric_functions_h(x)
print("h) fx = ", cauh)

## cau i
def xponential_function_i(x):
  return 3**x
caui = xponential_function_i(x)
print("i) fx = ", caui)

## cau j
def xponential_function_j(x):
  return 10**(-x)
cauj = xponential_function_j(x)
print("j) fx = ", cauj)

## cau k
def xponential_function_k(x):
  return math.exp(x)
cauk = xponential_function_k(x)
print("k) fx = ", cauk)

## cau l
def natural_logarithm_function_l(x):
  return math.log2(x)
caul = natural_logarithm_function_l(x)
print("l) fx = ", caul)

## cau m
def natural_logarithm_function_m(x):
  return math.log10(x)
caum = natural_logarithm_function_m(x)
print("m) fx = ", caum)

## cau n
def natural_logarithm_function_n(x):
  return math.log(x)
caun = natural_logarithm_function_n(x)
print("n) fx = ", caun)

## excercies 2
## cau a
cau2a = lambda x: 2+ (x**2)/(x**2+4)
## [-2;2]
xa = 1
print("a) fx= ", cau2a(xa))

## cau b
cau2b = lambda x : math.sqrt(5*x+10)
## [0;5]
xb = 2
print("b) fx = ", cau2b(xb))

## cau c
cau2c = lambda x : 2/(x**2-16)
## [5;10]
xc = 6
print("c) fx = ",cau2c(xc))

## cau d
cau2d = lambda x : x**4 + 3*x**2-1
## [-3;3]
xd = -2
print("d) fx = ", cau2d(xd))

## cau e
def cau2e(x):
  if x >= 0:
    return x
  elif x < 0:
    return -x
xe1 = 3
print("e) x = 3,fx = ", cau2e(xe1))
xe2 = -3
print("e) x = -3,fx = ", cau2e(xe2))

## cauf
def cau2f(x):
  if x > 1:
    return 1
  if x < 0:
    return -x
  if x >= 0 and  x <= 1:
    return x**2
  
xf1 = 3
print("f) x = 3,fx = ", cau2f(xf1))
xf2 = -3
print("f) x = -3,fx = ", cau2f(xf2))
xf3 = 1/2
print("f) x = 1/2,fx = ", cau2f(xf3))