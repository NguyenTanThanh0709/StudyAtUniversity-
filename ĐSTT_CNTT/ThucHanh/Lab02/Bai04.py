import numpy as np
x = [1,2,3]
y = [98,12,33]

print(np.hstack((x,y)))
print(np.vstack((x,y)))
print(np.concatenate((x,y), axis =0))
