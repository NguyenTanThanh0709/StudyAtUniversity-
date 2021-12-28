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
    
    
    li $v0, 7
    syscall        #read_a
    mov.d $f2, $f0

    li $v0, 4
    la $a0, bb    #print_Nhap b:
    syscall
    
    
    li $v0, 7
    syscall        #read_b
    mov.d $f4, $f0

    add.d $f6, $f2, $f4
    sub.d $f8, $f2, $f4
    mul.d $f10, $f2, $f4

    li $v0, 4
    la $a0, d    #print_Tong
    syscall
    
    li $v0, 3
    mov.d $f12, $f6    #Xuat_Tong
    syscall

    li $v0, 4
    la $a0, e    #print_Hieu
    syscall

    li $v0, 3
    mov.d $f12, $f8    #Xuat_Hieu
    syscall

    li $v0, 4
    la $a0, g    #print_Tich
    syscall
        
    li $v0, 3
    mov.d $f12, $f10    #Xuat_Tich
    syscall

    li $v0, 10
    syscall