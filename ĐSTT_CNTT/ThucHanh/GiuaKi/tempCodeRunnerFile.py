data = scipy.io.loadmat('data.mat')
transactions = data['transactions']
products = data['products']
history = data['history']

req1(transactions)
req2(products)
req3(transactions, products)
req4(transactions, products)
k = 3
req5(history, k)
k = 'U2'


req6(transactions, history, k)
req7(transactions, history)
k = 'U4'
req8(transactions, history, k)
req9(transactions, history, products)
req10(transactions,history,products,k)