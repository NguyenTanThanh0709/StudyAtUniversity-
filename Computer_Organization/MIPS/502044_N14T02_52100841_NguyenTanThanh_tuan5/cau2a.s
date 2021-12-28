    .data
a: .asciiz "Nhap a:"
bb: .asciiz "Nhap b:"
c: .asciiz "Nhap c:"
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

    li $v0, 4
    la $a0, c    #print_Nhap c:
    syscall

    li $v0, 5
    syscall        #read c
    move $t3,$v0

    add $t1, $t1, $t2     #t1+t2 luu vao t1
    add $t1, $t1, $t3    #t1+t3 luu vao t1

    li $v0, 1
    move $a0, $t1
    syscall

    li $v0, 10
    syscall