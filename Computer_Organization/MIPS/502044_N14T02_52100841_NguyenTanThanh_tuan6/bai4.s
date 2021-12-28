.data
	msg1: .asciiz "Nhap N: "
	mgschiahet: .asciiz "N chia het cho 3"
	mgskhongchiahet: .asciiz "N khong chia het cho 3"
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

	rem $t1,$t0,3

	li $t2,0
	bne $t2,$t1,khongchiahet

	chiahet:
		li $v0,4
		la $a0,mgschiahet
		syscall
		j exit
	khongchiahet:
		li $v0,4
		la $a0,mgskhongchiahet
		syscall
	exit:
		li $v0,10
		syscall

	