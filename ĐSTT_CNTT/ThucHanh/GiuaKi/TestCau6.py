import scipy.io


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
    print(listMaGiaoDich)

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
    print(listSanPham)
    print(setSanPham)

    MAXSanPhamThuongMua = -1
    for i in range(len(setSanPham)):
        sanPham = setSanPham[i]
        count = listSanPham.count(sanPham)
        if count > MAXSanPhamThuongMua:
            MAXSanPhamThuongMua = count
            result1 = [sanPham]
    print(MAXSanPhamThuongMua)
    print(result1)

    for i in range(len(setSanPham)):
        sanPham = setSanPham[i]
        count = listSanPham.count(sanPham)
        if count == MAXSanPhamThuongMua:
            result2.append(sanPham)
    
    # check = False
    # for i in range(len(setSanPham)):
    #     count = listSanPham.count(setSanPham[i])
    #     if count >1:
    #         result1.append(setSanPham[i])
    #         check = True
    # print(result1)
    

    # result2 = []
    
    # if check == False:
    #     result2 = sorted(setSanPham)
    # elif check == True:
    #     result2 = sorted(result1)

    return sorted(result2)
    # print(listMaGiaoDich)
    # print(listSanPham)
    # print(setSanPham)
    # print(result2)


data = scipy.io.loadmat('Test2.mat')
transactions = data['transactions']
history = data['history']
products = data['products']

print(transactions)
print(history)
k = 'KH1'

print(req6(transactions, history, k))

