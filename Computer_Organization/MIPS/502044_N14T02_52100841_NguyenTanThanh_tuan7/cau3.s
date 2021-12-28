.data
array: .space 40
input: .asciiz " input 10 number: "

space: .asciiz " "
.text
.globl main
main:
	li $v0,4	#goi lenh nhap
	la $a0, input
	syscall
	la $s1,array
LOOPINPUT:		#nhap tung phan tu cho chuoi
	li $v0,5
	syscall
	sw $v0,0($s1)
	addi $s1,$s1,4
	addi $t1,$t1,1
	bne $t1,10,LOOPINPUT

	la $s1,array
	sub $t1, $t1,$t1

PRINTSORT:		# xuat chuoi
	li $v0,1
	lw $a0,0($s1)
	syscall
	li $v0,4
	la $a0,space
	syscall
	addi $s1,$s1,4
	addi $t1,$t1,1
	bne $t1,10,PRINTSORT


	