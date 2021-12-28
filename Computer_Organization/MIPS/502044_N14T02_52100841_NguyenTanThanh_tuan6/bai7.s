.data
	msg1: .asciiz "Nhap n phai lon hon khong"
	mgsresult: .asciiz "n la: "
	newline: .asciiz "\n"
.text
.globl main
main:
	# msg1  hien thi n
	li $v0,4
	la $a0,msg1
	syscall

	#hien thi newline  doc vao n
	li $v0,4
	la $a0,newline
	syscall

	#gan n vao $t2
	li $v0,5
	syscall
	move $t2,$v0

	li $t1,1
	li $t0,0
	
	# lap den khi n > 0
	Sum_Loop:
        	blt  $t0,$t2,ExitLoop    # n>0 : exit
        	#hien thi msg1
		li $v0,4
		la $a0,msg1
		syscall

		#hien thi newline
		li $v0,4
		la $a0,newline
		syscall

		#gan $t2
		li $v0,5
		syscall
		move $t2,$v0
        	
		j  Sum_Loop
	# khi n > 0 thi thoat
	ExitLoop:
		li,$v0,4
		la $a0,mgsresult
		syscall
		
		li $v0,1 
		move $a0, $t2 
		syscall
	exit:
		li $v0,10
		syscall
		

	