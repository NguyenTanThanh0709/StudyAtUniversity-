import scipy.io 
import numpy as np


def req1(transactions):    
    danhSachHang = []
    for i in range(transactions.shape[0]):
        data = list(list(transactions[i][1]))
        for j in range(len(data)):
            danhSachHang.append(str(data[j]).strip())

    _danhSachKhachHang = sorted(list(set(danhSachHang)))

    _max =  max(set(danhSachHang),key = danhSachHang.count)
    _min = min(set(danhSachHang),key = danhSachHang.count)

    count_max = danhSachHang.count(_max)
    count_min = danhSachHang.count(_min)

    _Max = []
    _Min = []
    if count_max == count_min:
        for i in range(len(_danhSachKhachHang)):
            _Max.append(_danhSachKhachHang[i])
            _Min.append(_danhSachKhachHang[i])
    else:
        for i in _danhSachKhachHang:
            
            _count = danhSachHang.count(i)
            if _count == count_max:
                _Max.append(i)
            elif _count == count_min:
                _Min.append(i)

    return sorted(_Max), sorted(_Min)

def req2(products):
    
    danhSachHang = []
    for i in range(products.shape[0]):
        data = (str(products[i][2]).strip())
        danhSachHang.append(int(data))

    _Max = max(danhSachHang)
    _Min = min(danhSachHang)

    MaxHangTonKho = []
    MinHangTonKho = []

    if _Max == _Min:
        for i in range(products.shape[0]):
            matHangTonKho = str(products[i][0]).strip()
            MaxHangTonKho.append(matHangTonKho)
            MinHangTonKho.append(matHangTonKho)
    else:
        for i in range(products.shape[0]):
            soLuongHangTonKho = int(products[i][2].strip())
            matHangTonKho = str(products[i][0]).strip()
            if soLuongHangTonKho == _Max:
                MaxHangTonKho.append(matHangTonKho)
            elif soLuongHangTonKho == _Min:
                MinHangTonKho.append(matHangTonKho)

    return sorted(MaxHangTonKho), sorted(MinHangTonKho)

def req3(transactions, products):
    
    total_revenue = 0
    # lấy ra những phần tử trong stansaction
    danhSachHang = []
    for i in range(transactions.shape[0]):
        data = list(list(transactions[i][1]))
        for j in range(len(data)):
            danhSachHang.append(str(data[j]).strip())

    _danhSachKhachHang = list(set(danhSachHang))

    for i in range(products.shape[0]):
        IDHang = str(products[i][0]).strip()
        soLuong = danhSachHang.count(IDHang)
        total_revenue += soLuong*int(str(products[i][1]).strip())

    return total_revenue

def req4(transactions,products):
    danhSachHang = []
    for i in range(transactions.shape[0]):
        data = list(list(transactions[i][1]))
        for j in range(len(data)):
            danhSachHang.append(str(data[j]).strip())

    danhSachDoanhThu = []

    for i in range(products.shape[0]):
        IDHang = str(products[i][0]).strip()
        soLuong = danhSachHang.count(IDHang)
        danhSachDoanhThu.append(soLuong*int(str(products[i][1]).strip())) 

    maxDoanhThu = max(danhSachDoanhThu)

    maxIDMatHang = []

    for i in range(products.shape[0]):
        IDHang = str(products[i][0]).strip()
        soLuong = danhSachHang.count(IDHang)
        tien = soLuong*int(str(products[i][1]).strip())
        if tien == maxDoanhThu:
            maxIDMatHang.append(IDHang)

    return sorted(maxIDMatHang)
 
def req5(history, k):
    
    _history1 = []
    for i in range(history.shape[0]):
        tupleDanhSach = ()
        soLuong = len(list(history[i][1]))
        IDUser = str(history[i][0][0]).strip()
        tupleDanhSach = tupleDanhSach + (IDUser, soLuong)
        _history1.append(tupleDanhSach)

    _dict = dict(_history1)
    history2 = sorted(_dict.items(), key = lambda x: x[1], reverse = True)
    _dict1 = dict(history2)

    _key = list(_dict1.keys())

    result = []
    for i in range(k):
        result.append(_key[i])

    return result

def req6(transactions, history, k):
    check = False
    listMaGiaoDich = []
    for i in range(history.shape[0]):
        if str(history[i][0][0]).strip() == k:
            check = True
            dataMaGiaoDich = list(history[i][1])
            for j in range(len(dataMaGiaoDich)):
                listMaGiaoDich.append(str(dataMaGiaoDich[j]).strip())
            break

    result1 = []
    if len(listMaGiaoDich) == 0 or check == False:
        return result1

    listSanPham = []
    for i in range(len(listMaGiaoDich)):
        maGiaoDIch = str(listMaGiaoDich[i]).strip()
        for j in range(transactions.shape[0]):
            if str(transactions[j][0][0]).strip() == maGiaoDIch:
                dataSanPham = list(transactions[j][1])
                for k in range(len(dataSanPham)):
                    listSanPham.append(str(dataSanPham[k]).strip())
                break

    result2 = []
    setSanPham = list(set(listSanPham))

    MAXSanPhamThuongMua = -1
    for i in range(len(setSanPham)):
        sanPham = setSanPham[i]
        count = listSanPham.count(sanPham)
        if count > MAXSanPhamThuongMua:
            MAXSanPhamThuongMua = count
            result1 = [sanPham]

    for i in range(len(setSanPham)):
        sanPham = setSanPham[i]
        count = listSanPham.count(sanPham)
        if count == MAXSanPhamThuongMua:
            result2.append(sanPham)

    return sorted(result2)


def req7(transactions, history):
    
    min = 1000
    for i in range(history.shape[0]):
        doDai = len(history[i][1])
        if doDai < min:
            min = doDai

    listMaGiaoDich = []
    for i in range(history.shape[0]):
        doDai = len(history[i][1])

        if doDai == min:
            _listMaGiaoDich = list(history[i][1])
            # listMaGiaoDich += _listMaGiaoDich
            for j in range(len(_listMaGiaoDich)):
                listMaGiaoDich.append(str(_listMaGiaoDich[j]).strip())

    listMaGiaoDich = list(set(listMaGiaoDich))

    demGiaoDich = len(listMaGiaoDich)

    sanPham1 = []
    if demGiaoDich == 1:
        setListGiaoDich = list(set(listMaGiaoDich))

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

                _listSanPham = list(transactions[j][1])

                for k in range(len(_listSanPham)):
                    listSanPham.append(str(_listSanPham[k]).strip())
                break

    setSanPham = list(set(listSanPham))

    result = []
    for i in range(len(setSanPham)):
        count = listSanPham.count(setSanPham[i])
        if count > 1:
            result.append(setSanPham[i])

    ketqua = sorted(result)

    return ketqua

def vector(transactions, history,k):

    ListSanPham = []
    for i in range(transactions.shape[0]):
        data = (list(transactions[i][1]))
        # ListSanPham += data
        for j in range(len(data)):
            ListSanPham.append(str(data[j]).strip())
    ListSanPham = sorted(list(set(ListSanPham)))

    listMaGiaoDichK = []
    for i in range(history.shape[0]):
        if str(history[i][0][0]).strip() == k:
            _listMaGiaoDichK = list(history[i][1])
            for j in range(len(_listMaGiaoDichK)):
                data = str(_listMaGiaoDichK[j]).strip()
                listMaGiaoDichK.append(data)

    listSanPhamm = []
    for i in range(len(listMaGiaoDichK)):
        maGiaoDich = listMaGiaoDichK[i]
        for j in range(transactions.shape[0]):
            if maGiaoDich == str(transactions[j][0][0]).strip():
                # code here
                _listSanPham = list(transactions[j][1])
                for k in range(len(_listSanPham)):
                    data = str(_listSanPham[k]).strip()
                    listSanPhamm.append(data)
                # listSanPhamm += _listSanPham
    listK = []
    for i in range(len(ListSanPham)):
        sanPham = ListSanPham[i]
        count = listSanPhamm.count(sanPham)
        if count > 0:
            listK.append(count)
        else:
            listK.append(0)

    vectorU = np.array(listK)
    return vectorU

def cosine_similarity(vectorU,vectorK):
    numerator = np.dot(vectorU,vectorK)
    denom = np.sqrt(sum(np.square(vectorU))) * np.sqrt(sum(np.square(vectorK)))
    cosine_Similarity = numerator/denom
    return cosine_Similarity

def req8(transactions, history, k):

    check = False
    resultCheck = []
    for i in range(history.shape[0]):
        if str(history[i][0][0]).strip() == k:
            check = True
            break
    if check == False:
        return resultCheck


    vectork = vector(transactions, history,k)

    Min = -1
    result = []
    for i in range(history.shape[0]):
        k1 = str(history[i][0][0]).strip()
        if k1 == k:
            continue
        vectork1 = vector(transactions, history,k1)

        
        cosine_Similarity = cosine_similarity(vectork,vectork1)
        if Min < cosine_Similarity:
            Min = cosine_Similarity
            result = [k1]

    return result

def req9(transactions, history, products):
    
    listSanPham = []
    for i in range(products.shape[0]):
        sanPham = str(products[i][0]).strip()
        listSanPham.append(sanPham)

    listGiaoDichKhachHang = []
    for i in range(history.shape[0]):
        giaoDichKhachHang = list(history[i][1])
        for j in range(len(giaoDichKhachHang)):
            maGiaoDich = str(giaoDichKhachHang[j]).strip()
            listGiaoDichKhachHang.append(maGiaoDich)

    _listGiaoDichKhachHang = sorted(list(set(listGiaoDichKhachHang)))

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

    result = []
    for i in range(len(listSanPham)):
        sanPhamCuaCuaHang = listSanPham[i]
        count = listSanPhamDaMua.count(sanPhamCuaCuaHang)
        if count == 0:
            result.append(sanPhamCuaCuaHang)

    return result

def req10(history, transactions, products, k):
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

    return result[0]