.data
number: .word 1000
digit: .word 4
newline: .asciiz "\n"
space: .asciiz " "


.text
.globl main
main:
lw $a0,number
li $v0,1
syscall

la $a0,newline
li $v0,4
syscall

lw $a0,number
lw $a1,digit
jal get_bit
move $a0,$v0
li $v0,1
syscall

la $a0,newline
li $v0,4
syscall

lw $a0,number
lw $a1,digit
jal reset_bit
move $a0,$v0
li $v0,1
syscall

la $a0,newline
li $v0,4
syscall

lw $a0,number
lw $a1,digit
jal set_bit
move $a0,$v0
li $v0,1
syscall

la $a0,newline
li $v0,4
syscall

li $v0,10
syscall

get_bit:
srav $t0,$a0,$a1
andi $v0,$t0,1
jr $ra

set_bit:
li $t0,1
sllv $t0,$t0,$a1
or $v0,$a0,$t0
jr $ra

reset_bit:
li $t0,1
sllv $t0,$t0,$a1
not $t0,$t0
and $v0,$a0,$t0
jr $ra