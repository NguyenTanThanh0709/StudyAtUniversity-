.data
	msg1: .asciiz "Nhap A: "
	msg2: .asciiz "Nhap B: "
	mgslonhon: .asciiz "A>B"
	mgsbehon: .asciiz "A<B"
	mgsbang: .asciiz "A=B"
	newline: .asciiz "\n"
.text
.globl main
main:
	#hien thi msg1
	li $v0,4
	la $a0,msg1
	syscall

	#newline
	li $v0,4
	la $a0,newline
	syscall
	
	#gan $t0
	li $v0,5
	syscall
	move $t0,$v0	

	#hien thi msg2
	li $v0,4
	la $a0,msg2
	syscall

	#newline
	li $v0,4
	la $a0,newline
	syscall
	
	#gan $t1
	li $v0,5
	syscall
	move $t1,$v0

	sub $t2,$t0,$t1

	li $t3,0
	blt $t2,$t3,nhohon
	beq $t2,$t3,bang
	bgt $t2,$t3,lonhon

	nhohon:
		li $v0,4
		la $a0,mgsbehon
		syscall
		j exit
	bang:
		li $v0,4
		la $a0,mgsbang
		syscall
		j exit
	lonhon:
		li $v0,4
		la $a0,mgslonhon
		syscall
	exit:
		li $v0,10
		syscall