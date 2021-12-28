.data
    nhap: .asciiz "nhap vao x:\n"
    result: .asciiz "Factorial(x) = "
.text
main:
    # gọi hàm nhập
    li        $v0, 4
    la        $a0, nhap
    syscall
    # đọc vào n
    li        $v0, 5
    syscall
    # gọi hàm
    move      $a0, $v0
    jal      factorial       # gọi đến factorial and lưu vào $ra
    move      $t0, $v0        # $t0 = $v0
    # gọi hàm in kết quả 
    li        $v0, 4
    la        $a0, result
    syscall
    # in kết quả
    li        $v0, 1        
    move      $a0, $t0        # $a0 = $t0
    syscall                
  
    li        $v0, 10        
    syscall


.text
factorial:
    
    
    addi    $sp, $sp, -8
   	 # lưu $s0 and $ra
    sw      $s0, 4($sp)
    sw      $ra, 0($sp)
    bne     $a0, 0, else
    addi    $v0, $zero, 1    # return 1
    j fact_return

else:
    		# backup $a0
    move    $s0, $a0
    addi    $a0, $a0, -1 	# x -= 1
    jal     factorial
    				#  Fact(x-1) lưu $v0
    multu   $s0, $v0 		# return x * Fact(x-1)
    mflo    $v0
fact_return:
    lw      $s0, 4($sp)
    lw      $ra, 0($sp)
    addi    $sp, $sp, 8
    jr      $ra