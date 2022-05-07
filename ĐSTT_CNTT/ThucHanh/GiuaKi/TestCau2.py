import scipy.io
mat = scipy.io.loadmat('data.mat')

# print(mat['products'])

# tìm max và min của hàng tồn kho

def req2(products):
    
    danhSachHang = []
    for i in range(products.shape[0]):
        data = (str(products[i][2]).strip())
        danhSachHang.append(int(data))

    _Max = max(danhSachHang)
    _Min = min(danhSachHang)
    # print(danhSachHang)
    # print(_Max)
    # print(_Min)
    # chưa xử lý nếu _Max == _Min

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

    # print(MaxHangTonKho)
    # print(MinHangTonKho)
    return sorted(MaxHangTonKho), sorted(MinHangTonKho)



data = scipy.io.loadmat('Test2.mat')
transactions = data['transactions']
history = data['history']
products = data['products']

print(transactions)
print(req2(products))




