.data
matrix: .word 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
newline: .asciiz "\n"
correct:.asciiz "Correct!"

.text
.globl main
main:
la $a0,matrix
li $v0,1
syscall

la $a0,newline
li $v0,4
syscall

la $a0,matrix
li $a1,3
li $a2,1
li $a3,4
jal calc_elem_add
move $t0,$v0
move $a0,$v0
li $v0,1
syscall

la $a0,newline
li $v0,4
syscall

lw $t1,0($t0)
li $t2,13
mul $t2,$t2,4
la $t3,matrix
add $t2,$t2,$t3
lw $t2,0($t2)

bne $t1,$t2,exit
la $a0,correct
li $v0,4
syscall
j exit

exit:
li $v0,10
syscall

calc_elem_add:
mul $t0,$a1,$a3
add $t0,$t0,$a2
mul $t0,$t0,4
move $t1,$a0
add $v0,$t0,$t1
jr $ra