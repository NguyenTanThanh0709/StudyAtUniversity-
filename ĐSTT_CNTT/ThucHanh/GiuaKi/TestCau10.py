import numpy as np
import scipy.io
mat = scipy.io.loadmat('data.mat')

def req10(transactions,history,products,k):
    listMaGiaoDich = []
    check = False
    for i in range(history.shape[0]):
        user1 = list(history[i][0])
        user2 = str(user1[0]).strip()
        if user2 == k:
            check = True
            data = list(history[i][1])
            for j in range(len(data)):
                data1 = str(data[j]).strip()
                listMaGiaoDich.append(data1)

    # print(listMaGiaoDich)
    if len(listMaGiaoDich) == 0:
        return None
    if check == False:
        return None

    listSanPham = []
    for i in range(len(listMaGiaoDich)):
        maGiaoDich = listMaGiaoDich[i]
        for j in range(transactions.shape[0]):
            _maGiaoDich = str(transactions[j][0][0]).strip()
            if maGiaoDich == _maGiaoDich:
                sanPham = list(transactions[j][1])
                for k in range(len(sanPham)):
                    sanPham1 = str(sanPham[k]).strip()
                    listSanPham.append(sanPham1)
    # print(listSanPham)

    listKhachHang1 = []
    listKhachHang2 = []
    listKhachHang3 = []

    for i in range(len(listSanPham)):
        _sanPham = listSanPham[i]
        for j in range(products.shape[0]):
            sanPham = str(products[j][0]).strip()
            if _sanPham == sanPham:
                hangKhachHang = str(products[j][3]).strip()
                if hangKhachHang == '1':
                    listKhachHang1.append(_sanPham)
                elif hangKhachHang == '2':
                    listKhachHang2.append(_sanPham)
                elif hangKhachHang == '3':
                    listKhachHang3.append(_sanPham)
    print('1->',listKhachHang1)
    print('2->',listKhachHang2)
    print('3->',listKhachHang3)

    result = []
    if len(listKhachHang1) != 0 or len(listKhachHang2) != 0 or len(listKhachHang3) != 0:
        maxx = max(len(listKhachHang1),len(listKhachHang2),len(listKhachHang3))
        if maxx == len(listKhachHang1):
            result.append(1)
        elif maxx == len(listKhachHang2):
            result.append(2)
        elif maxx == len(listKhachHang3):
            result.append(3)
    else:
        result.append(0)


    # print(result)
    return result[0]


print(mat['transactions'])
print('-------------------------------------------------------------------------\n-------------------------------------------------------------------------')
print(mat['products'])
print('-------------------------------------------------------------------------\n-------------------------------------------------------------------------')
print(mat['history'])
print('-------------------------------------------------------------------------\n-------------------------------------------------------------------------')

data = scipy.io.loadmat('Test2.mat')
transactions = data['transactions']
history = data['history']
products = data['products']

print(transactions)
print(history)
print(products)
k = 'KH40'

print(req10(transactions,history,products,k))