    .data
a: .asciiz "Nhap a:"
bb: .asciiz "Nhap b:"
c: .asciiz "Nhap c:"
d: .asciiz "tich:"
e: .asciiz "\nthuong:"
    .text
main:
    li $v0, 4
    la $a0, a    #print_Nhap a:
    syscall

    li $v0, 5
    syscall        #read a
    move $t1,$v0
    
    li $v0, 4
    la $a0, bb    #print_Nhap b:
    syscall

    li $v0, 5
    syscall        #read b
    move $t2,$v0

    mul $t3, $t1, $t2     #t1*t2 luu vao t3
    div $t1, $t1, $t2    #t1/t2 luu vao t1
    
    li $v0, 4
    la $a0, d    #print_Tong
    syscall

    li $v0, 1
    move $a0, $t3    #Xuat_Tong
    syscall
    
    li $v0, 4
    la $a0, e    #print_Hieu
    syscall

    li $v0, 1
    move $a0, $t1    #Xuat_Hieu
    syscall