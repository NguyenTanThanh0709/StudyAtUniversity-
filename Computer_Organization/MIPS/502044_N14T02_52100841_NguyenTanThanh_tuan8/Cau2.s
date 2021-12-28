```    .data
msg_nhap_n: .asciiz"Nhap vao n : "
msg_nhap_lai: .asciiz"Nhap sai, nhap lai, (0<=n<=100):\n"
msg_ket_qua: .asciiz" day fibo la :"
nline: .asciiz"\n"

    .text
main:

    la $a0,msg_nhap_n   #in  thong bao nhap
    jal print_text

    jal read_num        #nhap n
    move $s0,$v0        


    li $t1,100          #khoi tao t1 = 100
    jal checkn          #kiem tra so n có hợp lệ k 

    li $t2,0            

    move $a0,$s0        #Thong bao fibonacci
    jal print_num
    la $a0,msg_ket_qua 
    jal print_text          
    jal newline
    
    move $a0,$s0 

    j print_loop            #in ra n so fibonaci

print_loop:
	beq $t2,$s0,exit    	#lap den n = 1
	move $a0,$t2
    jal fib                
    move $a0,$v0
    jal print_num           #in ra so fibonaci thu i

    jal newline    

	addi $t2,$t2,1	#i++
	j print_loop


checkn: 
    blt $s0,$zero,nhap      #n<0 -> nhao lai
	blt $t1,$s0,nhap        #10<n -> nhao lai
	jr $ra                  #return
nhap: 	
	# nhap lai
	la $a0,msg_nhap_lai
	li $v0,4
	syscall
	# Chuyen qua thanh ghi $a0
	li $v0,5
	syscall
	move $s0,$v0
	j checkn


	# lấy trên buổi 8
fib:
    addi $sp, $sp, -8 # room for $ra and one temporary
    sw $ra, 4($sp) # save $ra
    move $v0, $a0 # pre-load return value as n
    blt $a0, 2, fib_rt # if(n < 2) return n
    sw $a0, 0($sp) # save a copy of n
    addi $a0, $a0, -1 # n - 1
    jal fib # fib(n - 1)
    lw $a0, 0($sp) # retrieve n
    sw $v0, 0($sp) # save result of fib(n - 1)
    addi $a0, $a0, -2 # n - 2
    jal fib # fib(n - 2)
    lw $v1, 0($sp) # retrieve fib(n - 1)
    add $v0, $v0, $v1 # fib(n - 1) + fib(n - 2)
fib_rt:
    lw $ra, 4($sp) # restore $ra
    addi $sp, $sp, 8 # restore $sp
    jr $ra # back to caller
print_text:
    li $v0,4
    syscall
    jr $ra    

print_num:
    li $v0,1
    syscall
    jr $ra    

read_num:
    li $v0,5
    syscall
    jr $ra   

newline:   
    la $a0,nline
    li $v0,4
    syscall
    jr $ra    

exit: li $v0,10
    syscall