import statistics  # Đầu tiên chúng ta sẽ import thư viện statistics để sử dụng các hàm trong như đã trình bày
import random      # import thư viện random để phục vụ một số bài toán của mình

data1 = [ random.randint(1, 100) for x in range(1,11) ] # Với dữ liệu đầu tiên mình sẽ dùng để tính trung bình cho 10 data random một cách ngẫu nhiên
print(data1)                                            # hiển thị bộ dữ liệu để kiếm chứng và xem dữ liệu

mean_data1 = statistics.mean(data1)     # thực hiện sử dụng hàm mean() để tính dữ liệu trên
print("giá trị trung bình hàm mean: ", mean_data1)       # In kết quả trung bình của bộ dữ liệu data1 theo số nguyên

fmean_data1 = statistics.fmean(data1)                   # thực hiện sử dụng hàm fmean() để tính dữ liệu trên
print("giá trị trung bình hàm fmean: ",fmean_data1)      # In kết quả trung bình của bộ dữ liệu data1 theo số thực

geo_mean_data1 = statistics.geometric_mean(data1)       # thực hiện sử dụng hàm geometric_mean() để tính dữ liệu trên
print("giá trị trung bình hình học (geometric_mean): ",geo_mean_data1)      # In kết quả trung bình hình học của bộ dữ liệu data1 theo số thực

harmonic_mean = statistics.harmonic_mean(data1)       # thực hiện sử dụng hàm harmonic_mean() để tính dữ liệu trên
print("giá trị trung bình hình học (harmonic mean): ",harmonic_mean)      # In kết quả trung bình  của bộ dữ liệu data1 theo số thực

print(" \n================================================= \n")

# ta sẽ sử dụng một dữ liệu khác để xem cách hoạt động của của trọng số (weight) trong hàm fmean
# VÍ Dụ:
# đối với môn xác xuất thống kê trường TDTU thì điểm học phần được tính như sau: điểm quá trình 1 chiếm 10%, điểm quá trình 2 chiếm 20%, 
# điểm giữa kì chiếm 20% và điểm cuối kì chiếm 50%, dữ liệu có điểm lần lượt như sau:

# Diem = [8,10,9,7]
# tile = [0.1,0.2,0.2,0.5]
# diemHocPhan = statistics.fmean(Diem,tile)
# print(diemHocPhan) # diem hoc phan la: 8.1

print(" \n================================================= \n")

# Ta sẽ so sánh sự khác biệt khi dữ liệu có độ dài chẵn và độ dài lẻ  
print("kết quả của dữ liệu có độ dài chẵn: ")
data2 = [1,2,3,4,5,6,7,8,9,10]              # dữ liệu có độ dài chẵn
media_data2 = statistics.median(data2)           # gọi hàm để tính median
median_low_data2 = statistics.median_low(data2) # gọi hàm để tính median_low
median_high_data2 = statistics.median_high(data2)   # gọi hàm để tính median_high
median_grouped_data2 = statistics.median_grouped(data2) # gọi hàm để tính median_group

print("media: ", media_data2)
print("media_low: ", median_low_data2)
print("media_high: ", median_high_data2)
print("media_group: ", median_grouped_data2)
print(" \n================================================= \n")

print("kết quả của dữ liệu có độ dài lẻ: ")
data2_1 = [1,2,3,4,5,6,7,8,9,10,11]   # dữ liệu có độ dài lẻ
media_data2_1 = statistics.median(data2_1)# gọi hàm để tính median
median_low_data2_1 = statistics.median_low(data2_1)# gọi hàm để tính median_low
median_high_data2_1 = statistics.median_high(data2_1)# gọi hàm để tính median_high
median_grouped_data2_1 = statistics.median_grouped(data2_1)# gọi hàm để tính median_group

print("media: ", media_data2_1)
print("media_low: ", median_low_data2_1)
print("media_high: ", median_high_data2_1)
print("media_group: ", median_grouped_data2_1)

data3_2 = [1,1,2,3,1,2]     # dữ liệu dùng để tính Mode
print(data3_2)
print("Mode là: ", statistics.mode(data3_2)) # gọi hàm thực hiện tìm Mode 
#và In ra dữ liệu xuất hiện nhiều nhất trong bộ dữ liệu trên 

print(" \n================================================= \n")

data3 = [1,1,2,2,1,1,2,2,3,4,5,6] # dữ liệu tiếp theo
print(data3)
print("Mode của data Trên: ", statistics.mode(data3))   # nhận thấy dữ liệu chỉ in ra 1 dữ liệu 
#trong khi có nhiền mode
print("multiMode của data Trên: ",statistics.multimode(data3))  # In ra danh sách Mode

print(" \n================================================= \n")
data3_1 = ['Thanh', 'Hung', 'Ha', 'Thanh', 'Hung', 'Tuan'] # tiếp tục thực hiện trên data là String
print(data3_1)
print("Mode của data Trên: ", statistics.mode(data3_1))
print("multiMode của data Trên: ", statistics.multimode(data3_1))

print(" \n================================================= \n")


data4 = [0,1,2,3,4,5,6,7,9,10]      # dữ liệu dùng để tính quantiles

re = statistics.quantiles(data4)
print('The third quartile of the given data set is', re)

# chúng ta thử thay đổi n để xem kết quả sẽ như thế nào

re = statistics.quantiles(data4, n= 5)
print('The 4th quartile of the given data set is', re)

re = statistics.quantiles(data4, n= 6)
print('The 5th quartile of the given data set is', re)

data = [8,8,7,3,7,5,4,2,10]      # dữ liệu để tính Phương sai, độ lệch chuẩn
statistics.pvariance(data) 	
statistics.pstdev(data)    	
statistics.variance(data)  	
statistics.stdev(data)     	

# phương và độ lệch tiêu chuẩn của bộ dữ liệu.

print("độ lệch chuẩn của bộ dữ liệu: ",statistics.pstdev(data)    )
print("Phương sai của bộ ",statistics.pvariance(data) )

print(" \n================================================= \n")

# phương và độ lệch tiêu chuẩn của mẫu dữ liệu.
print("độ lệch chuẩn của mẫu ", statistics.stdev(data))
print("Phương sai của mẫu ", statistics.variance(data)  )

print(" \n================================================= \n")

print("mean", statistics.mean(data))

print("phương sai nhỏ hơn hàm ý rằng nhiều data point có giá trị gần hơn với giá trị trung bình. ")
 
print(" \n================================================= \n")
# dữ liệu để tính correlation
x = [1,5,7,10,11,52,213,211]
y = [9, 8, 7, 6, 5, 4, 3, 2]
print("correlation")
print(statistics.correlation(x,x), 'dữ liệu có cùng xu hướng')
print(statistics.correlation(x,y), 'dữ liệu khác xu hướng')

print(" \n================================================= \n")
# dữ liệu để tính covariance
x = [1,2,3,4,5,6,7,8,9]
y = [9,8,7,6,5,4,3,2,1]
print("Covariance - ", statistics.covariance(x, y), " => Điều này chỉ ra rằng cả hai biến / đầu vào ngẫu nhiên đều di chuyển khác hướng.")
print(" \n================================================= \n")
# dữ liệu để tính linear_regression
x = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
y = [11 ,13, 12, 15, 17, 18, 18, 19, 20, 22]

slope, intercept = statistics.linear_regression(x, y)

print("Slope - ", slope)
print("Intercept - ", intercept)
