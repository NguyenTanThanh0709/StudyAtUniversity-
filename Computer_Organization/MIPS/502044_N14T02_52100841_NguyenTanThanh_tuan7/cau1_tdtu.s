.data
list: .asciiz "HELLO TDTU"
size: .word 10
newline: .asciiz "\n"

.text
.globl main
main:
	lw $t0, size
	la $t1, list
	li $t2, 0
	syscall

In:
	bgt $t2,$t0,end
	lb $a0,($t1)
	li $v0, 11
	syscall

	li $v0,4
	la $a0,newline
	syscall

	addi $t2,$t2,1
	addi $t1,$t1,1
	j In
end:
	li $v0,10
	syscall