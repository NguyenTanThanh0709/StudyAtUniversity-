import numpy as np

def req1(A):
    max = -100
    for i in range(A.shape[1]) :
        sumCot = 0
        for j in range(A.shape[0]) :
            sumCot += A[j][i]
        if sumCot > max :
            max = sumCot
    
    chiSoCotMax = []
    for i in range(A.shape[1]) :
        tongCot = 0
        for j in range(A.shape[0]) :
            tongCot += A[j][i]
        if tongCot == max :
            chiSoCotMax.append(i)
    
    return chiSoCotMax

def req2(A):
    tong = 0
    for i in range(A.shape[0]):
        for j in range(A.shape[1]):
            if i == j:
                flag = True
                # Kiểm tra SNT
                if (A[i][j] < 2):
                    flag = False
                elif (A[i][j] == 2):
                    flag = True
                elif (A[i][j] % 2 == 0):
                    flag = False
                else:
                    # Lặp qua các số lẻ nên bắt đầu từ 3 với bước nhảy là 2
                    for i in range(3, A[i][j], 2):
                        if (A[i][j] % i == 0):
                            flag = False
                if flag == True:
                    tong += A[i][j]
    return tong


def req3(A):
    PT1 = []
    for i in range(A.shape[0]):
        for j in range(A.shape[1]):
                PT1.append(A[i][j])

    KiemTra = False
    PhanTuChan = []
    for i in range(len(PT1)):
        if PT1[i] % 2 == 0:
            PhanTuChan.append(PT1[i])
            KiemTra = True

    
    setPTle = list(set(PhanTuChan))
    
    Maxx = 0
    listPhanTuMaxChan = []
    for i in range(len(setPTle)):
        dem = PhanTuChan.count(setPTle[i])
        if dem > Maxx:
            Maxx = dem

    for i in range(len(setPTle)):
        dem = PhanTuChan.count(setPTle[i])
        if dem == Maxx:
            listPhanTuMaxChan.append(setPTle[i])  
            
   # _listPhanTuMaxChan = sorted(listPhanTuMaxChan)

    try:
        PhanTuMax = listPhanTuMaxChan[0]

        if KiemTra == True:
                for k in range(A.shape[0]):
                    for h in range(A.shape[1]):
                        if A[k][h] > 0:
                            A[k][h] = PhanTuMax
        elif KiemTra == False:
                for k in range(A.shape[0]):
                    for h in range(A.shape[1]):
                        if A[k][h] > 0:
                            A[k][h] = 1000
    except:
                for k in range(A.shape[0]):
                    for h in range(A.shape[1]):
                        if A[k][h] > 0:
                            A[k][h] = 1000

    return A

def req4(A,threshold):

    for i in range(A.shape[0]):
        for j in range(A.shape[1]):
            if A[i][j] < threshold:
                A[i][j] = 1
            else:
                A[i][j] = 0
    
    result = []
    for i in range(A.shape[0]):

        for j in range(A.shape[1]):
            sum = 0
            if A[i][j] == 1:
                #1
                try:
                    sum += A[i][j]
                except:
                    sum += 0
                #2
                try:
                    sum += A[i-1][j-1]
                except:
                    sum += 0
                #3
                try:
                    sum += A[i-1][j]
                except:
                    sum += 0

                #4
                try:
                    sum += A[i+1][j+1]
                except:
                    sum += 0
                #5
                try:
                    sum += A[i][j+1]
                except:
                    sum += 0

                #6
                try:
                    sum += A[i+1][j+1]
                except:
                    sum += 0
                #7
                try:
                    sum += A[i+1][j]
                except:
                    sum += 0
                #8
                try:
                    sum += A[i+1][j-1]
                except:
                    sum += 0
                #9
                try:
                    sum += A[i-1][j-1]
                except:
                    sum += 0
        
            result.append(sum)
        
    return max(result)