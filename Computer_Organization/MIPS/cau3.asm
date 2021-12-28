.text
.globl main
main:
	# --------------------------------------------------
	# cau 1, 2, 3, 4: 
	#	Nhap vao 1 so nguyen N. 
	#	Xac dinh so nguyen to.
	#	In so nguyen to tu 2 den N. 
	#	Xac dinh phai so Palindrome.
	#	Kiem tra N co hop le.
	# --------------------------------------------------
	
	# Nhap N
	inputN:
		# N <= 0
		li $v0, 4
		la $a0, inputNs
		syscall

		li $v0, 5
		syscall
		move $t1, $v0
	ble $t1, $zero, inputN
	
	move $t0, $t1

	beq $t1, 1, prime_end
		li $t9, 1 
		checkPrime_end:
			addi $t9, $t9, 1
			li $t8, 2
			
			blt $t1, $t9, prime_end
			next_checkPrime:
				beq $t8, $t9, prime
					div $t9, $t8
					mfhi $t7
				beq $t7, $zero, checkPrime_end
					addi $t8, $t8, 1
					j next_checkPrime
			prime:
				move $a0, $t9
				li $v0, 1
				syscall
				
				la $a0, spaces
				li $v0, 4
				syscall
			beq $t9, $t1, checkPalin
				# i != n
				j checkPrime_end
			checkPalin:
				la $a0, spaces
				li $v0, 4
				syscall
		
				li $t7, 10
				div $t1, $t7
				mflo $t1
				mfhi $t6
				
				mul $t5, $t5, $t7
				add $t5, $t5, $t6
			bgt $t1, $zero, checkPalin
				
	bne $t0, $t5, checkPalin_end
		la $a0, palindromes
		j next
	prime_end:
	checkPalin_end:
		la $a0, notPalindromes
	next:
	li $v0, 4
	syscall

	# --------------------------------------------------
	# cau 5: 
	#	In ra so Fibonacci.
	# --------------------------------------------------
	
	# Lay N
	move $t1, $t0

	# Tinh va in ket qua
	li $v0, 4
	la $a0, fibonaccis
	syscall

	li $s1, 0
	li $s2, 1
	li $t9, 2
	j fibonacci_start
	
	fibonacci:
		addi $t9, $t9, 1
		rem $t7, $t9, 2
		
		fibonacci_start: 
		blt $t1, $t9, fibonacci_end
		
			# i <= N
			beq $t7, $zero, chan
				# i % 2 != 0 
				add $s2, $s2, $s1
				move $a0, $s2
				j fibonacci
			chan:
				add $s1, $s1, $s2
				move $a0, $s1
				j fibonacci
		fibonacci_end:
		
	li $v0, 1
	syscall

	# --------------------------------------------------
	# cau 6: 
	#	In ra N!.
	# --------------------------------------------------
	
	la $a0, giaiThuas
	li $v0, 4
	syscall

	li $t9, 1
	li $a0, 1
	giaiThua:
		blt $t1, $t9, giaiThua_end
		
		mul $a0, $a0, $t9
		addi $t9, $t9, 1
		j giaiThua
	giaiThua_end:
	li $v0, 1
	syscall

	# --------------------------------------------------
	# cau 7: 
	#	Xac dinh so Triangular.
	# --------------------------------------------------
	
	li $t9, 1
	li $a0, 0
	
	triangular:
		ble $t1, $a0, triangular_end
		
		add $a0, $a0, $t9
		addi $t9, $t9, 1
		j triangular
	triangular_end:
	
	bne $t1, $a0, not_triangular
		la $a0, triangulars
		j ends
	not_triangular:
		la $a0, notTriangulars
	ends:
	
	li $v0, 4
	syscall

	# --------------------------------------------------
	# cau 8: 
	#	Tinh tong cac ki so.
	# --------------------------------------------------
	
	# Nhap N
	la $a0, inputNs
	li $v0, 4
	syscall

	li $v0, 5
	syscall
	move $t1, $v0
	
	# In ra ket qua
	la $a0, sumKiSos
	li $v0, 4
	syscall

	li $a0, 0
	li $t7, 10
	kiSo: 
		ble $t1, $zero, kiSo_end
		
		div $t1, $t7
		mfhi $t6
		mflo $t1
		add $a0, $a0, $t6
		j kiSo
	kiSo_end:
	
	li $v0, 1
	syscall

.data
	inputNs: .asciiz "Nhap n: "
	primess: .asciiz "Cac so nguyen to: "
	spaces: .asciiz " "
	palindromes: .asciiz "\n-> Palindrome\n"
	notPalindromes: .asciiz "\n-> Not palindrome\n"
	fibonaccis: .asciiz "-> Fibonacci: "
	giaiThuas: .asciiz "\n-> Giai Thua: "
	triangulars: .asciiz "\n-> Triangular\n"
	notTriangulars: .asciiz "\n-> Not triangular\n"
	sumKiSos: .asciiz "\n-> Tong cac ki so: "