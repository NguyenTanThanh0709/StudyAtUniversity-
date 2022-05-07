# from scipy.io import loadmat
# annots = loadmat('data.mat')
# print(annots)

import scipy.io
mat = scipy.io.loadmat('data.mat')

# lấy ra những phần tử trong stansaction

def req1(transactions):    
    
    danhSachHang = []
    for i in range(transactions.shape[0]):
        data = list(list(transactions[i][1]))
        for j in range(len(data)):
            danhSachHang.append(str(data[j]).strip())
    print(len(danhSachHang))
    print((danhSachHang))

    # lấy ra những phần từ không trùng nhau
    _danhSachKhachHang = sorted(list(set(danhSachHang)))
    # print(_danhSachKhachHang)

    # lấy ra phần tử max và phần tử min
    _max =  max(set(danhSachHang),key = danhSachHang.count)
    _min = min(set(danhSachHang),key = danhSachHang.count)
    # print(_max)
    # print(_min)

    # đếm số lượng max và min là bao nhiêu
    count_max = danhSachHang.count(_max)
    count_min = danhSachHang.count(_min)
    # print(count_max)
    # print(count_min)

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


    # print(sorted(_Max))
    # print(sorted(_Min))

    return sorted(_Max), sorted(_Min)

data = scipy.io.loadmat('Test2.mat')
transactions = data['transactions']
history = data['history']
products = data['products']

print(transactions)
print(req1(transactions))


######## Còn Trường Hợp Nếu Min == Max

