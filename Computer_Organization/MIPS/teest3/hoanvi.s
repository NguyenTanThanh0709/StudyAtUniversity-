    .data

nline: .asciiz"\n"
size: .word 10
list: .word 3, 0, 1, 2, 6, -2, 4, 7, 3, 7

    .text

main:

    lw $t3,size     #load size 
    la $t1,list    # dia chi cua "list" 
    li $t2,1    #bien vong lap i
    la $t0,list    # dia dau chi cua "list" 
    addi $t1,$t1,4    #i=1


loop_1:
    beq $t2,$t3,print        #lap den khi i==n
    
    lw $s1, ($t1)        #load phan tu a[i] vao $s1  <last =a[i]>
    add $s0,$zero,$t1     #luu dia chi vao s0             <j=i>

    jal whlie           #while 
    
    sw $s1,($s0)        # a[j]=last
    addi $t2,$t2,1    #i++
    addi $t1,$t1,4    #tang len dia chi tiep theo
    j loop_1


whlie:
    ble $s0,$t0,end_while
    lw $s2, -4($s0)         #s2=a[j-1]
    ble $s2,$s1,end_while
    sw $s2,0($s0)     #a[j]=a[j-1]
    addi $s0,$s0,-4
    j whlie
end_while:
    jr $ra

print:
    li $t2,0    #bien vong lap i
    la $t0,list    # dia dau chi cua "list" 

print_loop:
        beq $t2,$t3,end_print        #lap den khi i==n
        lw $a0, ($t0)
        li $v0,1
        syscall

        li $v0,4    #xuong dong
        la $a0,nline
        syscall

        addi $t2,$t2,1
        addi $t0,$t0,4
        j print_loop

end_print:
        
    li $v0,10
    syscall