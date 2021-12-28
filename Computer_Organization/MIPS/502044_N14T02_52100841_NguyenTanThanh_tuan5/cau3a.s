    .data
a: .asciiz "Nhap a:"
bb: .asciiz "Nhap b:"
d: .asciiz "Tong:"
e: .asciiz "\nHieu:"
g: .asciiz "\nTich:"
    .text
main:
    li $v0, 4
    la $a0, a    #print_Nhap a:
    syscall

    li $v0, 6
    syscall        #read_a
    mov.s $f1, $f0

    li $v0, 4
    la $a0, bb    #print_Nhap b:
    syscall

    li $v0, 6
    syscall        #read_b
    mov.s $f2, $f0

    add.s $f3, $f1, $f2
    sub.s $f4, $f1, $f2
    mul.s $f5, $f1, $f2

    li $v0, 4
    la $a0, d    #print_Tong
    syscall
    
    li $v0, 2
    mov.s $f12, $f3    #Xuat_Tong
    syscall

    li $v0, 4
    la $a0, e    #print_Hieu
    syscall

    li $v0, 2
    mov.s $f12, $f4    #Xuat_Hieu
    syscall

    li $v0, 4
    la $a0, g    #print_Tich
    syscall
        
    li $v0, 2
    mov.s $f12, $f5    #Xuat_Tich
    syscall

    li $v0, 10
    syscall
    