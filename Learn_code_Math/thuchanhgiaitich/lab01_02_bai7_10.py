# -*- coding: utf-8 -*-
"""lab01_02_bai7_10.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1_OdUXOAF1VKc050nu0vGZy7zRdjQlGdc
"""

#ex7
import math
import matplotlib.pyplot as plt
import numpy as np
from sympy import *

t = symbols(" t ")
x = 4 *sin(t)**5 + 5
########1111
val_x = np.arange(-5,5,0.1)
val_y1 = lambdify(t,x,"numpy")(val_x)

plt.plot(val_x, val_y1, color = "pink")
plt.title("f(x) = 4 *sin(t)**5 + 5")
plt.grid()
plt.show()

######222222
y = 3* cos(t) - 1.7*cos(2*t) - 3*cos(3*t)+1
y
val_y2 = lambdify(t,y,"numpy")(val_x)

plt.plot(val_x, val_y2, color = "red")
plt.title("f(x) = 3* cos(t) - 1.7*cos(2*t) - 3*cos(3*t)+1")
plt.grid()
plt.show()

#### EXP 7
import math
import matplotlib.pyplot as plt
import numpy as np
from sympy import *

t = symbols(" t ")
x = 4 *sin(t)**5 + 5
y = 3 * cos(t) - 1.7*cos(2*t) - cos(3*t) + 1

t1 = np.arange(-3,3,0.1)
fx_val = lambdify(t,x,"numpy")(t1)
fy_val = lambdify(t,y,"numpy")(t1)

plt.plot(fx_val,fy_val,"r")
plt.grid()
plt.show()

#### EXP 10:

##### ex8
########### f(x1)
x = symbols("x")
f81 = -x + 5

val_f81 = lambdify(x,f81,"numpy")(val_x)

x2 = plt.plot(val_x, val_f81, color = "red")
plt.title("f(x) = -x + 5")
plt.grid()
plt.show()

###### f(x2)
f82 = x/2 + 2
f82

val_f82 = lambdify(x,f82,"numpy")(val_x)
x1 = plt.plot(val_x, val_f82, color = "blue")
plt.title("f(x) = x/2 + 2")
plt.grid()
plt.show()

######## HÀM TÌM ĐIỂM GIAO NHAU

plt.plot(val_f81,val_f82,"r")
plt.show()

#### EX9

import matplotlib.pyplot as plt
import numpy as np
from sympy import *

###### FX1
x = symbols("x")
f9_1 = sqrt(1 - (abs(x)-1)**2)
f9_1

val_x = np.arange(-2,2,0.1)
val_f9_1 = lambdify(x,f9_1,"numpy")(val_x)

plt.plot(val_x, val_f9_1, color = 'magenta')
plt.title("f(x1) = sqrt(1 - (abs(x)-1)**2)")
plt.grid()
plt.show()

######### FX2
f9_2 = -3 * sqrt(1-sqrt(abs(x)/2))
f9_2

val_f9_2  = lambdify(x,f9_2,"numpy")(val_x)

plt.plot(val_x, val_f9_2, color = 'red')
plt.title("f(x2) = -3 * sqrt(1-sqrt(abs(x)/2))")
plt.grid()
plt.show()

###
plt.plot(val_f9_1,val_f9_2,"b")
plt.show()

##### EX11
import matplotlib.pyplot as plt
import numpy as np
from sympy import *

x = symbols("x")
fx11_1 = x**3 - x/2
fx11_1

val_x = np.arange(-10,10,0.1)
val_y11_1 = lambdify(x,fx11_1,"numpy")(val_x)

plt.plot(val_x,val_y11_1,"r")
plt.grid()
plt.show

#### FX2

fx11_2 = x**2 + x/2

val_y11_2 = val_y11_1 = lambdify(x,fx11_2,"numpy")(val_x)

plt.plot(val_x,val_y11_2,"r")
plt.grid()
plt.show()