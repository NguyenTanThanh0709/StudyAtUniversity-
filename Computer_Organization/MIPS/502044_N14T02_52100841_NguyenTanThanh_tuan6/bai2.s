.data
	msg1: .asciiz "Nhap N"
	mgsresult: .asciiz "sum binh phuong cua N la: "
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
	move $t2,$v0

	li  $t0, 0      # sum = 0
	li  $t1, 1      # i = 1
	
	Sum_Loop:
        	bgt  $t1, $t2, ExitLoop    # i>n thi thoát lặp
		mul  $t3,$t1,$t1	   # i=i*i
        	add  $t0, $t0, $t3         # sum=sum + i
		add  $t1, $t1, 1           # i=i+1
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
		

	