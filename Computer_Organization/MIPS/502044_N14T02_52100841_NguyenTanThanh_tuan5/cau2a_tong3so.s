
.text
.globl main
main:

# in câu lệnh 1
li $v0,4 # print_string syscall code = 4
la $a0, msg1 # truyền tải dữ liệu lệnh 1
syscall

# Nhập vào A và lưu dữ liệu của A
li $v0,5 # read_int syscall code = 5
syscall
move $t0,$v0 # syscall results returned in $v0

# in câu lệnh 2
li $v0,4 # print_string syscall code = 4
la $a0, msg2 # truyền tải dữ liệu lệnh 2
syscall


# Nhập vào B và lưu dữ liệu của B
li $v0,5 # read_int syscall code = 5
syscall
move $t1,$v0 # syscall results returned in $v0

# Tỉnh tổng của 2 số A và B ( A = A + B )
add $t0, $t0, $t1 # A = A + B

# in câu lệnh 3
li $v0,4 # print_string syscall code = 4
la $a0, msg3 # truyền tải dữ liệu lệnh3
syscall

# Nhập vào B và lưu dữ liệu của B
li $v0,5 # read_int syscall code = 5
syscall
move $t2,$v0 # syscall results returned in $v0

# in câu lệnh 4
li $v0, 4
la $a0, msg4 #truyền tải dữ liệu lệnh 2
syscall

#  Tỉnh tổng của 3 số A,B,C
# C = C + A 
# trong do A = A + B 
add $t2, $t2, $t0 # C = C + A

# In ra tong
li $v0,1 # print_int syscall code = 1
move $a0, $t2 # int to print must be loaded into $a0
syscall

# Print \n
li $v0,4 # print_string syscall code = 4
la $a0, newline
syscall
li $v0,10 # ket thuc
syscall

# bat dau du lieu (data!)
.data
msg1: .asciiz "Nhap vao so A: "
msg2: .asciiz "Nhap vao so B: "
msg3: .asciiz "Nhap vao so C: "
msg4: .asciiz "Tong cua A + B + C = "
newline: .asciiz "\n"