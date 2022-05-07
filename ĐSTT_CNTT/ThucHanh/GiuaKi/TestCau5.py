import scipy.io
mat = scipy.io.loadmat('data.mat')

# print(mat['history'])

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
    # print(_history1)
    # print(_dict)
    # print(_dict1)
    # print(history2)

    _key = list(_dict1.keys())
    # print(_key)

    result = []
    for i in range(k):
        result.append(_key[i])

    # print(result)
    return result


data = scipy.io.loadmat('Test2.mat')
transactions = data['transactions']
history = data['history']
products = data['products']

print(transactions)
print(products)
k = 4

print(req5(history, k))
    











