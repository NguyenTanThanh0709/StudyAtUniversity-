.data
	chuoi: .space 100
	nhapchuoi: .asciiz " nhap chuoi: "
	phay: .asciiz "; "
	xd: .asciiz "\n"
.text
main:
	la $a0,nhapchuoi
	li $v0,4
	syscall

	li $a1,30
	la $a0,chuoi
	li $v0,8
	syscall

	la $a0,chuoi
	li $v0,4
	syscall

	li $v0,10
	syscall