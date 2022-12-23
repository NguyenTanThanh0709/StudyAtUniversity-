import cv2 # sử dụng thư viện xử lý ảnh OpenCV
import numpy as np # thư viện toán học, đặc biệt là các tính toán trên các ma trận
from matplotlib import pyplot as plt # thư viện vẽ biểu đồ

def showimage(myimage, figsize=[5,5]): # dùng để fix size ảnh 
    fig, ax = plt.subplots(figsize=figsize)
    ax.imshow(myimage, cmap = 'gray')
    plt.show()

def plot_histogram(img):
    # mỗi pixel có giá trị từ 0-255, nên phải khai báo một có 256 phần tử để chứa số đếm của các pixel có cùng giá trị
  hist, bins = np.histogram(img.flatten(),bins=256, range = [0,256])
  # dùng để fix size đồ thị
  fig, ax = plt.subplots(figsize=(5,5))
  ax.hist(img.flatten(),bins=256,range = [0,256],color='r')
  ax.set_xlabel('CƯỜNG ĐỘ PIXEL')
  ax.set_ylabel('#PIXEL')
  ax.set_xlim(0,255)
  # 3. tính toán hàm phân phối tích lũy (calculate CDF)
  cdf = hist.cumsum()
  cdf_normalized = cdf/cdf.max()
  ax2 = ax.twinx()
  ax2.plot(cdf_normalized, color = 'b')
  ax2.set_ylabel('CDF(phân phối tích lũy)')
  ax2.set_ylim(0,1)
  plt.show()

# Tính toán histogram của ảnh xám
def compute_hist(img):
    # mỗi pixel có giá trị từ 0-255, nên phải khai báo một có 256 phần tử để chứa số đếm của các pixel có cùng giá trị 
    hist = np.zeros((256,), np.uint8)
    # dùng để lấy kích thước của ảnh..... h, w = img.shape[:2]
    # w = img.shape[0]
    # h = img.shape[1]
    h, w = img.shape[:2]
    for i in range(h):
        for j in range(w):
            # lấy giá trị xám của điểm (i,j) hist[img[i][j]] += 1
            # giá trị gray tính ra cũng chính là phần tử thứ gray trong mảng his đã khai báo ở trên, sẽ tăng số đếm của phần tử thứ gray lên 1
            hist[img[i][j]] += 1
    return hist

def equal_hist(hist):
    cumulator = np.zeros_like(hist, np.float64)
    # Tính histogram mới của ảnh sau khi được cân bằng
    for i in range(len(cumulator)):
        cumulator[i] = hist[:i].sum()
    new_hist = (cumulator - cumulator.min())/(cumulator.max() - cumulator.min()) * 255
    new_hist = np.uint8(new_hist)
    return new_hist

def hist_equalize(img):
  # 1. calclate hist
  # hist = compute_hist(img)
  hist = cv2.calcHist([img], [0], None, [256], [0, 256])
  # 2. Chuẩn hóa biểu đồ (normalize hist)
  h, w = img.shape[:2]
  hist = hist/(h*w)
  # 3. tính toán hàm phân phối tích lũy (calculate CDF)
  cdf = np.cumsum(hist)
  # Tính giá trị cho từng điểm ảnh
  s_k = (255 * cdf-0.5).astype("uint8")
  return s_k

# ẢNH GỐC
img = cv2.imread("low-exposure.jpg", 0) # lấy ảnh từ thư viện opencv
showimage(img) # gọi hàm show ảnh 
plot_histogram(img) # gọi hàm in đồ thị

# ẢNH SAU KHI XỬ LÝ SỬ DỤNG HÀM HIST_EQUALIZE
s_k = hist_equalize(img) 
equalized_img = cv2.LUT(img, s_k)
showimage(equalized_img)
plot_histogram(equalized_img)

# ẢNH SAU KHI XỬ LÝ SỬ DỤNG HÀM EQUAL_HIST
# hist = compute_hist(img).ravel() # tính toán histogram của ảnh gốc
# new_hist = equal_hist(hist) # thực hiện cân bằng ảnh 
# h, w = img.shape[:2]
# for i in range(h):
#    for j in range(w):
#        img[i,j] = new_hist[img[i,j]] # chuyển hóa ảnh cân bằng qua ảnh gốc và hiển thị chúng
# showimage(img)
# plot_histogram(img)


