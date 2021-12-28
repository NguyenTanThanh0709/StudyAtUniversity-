.data
arr: .word 1 2 3 4 5 6 7 8 9 10
msg: .asciiz "result: "
.text
.globl main
# variable assignment
# t0 = i
# t1 = sum
#t2 = constan 10, for comparious
#t3 = address of array elements
#t4 = temporary value

main:
addi $t0, $0,0
addi $t1, $0,0
ori $t2, $0, 10
la $t3, arr
loop:
slt $t4, $t0, $t2
beq $t4, $0, end
lw $t4,0($t3)
add $t1, $t1, $t4
add $t0, $t0, 1
add $t3, $t3,4

j loop
end:
addi $v0, $0, 4
la $a0,msg
syscall
addi $v0, $0, 1
add $a0, $t1, $0
syscall
li $v0,10
syscall
