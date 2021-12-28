.data
	msg1: .asciiz "Nhap N1"
	msg2: .asciiz "Nhap N2"
	newline: .asciiz "\n"
	lon: .asciiz " n1 < n2 "
	be: .asciiz " n1 > n2 "
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
	move $t1,$v0

	#hien thi msg1
	li $v0,4
	la $a0,msg2
	syscall

	#hien thi newline
	li $v0,4
	la $a0,newline
	syscall

	#dua gia tri vao $t0
	li $v0,5
	syscall
	move $t2,$v0

blt $t1,$t2, first
blt $t2,$t1, second
b exitLabel

first: li $v0,4
la $a0, lon
syscall
b exitLabel
second: li $v0,4
la $a0, be
syscall

b exitLabel

exitLabel:
li $v0, 10
syscall


