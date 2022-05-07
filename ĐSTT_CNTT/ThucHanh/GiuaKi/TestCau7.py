# transactions, history

import scipy.io
import numpy as np


def req7(transactions, history):
    
    min = 1000
    for i in range(history.shape[0]):
        doDai = len(history[i][1])
        if doDai < min:
            min = doDai

    print(min)
    listMaGiaoDich = []
    for i in range(history.shape[0]):
        doDai = len(history[i][1])
        print(doDai,history[i][0][0],0)
        if doDai == min:
            _listMaGiaoDich = list(history[i][1])
            # listMaGiaoDich += _listMaGiaoDich
            for j in range(len(_listMaGiaoDich)):
                listMaGiaoDich.append(str(_listMaGiaoDich[j]).strip())

    listMaGiaoDich = list(set(listMaGiaoDich))
    print(listMaGiaoDich,0)
    demGiaoDich = len(listMaGiaoDich)
    print(demGiaoDich)

    sanPham1 = []
    if demGiaoDich == 1:
        setListGiaoDich = list(set(listMaGiaoDich))
        print(setListGiaoDich)
        for i in range(transactions.shape[0]):
            if str(transactions[i][0][0]).strip() == setListGiaoDich[0]:
                sanPham1 = list(transactions[i][1])
        
        sanPham2 = []
        for j in range(len(sanPham1)):
            data = str(sanPham1[j]).strip()
            sanPham2.append(data)

        return sanPham2

    listSanPham = []
    for i in range(len(listMaGiaoDich)):
        maGiaoDich = listMaGiaoDich[i]
        for j in range(transactions.shape[0]):
            if maGiaoDich == transactions[j][0]:
                # code here
                _listSanPham = list(transactions[j][1])
                # listSanPham += _listSanPham
                for k in range(len(_listSanPham)):
                    listSanPham.append(str(_listSanPham[k]).strip())
                break

    setSanPham = list(set(listSanPham))
    print(listSanPham)
    print(setSanPham)
    result = []
    for i in range(len(setSanPham)):
        count = listSanPham.count(setSanPham[i])
        if count > 1:
            result.append(setSanPham[i])

    ketqua = sorted(result)
    # print(ketqua)
    return ketqua


data = scipy.io.loadmat('Test2.mat')
transactions = data['transactions']
history = data['history']
products = data['products']

print(transactions)
print("----")
print(history)
k = 'KH1'

print(req7(transactions, history))

