# in ra số fibonacci của số vừa nhập

	.data
prompt1:
	.asciiz "muốn tìm fibonacci của số : "
prompt2:
	.asciiz "Fibonacci của "
prompt3:
	.asciiz " là:  "

	.text
	.globl main
main:
	li $v0, 4	# gọi hàm nhập
	la $a0, prompt1
	syscall

	li $v0, 5	# đọc
	syscall

	move $a0, $v0	# gọi đến hàm fibonacci
	jal fibonacci

	move $t0, $v0	# đưa vào thanh ghi t0
	move $t1, $a0	# đưa vào thanh ghi t1

	li $v0, 4	# gọi lệnh in kết quả
	la $a0, prompt2
	syscall

	li $v0, 1
	move $a0, $t1
	syscall

	li $v0, 4
	la $a0, prompt3
	syscall

	li $v0, 1
	move $a0, $t0
	syscall

	li $v0, 10
	syscall


	.text
	.globl fibonacci
fibonacci:
	addi $sp, $sp, -12
	sw $ra, 8($sp)
	sw $a0, 4($sp)

	slti $t0, $a0, 1
	beq $t0, $zero, L1
	li $v0, 0
	addi $sp, $sp, 12
	jr $ra
L1:
	slti $t0, $a0, 2
	beq $t0, $zero, L2
	li $v0, 1
	addi $sp, $sp, 12
	jr $ra
L2:
	addi $a0, $a0, -1
	jal fibonacci
	sw $v0, 0($sp)
	lw $a0, 4($sp)
	addi $a0, $a0, -2
	jal fibonacci
	lw $t0, 0($sp)
	add $v0, $v0, $t0

	lw $a0, 4($sp)
	lw $ra, 8($sp)
	addi $sp, $sp, 12
	jr $ra