# transactions, products

import scipy.io
mat = scipy.io.loadmat('data.mat')


def req3(transactions, products):
    
    total_revenue = 0
    # lấy ra những phần tử trong stansaction
    danhSachHang = []
    for i in range(transactions.shape[0]):
        data = list(list(transactions[i][1]))
        for j in range(len(data)):
            danhSachHang.append(str(data[j]).strip())
    print(danhSachHang)

    # lấy ra những phần từ không trùng nhau
    _danhSachKhachHang = list(set(danhSachHang))
    print(_danhSachKhachHang)

    for i in range(products.shape[0]):
        IDHang = str(products[i][0]).strip()
        soLuong = danhSachHang.count(IDHang)
        total_revenue += soLuong*int(str(products[i][1]).strip())

    # print(total_revenue)
    return total_revenue


data = scipy.io.loadmat('Test2.mat')
transactions = data['transactions']
history = data['history']
products = data['products']

print(transactions)
print(products)
print(req3(transactions, products))

