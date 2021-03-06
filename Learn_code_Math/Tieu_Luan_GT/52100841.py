from sympy import * ## KHONG XOA
import numpy as np ## KHONG XOA 

global x, y, z, t ## KHONG XOA
x, y, z, t = symbols("x, y, z, t") ## KHONG XOA  

def req1(f, g, a):  ## KHONG XOA
    
    cau1 = f + g
    cau2 = f*g
    cau3 = f.subs(x,g)
    cau4 = f/g

    dcau1 = diff(cau1,x).subs(x,a)
    dcau2 = diff(cau2,x).subs(x,a)
    dcau3 = diff(cau3,x).subs(x,a)
    dcau4 = diff(cau4,x).subs(x,a)

    resultcau1 = round(dcau1,2)
    resultcau2 = round(dcau2,2)
    resultcau3 = round(dcau3,2)
    resultcau4 = round(dcau4,2)

    if(resultcau1 == zoo or resultcau1 == nan):
        resultcau1 = None
    
    if(resultcau2 == zoo or resultcau2 == nan):
        resultcau2 = None
    
    if(resultcau3 == zoo or resultcau3 == nan):
        resultcau3 = None


    if(resultcau4 == zoo  or resultcau4 == nan or g == 0):
        resultcau4 = None

    
    
    ketqua = (resultcau1, resultcau2,resultcau3, resultcau4)

    return ketqua

#bai1 = req1(1/tan(x),cos(x),0)
#print(bai1)

def req2(f, a, b, c):  ## KHONG XOA
    f0 = f.subs([(x,a),(y,b),(z,c)])
    dfx = diff(f,x)
    dfy = diff(f,y)
    dfz = diff(f,z)

    result = dfx.subs([(x,a),(y,b),(z,c)])*(x-a) + dfy.subs([(x,a),(y,b),(z,c)])*(y-b) + dfz.subs([(x,a),(y,b),(z,c)])*(z-c) + f0
    
    if(f0 == zoo or dfx == zoo or dfy == zoo or dfz == zoo or f0 == nan or dfx == nan or dfy == nan or dfz == nan ):
        result = None
    
    return result

#bai2 = req2(x**2 + y*z - 2*z**2, 1, 0, 1)
#print(bai2)

#print (req2(x**2 + y**2 - 2*z**2 + z*log(z), 1, 1, 1))
#print (req2(x**2 + y*z - 2*z**2, 1, 0, 1))
#print (req2( 1/y, 0,0,0))
#print (req2(1/tan(cos(x)),0,0,0))

def req3(w, f1, f2, f3, a):  ## KHONG XOA
    fw = w.subs([(x,f1),(y,f2),(z,f3)])
    dfw = diff(fw,t)
    result = dfw.subs(t,a)

    if(result == zoo or result == nan or fw == zoo or fw == nan or dfw == zoo or dfw == nan):
        result = None

    return result

#bai3 = req3(x*y + z, cos(t), sin(t), t, 0)
#print(bai3)

def req4(a, b, n):  ## KHONG XOA
    result = 0
    for i in range(n+1):
        temp = (factorial(n))/(factorial(i)*factorial(n-i)) * pow(a,n-i) * pow(b,i) 
        result = result + temp
    return result

#bai4 = req4(-x,1,2)
#print(bai4)

def req5(f):  ## KHONG XOA
    
    dfx = diff(f,x)
    dfy = diff(f,y)

    diem = solve([dfx,dfy],[x,y], dict = True)
    
    dodai = len(diem)

    dfxx = diff(dfx,x)
    dfyy = diff(dfy,y)
    dfxy = diff(dfx,y)

    cucdai = []
    cuctieu = []
    diemYenNgua = []

    
    

    for i in range(dodai):
        temp_min = ()
        temp_saddle = ()
        temp_max = ()


        x1 = diem[i][x]
        y1 = diem[i][y]

        xx1 = round(x1)
        yy1 = round(y1)

        

        H1 = dfxx.subs([(x,x1),(y,y1)])*dfyy.subs([(x,x1),(y,y1)]) - (dfxy.subs([(x,x1),(y,y1)]))**2
        A = dfxx.subs([(x,x1),(y,y1)])

        if H1 < 0:
                temp_saddle = (x1,y1)
                diemYenNgua.append(temp_saddle)
        else :
          try:
              if A > 0:
                  temp_min = (x1,y1)
                  cuctieu.append(temp_min)
              else:
                      temp_max = (x1,y1)
                      cucdai.append(temp_max)
          except :
             continue
    
    ketqua = (cuctieu, cucdai, diemYenNgua)

    return ketqua
#print (req5(-x**3 + y**2 + 3*x - 4*y + 1))
#print (req5(x**3 - y**2 - 3*x + 4*y - 1))
#print (req5(x**2 - y**3 - 4*x + 3*y -1))
#print (req5(-x**2 + y**3 - 4*x - 3*y + 2))
#print (req5(-x**3 + y**3 + 9*x - 12*y + 4))
#print (req5(x**3 + y**3 +3*x**2 - 9*x - 12*y + 4))
#print (req5(-x**3 + y**3 + 6*x**2 - 9*x - 12*y + 4))
#print (req5(x**3 -y**-6*x**2 + 9*x + 12*y - 4))
#print (req5(-x**3 - y**3 + 3*x*y + 4))
#print (req5(-x**3 - y**3 + 6*x*y + 4))
#print (req5(x**3 + y**3 -6*x*y + 4))
#print (req5(-x**3 -y**3 - 9*x*y + 5))

def req6(message, x, y, z):  ## KHONG XOA
    fx = abs(x**2-y**2-z)
    thongdiep = ""
    dodai = len(message)
    for i in range(dodai):
        he10 = ord(message[i])
        temp = he10 ^ fx
        dohoa = chr(temp)
        thongdiep += dohoa
    return thongdiep

#bai6 = req6("jgnnm",1,1,2)
#print(bai6)

def req7(xp, yp, xs):  ## KHONG XOA
    n =len(xp)
    XK = 0
    YK = 0
    XY = 0
    XKBINH = 0

    for i in range(n):
        XKBINH += xp[i]**2

    for i in range(n):
        XK += xp[i]
    for i in range(n):
        YK += yp[i]
    for i in range(n):
        XY += xp[i]*yp[i]

    m = (XK*YK-n*XY)/(XK**2-n*XKBINH)
    b = 1/n * (YK-m*XK)

    Y = m*xs + b
    YY = round(Y,2)
    return YY

#bai7 = req7([-2,1,4],[0,2,5],3)
#print(bai7)
    
def req8(f, eta, xi, tol): ## KHONG XOA
    df = diff(f,x)  
    
    xt = 0
    for i in range(250):
        xt -= df.subs(x,xt) * eta
        if df.subs(x,xt) < tol:
            break
    
    ketqua = round(xt,2)
    

    if(df == zoo or df == nan or xt == nan or xt == zoo or ketqua == zoo or ketqua == nan):
        ketqua = None

    return ketqua

#bai8 = req8(x**2 + 2*x - 1, 0.1, -5, 1e-3)
#print(bai8)







