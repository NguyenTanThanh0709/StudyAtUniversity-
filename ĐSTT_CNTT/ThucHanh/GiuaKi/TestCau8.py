import numpy as np
import scipy.io


def vector(transactions, history,k):

    ListSanPham = []
    for i in range(transactions.shape[0]):
        data = (list(transactions[i][1]))
        # ListSanPham += data
        for j in range(len(data)):
            ListSanPham.append(str(data[j]).strip())
    ListSanPham = sorted(list(set(ListSanPham)))
    # print(ListSanPham)

    listMaGiaoDichK = []
    for i in range(history.shape[0]):
        if str(history[i][0][0]).strip() == k:
            _listMaGiaoDichK = list(history[i][1])
            for j in range(len(_listMaGiaoDichK)):
                data = str(_listMaGiaoDichK[j]).strip()
                listMaGiaoDichK.append(data)
    # print(listMaGiaoDichK)


    listSanPhamm = []
    for i in range(len(listMaGiaoDichK)):
        maGiaoDich = listMaGiaoDichK[i]
        for j in range(transactions.shape[0]):
            if maGiaoDich == str(transactions[j][0][0]).strip():
                # print('---1', str(transactions[j][0][0]).strip())
                # code here
                _listSanPham = list(transactions[j][1])
                for k in range(len(_listSanPham)):
                    data = str(_listSanPham[k]).strip()
                    listSanPhamm.append(data)
                # listSanPhamm += _listSanPham

    # print('----',listSanPhamm,0)

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
    print(k,'->',vectork)

    Min = -1
    result = []
    for i in range(history.shape[0]):
        k1 = str(history[i][0][0]).strip()
        if k1 == k:
            continue
        vectork1 = vector(transactions, history,k1)
        print(k1,'->',vectork1)
        # if (len(listK) - len(listU)) > 0:
        #     count = len(listK) - len(listU)
        #     for j in range(count):
        #         listU.append(0)
        #     # print(listU)
        # elif (len(listU) - len(listK)) > 0:
        #     count = len(listU) - len(listK)
        #     for j in range(count):
        #         listK.append(0)
            # print(listK)
        
        cosine_Similarity = cosine_similarity(vectork,vectork1)
        print(k,k1,'->',cosine_Similarity)
        if Min < cosine_Similarity:
            Min = cosine_Similarity
            result = [k1]

    #print(result)
    return result


data = scipy.io.loadmat('Test2.mat')
transactions = data['transactions']
history = data['history']
products = data['products']

print(transactions)
print("-----------------------------")
print(history)
k = 'KH5'
# print(req8(data['transactions'],data['history'],'KH5')
print(req8(data['transactions'],data['history'],'KH5'))





# ListSanPham = []
# for i in range(transactions.shape[0]):
#     data = (list(transactions[i][1]))
#     ListSanPham += data
# ListSanPham = sorted(list(set(ListSanPham)))
# print(ListSanPham)

# k = 'U1'
# listMaGiaoDichK = []
# for i in range(history.shape[0]):
#     if str(history[i][0][0]).strip() == k:
#         _listMaGiaoDichK = list(history[i][1])
#         for j in range(len(_listMaGiaoDichK)):
#             data = str(_listMaGiaoDichK[j]).strip()
#             listMaGiaoDichK.append(data)
# print(listMaGiaoDichK)


# listSanPhamm = []
# for i in range(len(listMaGiaoDichK)):
#     maGiaoDich = listMaGiaoDichK[i]
#     for j in range(transactions.shape[0]):
#         if maGiaoDich == transactions[j][0]:
#             # code here
#             _listSanPham = list(transactions[j][1])
#             listSanPhamm += _listSanPham

# print(listSanPhamm)

# listK = []
# for i in range(len(ListSanPham)):
#     sanPham = ListSanPham[i]
#     count = listSanPhamm.count(sanPham)
#     if count > 0:
#         listK.append(count)
#     else:
#         listK.append(0)

# vector = np.array(listK)

# print(vector)

    
    




