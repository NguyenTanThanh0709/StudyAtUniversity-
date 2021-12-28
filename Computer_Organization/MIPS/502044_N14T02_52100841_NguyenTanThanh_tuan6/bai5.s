.data
	msg1: .asciiz "Nhap N: "
	mgsduong: .asciiz "N la so duong"
	mgsam: .asciiz "N la so am"
	mgskhong: .asciiz "N la khong"
	newline: .asciiz "\n"
.text
.globl main
main:
	#hien thi msg1
	li $v0,4
	la $a0,msg1
	syscall

	#hien thi newline
	li $v0,4
	la $a0,newline
	syscall
	
	#dua gia tri vao $t0
	li $v0,5
	syscall
	move $t0,$v0	

	li $t1,0
	blt $t0,$t1,am
	beq $t0,$t1,khong

	duong:
		li $v0,4
		la $a0,mgsduong
		syscall
		j exit
	am:
		li $v0,4
		la $a0,mgsam
		syscall
		j exit
	khong:
		li $v0,4
		la $a0,mgskhong
		syscall
		
	exit:
		li $v0,10
		syscall

	