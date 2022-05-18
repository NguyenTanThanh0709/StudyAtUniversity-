from google.colab.patches import cv2_imshow
import numpy as np
from PIL import Image

im = Image.open('testdata/test.jpg')
plt.imshow(im)
im_g = np.asanyarray(im)

U, S, V  = np.linalg.svd(im_g,full_matrices=True)
s = np.diag(S)

for r in range(2,200,50):
    R = U[:,:r] @ s[:r,:r] @ V[:r,:]
    plt.imshow(R,cmap = 'gray')
    plt.title('r = ' + str(r))
    plt.plot()
    plt.pause(0.01)
    plt.clf()
    R = R.astype(np.uint8)
    compressed_image = Image.fromarray(R)
    compressed_image.save('testdata/compressed_image_' + str(r) + '.jpg')