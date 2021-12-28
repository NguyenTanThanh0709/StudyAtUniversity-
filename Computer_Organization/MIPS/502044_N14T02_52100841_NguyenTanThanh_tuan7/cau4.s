.data
array: .space 40
input: .asciiz " nhap vao chuoi: "
sort: .asciiz " mang giam dan : \n"
space: .asciiz " "
.text
.globl main
main:
	li $v0,4	# khai bao va goi lenh nhap
	la $a0, input
	syscall
	la $s1,array
LOOPINPUT:		#nhap chuoi
	li $v0,5
	syscall
	sw $v0,0($s1)
	addi $s1,$s1,4
	addi $t1,$t1,1
	bne $t1,10,LOOPINPUT

	la $s1,array
	sub $t1, $t1,$t1

SORTING:
	beq $t2,9,CONTSORT
	lw $t3,0($s1)
	lw $t4,4($s1)
	addi $s1,$s1,4
	addi $t2,$t2,1
	bge $t3,$t4,SORTING
	sw $t3,0($s1)
	sw $t4,-4($s1)
	bne $t2,9,SORTING
CONTSORT:
	la $s1,array
	addi $t1,$t1,1
	addi $t2,$t1,0
	bne $t1,9,SORTING

	li $v0,4
	la $a0,sort
	syscall
	la $s1,array
	sub $t1,$t1,$t1

PRINTSORT:	#xuatchuoi
	li $v0,1
	lw $a0,0($s1)
	syscall
	li $v0,4
	la $a0,space
	syscall
	addi $s1,$s1,4
	addi $t1,$t1,1
	bne $t1,10,PRINTSORT
	


	
	