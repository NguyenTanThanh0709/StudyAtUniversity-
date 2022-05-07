# transactions, products

import scipy.io
mat = scipy.io.loadmat('data.mat')

# lấy ra những phần tử trong stansaction
def req4(transactions,products):
    danhSachHang = []
    for i in range(transactions.shape[0]):
        data = list(list(transactions[i][1]))
        for j in range(len(data)):
            danhSachHang.append(str(data[j]).strip())
    print(danhSachHang)

    danhSachDoanhThu = []

    # lấy ra những phần từ không trùng nhau
   # _danhSachKhachHang = list(set(danhSachHang))
    # print(_danhSachKhachHang)

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

    # print(danhSachDoanhThu)
    # print(maxDoanhThu)
    # print(maxIDMatHang)
    
    return sorted(maxIDMatHang)


data = scipy.io.loadmat('Test2.mat')
transactions = data['transactions']
history = data['history']
products = data['products']

print(transactions)
print(products)


print(req4(transactions, products))
