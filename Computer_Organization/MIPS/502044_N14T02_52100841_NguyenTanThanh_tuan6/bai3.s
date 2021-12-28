.data
	msg1: .asciiz "Nhap N"
	mgsresult: .asciiz "even sum : "
	newline: .asciiz "\n"
.text
.globl main
main:
	#msg1
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
	move $t2,$v0

	

	li  $t0, 0      # sum = 0
	li  $t1, 2      # i = 2
	Sum_Loop:
        	bgt   $t1, $t2, ExitLoop    # i>n exit
        	add  $t0, $t0, $t1          # sum = sum + i
        	add  $t1, $t1, 2            # i = i+1
        	j  Sum_Loop
	
	ExitLoop:
		li,$v0,4
		la $a0,mgsresult
		syscall
		
		li $v0,1 
		move $a0, $t0 
		syscall
	exit:
		li $v0,10
		syscall
		

	