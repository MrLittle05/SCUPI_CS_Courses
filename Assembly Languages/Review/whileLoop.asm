.data
array: .half 1,2,3,4,5,6,7,8,9,10
space: .asciiz " "

.text
main:
li $t0,0
li $t1,10
la $t2,array
while:
bge $t0,$t1,exit
mul $t3,$t0,2
add $t3,$t3,$t2
lh $a0,0($t3)
li $v0,1
syscall

la $a0,space
li $v0,4
syscall

addi $t0,$t0,1
j while

exit:
li $v0,10
syscall