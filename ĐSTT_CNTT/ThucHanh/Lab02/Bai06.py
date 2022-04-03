import numpy as np

x = [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

print("Cau a: Take the first sixth elements in the vector x: ",x[:5])
print("Cau b: Take the last fifth elements in the vector x: ",x[-5:])
print("Cau c: Take the first, fourth, last elements in the vector x: ",x[0:4],x[3:],x[-1:])
print("Cau d: Take the first, third, fifth, and seventh elements in the vector x: ",x[0:4],x[2:5],x[4:7])
print("Cau e: Take the elements with the odd indices in the vector x: ",x[1::2])
print("Cau f: Take the elements with the even indices in the vector x: ",x[0::2])