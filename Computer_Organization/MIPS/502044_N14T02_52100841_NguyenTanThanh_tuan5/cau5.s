.data
a: .asciiz "Nhap a:"
bb: .asciiz "Nhap b:"

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

    mul.d $f10, $f2, $f4

    li $v0, 4
    la $a0, g    #print_Tich
    syscall
        
    li $v0, 3
    mov.d $f12, $f10    #Xuat_Tich
    syscall

    li $v0, 10
    syscall