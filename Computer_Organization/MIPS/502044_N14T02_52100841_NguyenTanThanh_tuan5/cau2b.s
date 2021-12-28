   .data
a: .asciiz "Nhap a:"
bb: .asciiz "Nhap b:"
c: .asciiz "Nhap c:"
d: .asciiz "Tong:"
e: .asciiz "\nHieu:"
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

    add $t3, $t1, $t2     #t1+t2 luu vao t3
    sub $t1, $t1, $t2    #t1-t2 luu vao t1
    
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

    jr $ra # retrun to caller