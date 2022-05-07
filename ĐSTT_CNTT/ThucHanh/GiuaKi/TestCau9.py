
import numpy as np
import scipy.io




def req9(transactions, history, products):
    
    listSanPham = []
    for i in range(products.shape[0]):
        sanPham = str(products[i][0]).strip()
        listSanPham.append(sanPham)
    # print(listSanPham)

    listGiaoDichKhachHang = []
    for i in range(history.shape[0]):
        giaoDichKhachHang = list(history[i][1])
        for j in range(len(giaoDichKhachHang)):
            maGiaoDich = str(giaoDichKhachHang[j]).strip()
            listGiaoDichKhachHang.append(maGiaoDich)

    _listGiaoDichKhachHang = sorted(list(set(listGiaoDichKhachHang)))
    # print(_listGiaoDichKhachHang)

    listSanPhamDaMua = []
    for i in range(len(_listGiaoDichKhachHang)):
        _maGiaoDich = _listGiaoDichKhachHang[i]
        for j in range(transactions.shape[0]):
            maGiaoDich = str(transactions[j][0][0]).strip()
            if maGiaoDich == _maGiaoDich:
                listSanPhamGiaoDich = list(transactions[j][1])
                for k in range(len(listSanPhamGiaoDich)):
                    maSanPham = str(listSanPhamGiaoDich[k]).strip()
                    listSanPhamDaMua.append(maSanPham)
                break
    # print(listSanPhamDaMua)
    # print(len(listSanPhamDaMua))

    result = []
    for i in range(len(listSanPham)):
        sanPhamCuaCuaHang = listSanPham[i]
        count = listSanPhamDaMua.count(sanPhamCuaCuaHang)
        if count == 0:
            result.append(sanPhamCuaCuaHang)

    # print(result)
    return result
data = scipy.io.loadmat('Test2.mat')
transactions = data['transactions']
history = data['history']
products = data['products']

print(transactions)
print(history)
print(products)
k = 'KH5'

print(req9(transactions, history, products))