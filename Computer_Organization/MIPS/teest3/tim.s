  .data

msg_nhap_a: .asciiz "nhập a muốn tìm : "
msg_nhap_b: .asciiz "Nhap b muốn tìm: "
msg_nhap_vt: .asciiz "Nhap vi tri mong muon: "
msg_not_found_a:  .asciiz "Khong tim thay a"
msg_not_found_b:  .asciiz "Khong tim thay b"
nline: .asciiz"\n"
arr: .word 3, 0, 1, 2, 6, -2, 4, 7, 3, 7

temp_a: .word 0:10
temp_b: .word 0:10
    .text

main:

    la $a0,msg_nhap_a
    jal print_text  #in thong bao nhap
    jal red_num     #nhap a
    move $s1,$v0    #luu a vao s1

    la $a0,msg_nhap_b
    jal print_text  #in thong bao nhap
    jal red_num     #nhap b
    move $s4,$v0    #luu a vao s4




    la $t0,arr        #load dia chi arr => t0
    la $t1,temp_a     #load dia chi temp_a => t1
    la $t4,temp_b     #load dia chi temp_b => t4
    li $t2,0         #khoi tao t2 = 0  <i>
    li $s2,0         #khoi tao s2 = 0  <p>
    li $s3,0         #khoi tao s3 = 0 <q>
    li $t3,10        #khoi tao t3 = 10  <n>

    jal loop_a

    la $t0,arr        #load dia chi arr => t0
    li $t2,0         #khoi tao t2 = 0  <i>

    jal loop_b

    j check

    j exit



loop_a : 
    beq $t2,$t3,end_loop    #t2==t3 -> end_loop
    lw  $s0,($t0)           #load gt a[i] => s0
    beq $s0,$s1,store_temp_a  #a[i]=a -> temp_a[m++]=i
    addi $t2,$t2,1          #i=i+1
    addi $t0,$t0,4          #t0=t0 + 4 
    j loop_a
end_loop:
   jr $ra

store_temp_a:
    sw $t2,($t1)        #temp_a[p++]=i
    addi $s2,$s2,1      #p=p+1
    addi $t1,$t1,4      
    jr $ra


loop_b : 
    beq $t2,$t3,end_loop    #t2==t3 -> end_loop
    lw  $s0,($t0)           #load gt a[i] => s0
    beq $s0,$s4,store_temp_b  #a[i]=b -> temp_b[q++]=i

    addi $t2,$t2,1          #i=i+1
    addi $t0,$t0,4          #t0=t0 + 4 
    j loop_b



store_temp_b:
    sw $t2,($t4)        #temp_b[q++]=i
    addi $s3,$s3,1      #q=q+1
    addi $t4,$t4,4
    jr $ra              #return

check:
    li $t2,1
    beq $s2,$zero,not_found_a       #s2=0 -> ko tim thay a
    beq $s3,$zero,not_found_b        #s3=0 -> ko tim thay b
    jal chose_a             #s2 > 1 -> chon a
    jal chose_b             #s2 > 1 -> chon a
swap:
    la $t0,arr
    li $t3,4

    mult $s5,$t3
    mflo $s5
    add  $s5,$t0,$s5

    mult $s6,$t3
    mflo $s6
    add  $s6,$t0,$s6

    lw $t3,($s5)
    lw $t4,($s6)

    sw $t3,($s6)
    sw $t4, ($s5)

    j exit


chose_a:
    li $t3,0            
    la $t1,temp_a
    jal print_temp_a
    la $a0,msg_nhap_vt
    jal print_text
    jal red_num     #nhap vt
    move $s5,$v0    #vt a = s5
    jr $ra


chose_b:
    li $t3,0            
    la $t4,temp_b
    jal print_temp_a
    la $a0,msg_nhap_vt
    jal print_text
    jal red_num     #nhap vt
    move $s6,$v0    #vt b = s6
    j swap

print_temp_b:                   #in ra cac vi tri = b
    beq $t3,$s2,end_print
    lw $a0,($t4)
    jal print_num
    jal newline

    addi $t3,$t3,1          #i=i+1
    addi $t4,$t4,4          #t4=t4 + 4 
    j print_temp_b



not_found_a:
    la $a0,msg_not_found_a      #in ra ko tim thay a
    jal print_text
    j exit

not_found_b:
    la $a0,msg_not_found_b      #in ra ko tim thay b
    jal print_text
    j exit



print_temp_a:                   #in ra cac vi tri = a
    beq $t3,$s2,end_print
    lw $a0,($t1)
    jal print_num
    jal newline

    addi $t3,$t3,1          #i=i+1
    addi $t1,$t1,4          #t1=t1 + 4 
    j print_temp_a

end_print:
    jr $ra

newline:   
    la $a0,nline
    li $v0,4
    syscall
    jr $ra    #return

print_text:
    li $v0,4
    syscall
    jr $ra    #return

print_num:
    li $v0,1
    syscall
    jr $ra    #return

red_num:
    li $v0,5
    syscall
    jr $ra    #return

exit: 
    li $v0,10
    syscall
