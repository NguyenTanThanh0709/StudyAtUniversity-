.data
myArray: .space 20
min: .word 0
max: .word 0
prompt1: .asciiz " nhap vao mang "
maxMsg: .asciiz " max : "
minMsg: .asciiz " min : "
.text
main:
	li $v0,4
	la $a0,prompt1
	syscall

	li $t0,0
	li $s0,0

loop:
	li $v0,5
	syscall
	sw $v0,myArray($t0)
	addi $t0,$t0,4
	addi $s0,$s0,1
	blt $s0,10,loop


	li $t0,0
	lw $s0,myArray($t0)
	move $s2,$s0
	li $t1,1

again: beq $t1,10,endloop
	add $t0,$t0,4
	lw $s1,myArray($t0)
	bge $s0,$s1,nochg
	move $s0,$s1
nochg:  
	ble $s2,$s1,nexti
	move $s2,$s1

nexti:	add $t1,$t1,1
	j again
endloop:
	li $v0,4
	la $a0,maxMsg
	syscall

	li $v0,1
	move $a0,$s0
	syscall
	sw $s0,max

	li $v0,4
	la $a0,minMsg
	syscall

	li $v0,1
	move $a0,$s2
	syscall
	sw $s2,min