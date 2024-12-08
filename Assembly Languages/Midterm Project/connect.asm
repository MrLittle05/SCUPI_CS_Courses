# Name: Dame Chen
# Student ID: 2023141520228

.data
grid: .byte 32:42 
borderL: .asciiz "|" 
borderR: .asciiz "|" 
underscore: .asciiz "_"
columnIndices: .asciiz " 0 1 2 3 4 5 6  \n"
bottom: .asciiz "\n___________________________________\n" 
newline: .asciiz "\n"
p1_prompt:	.asciiz "Player 1, it's your turn.\nSelect a column to play. Must be between 0 and 6:\n"
p2_prompt: .asciiz "Player 2, it's your turn.\nSelect a column to play. Must be between 0 and 6:\n"
p1:	.asciiz "*"
p2:	.asciiz "+"
space:	.asciiz " "
fullC:	.asciiz "The column you are trying to add to is full. Please enter a different number between 0 and 6: "
oOfR:	.asciiz "That play is invalid. Try again\nSelect a column to play. Must be between 0 and 6:\n "
start:	.asciiz "The board has been reset. A new game will be started."
p1Win: .asciiz "Congratulations player 1. You won!\n"
p2Win: .asciiz "Congratulations player 2. You won!\n"
newGame: .asciiz "Enter 1 if you would like to play again and 0 if you would like to quit: "


.text
main: 
     jal DisplayBoard
     la $a0, newline
     li $v0, 4
     syscall
	la $a0, p1_prompt
	li $v0, 4
	syscall 
	li $v0, 5
	syscall 
	
Loop:
     addi $s0, $v0, 1
	li $t0, 0
	li $t1, 8
	slt $t2, $s0, $t1
	beq $t2, $zero, outOfRange
	slt $t2, $t0, $s0
	beq $t2, $zero, outOfRange
	addi $s0, $s0, -1
	addi $s0, $s0, 35 
	lb $t0, space

loop:	
     lb $t1, grid($s0)
	beq $t0, $t1, addp1 
	addi $s0, $s0, -7 
	li $t2, -1
	slt $t2, $t2, $s0
	beq $t2, $zero, colFull
	j loop
		
addp1:
     lb $t0, p1
	sb $t0, grid($s0)
	jal DisplayBoard 
	lb $t0, p1
	jal WinCheck 
	add $s1, $s0, $zero
	la $a0, newline
	li $v0, 4
	syscall
	j p2_turn

p2_turn:
     la $a0, p2_prompt
     li $v0, 4
     syscall 
     li $v0, 5
     syscall 
     move $s0, $v0
     addi $s0, $s0, 35 
     lb $t0, space

p2_loop:
     lb $t1, grid($s0)
     beq $t0, $t1, addp2 
     addi $s0, $s0, -7 
     li $t2, -1
     slt $t2, $t2, $s0
     beq $t2, $zero, colFull
     j p2_loop
	
addp2:
     lb $t0, p2
	sb $t0, grid($s0)	
	lb $t0, p2
	jal WinCheck	
	j main
	
colFull:
	la $a0, fullC
	li $v0, 4
	syscall 
	li $v0, 5
	syscall 
	j Loop 

outOfRange:
	la $a0, oOfR
	li $v0, 4
	syscall 
	li $v0, 5
	syscall 
	j Loop 

resetBoard:
	lb $s0, space
	add $t0, $zero, $zero

rLoop:
     beq $t0, 42, rExit
	sb $s0, grid($t0)
	addi $t0, $t0, 1
	j rLoop

rExit:	
     la $a0, start
	li $v0, 4
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	j main

DisplayBoard:
     subu $sp, $sp, 4 
     sw $ra, ($sp)
     la $a0, columnIndices  
     li $v0, 4             
     syscall               
     add $t0, $zero, $zero 
   
while:
     beq $t0, 42, exit 
     la $a0, borderL 
     li $v0, 4
     syscall
     add $t1, $zero, $zero

row: beq $t1, 7, rowComplete 
     lb $a0, grid($t0)
     li $t2, 32
     beq $a0, $t2, printUnderscore
     li $v0, 11
     syscall
     j afterPrint

printUnderscore:
     li $a0, '_'
     li $v0, 11
     syscall
            
afterPrint:
     la $a0, borderR
     li $v0, 4
     syscall
     addi $t0, $t0, 1
     addi $t1, $t1, 1
     j row    
                
rowComplete: 
     la $a0, newline
     li $v0, 4
     syscall
     j while

exit:
     la $a0, bottom 
     li $v0, 4
     syscall
     lw $ra, ($sp)
     addu $sp, $sp, 4
     jr $ra

WinCheck:
     subu $sp, $sp, 4
     sw $ra, ($sp)
    
     add $t2, $zero, $t0 
     add $t0, $zero, $zero

     add $s1, $s0, $zero
     jal HorizontalRight
     addi $t0, $t0, -1
     add $s1, $s0, $zero
     jal HorizontalLeft
    
     add $s1, $s0, $zero
     add $t0, $zero, $zero
    
     add $s1, $s0, $zero
     jal VerticalDown
    
     add $t0, $zero, $zero
     add $s1, $s0, $zero
     jal DiagDownTop
    
     addi $t0, $t0, -1
     add $s1, $s0, $zero
     jal DiagDownBot
    
     add $t0, $zero, $zero
     add $s1, $s0, $zero
     jal DiagUpTop
    
     addi $t0, $t0, -1
     add $s1, $s0, $zero
     jal DiagUpBot
    
     lw $ra, ($sp)
     addu $sp, $sp, 4
     jr $ra
    
HorizontalRight:
     subu $sp, $sp, 4
     sw $ra, ($sp)

     addi $t6, $zero, 1
     addi $t5, $zero, 7
     slt $t4, $s1, $t5
     beq $t4, 1, CheckLoop

     addi $t5, $zero, 14
     slt $t4, $s1, $t5
     beq $t4, 1, CheckLoop

     addi $t5, $zero, 21
     slt $t4, $s1, $t5
     beq $t4, 1, CheckLoop

     addi $t5, $zero, 28
     slt $t4, $s1, $t5
     beq $t4, 1, CheckLoop

     addi $t5, $zero, 35
     slt $t4, $s1, $t5
     beq $t4, 1, CheckLoop

     addi $t5, $zero, 42
     slt $t4, $s1, $t5
     beq $t4, 1, CheckLoop

HorizontalLeft:
     subu $sp, $sp, 4
     sw $ra, ($sp)

     addi $t6, $zero, -1

     addi $t5, $zero, 7
     slt $t4, $s1, $t5
     subi $t5, $zero, 8
     beq $t4, 1, CheckLoop

     addi $t5, $zero, 14 
     slt $t4, $s1, $t5
     subi $t5, $zero, 8
     beq $t4, 1, CheckLoop

     addi $t5, $zero, 21
     slt $t4, $s1, $t5
     subi $t5, $zero, 8
     beq $t4, 1, CheckLoop

     addi $t5, $zero, 28
     slt $t4, $s1, $t5
     subi $t5, $zero, 8
     beq $t4, 1, CheckLoop

     addi $t5, $zero, 35
     slt $t4, $s1, $t5
     subi $t5, $zero, 8
     beq $t4, 1, CheckLoop

     addi $t5, $zero, 42
     slt $t4, $s1, $t5
     subi $t5, $zero, 8
     beq $t4, 1, CheckLoop

VerticalDown:        
     subu $sp, $sp, 4
     sw $ra, ($sp)
     li $t5, 42
     addi $t6, $zero, 7
     j CheckLoopVertD

DiagDownTop:        
     subu $sp, $sp, 4
     sw $ra, ($sp)
     li $t5, 42
     addi $t6, $zero, 8
     j CheckLoopVertD

DiagDownBot:        
     subu $sp, $sp, 4
     sw $ra, ($sp)
     li $t5, 0
     addi $t6, $zero, -8
     j CheckLoopVertU

DiagUpTop:        
     subu $sp, $sp, 4
     sw $ra, ($sp)
     li $t5, 42
     addi $t6, $zero, 6
     j CheckLoopVertD

DiagUpBot:        
     subu $sp, $sp, 4
     sw $ra, ($sp)
     li $t5, 0
     addi $t6, $zero, -6
     j CheckLoopVertU

CheckLoop: 
     beq $t0,4, p1WinExit
     beq, $s1, $t5, noHLwin
     lb $t3, grid($s1)
     bne $t3, $t2, noHLwin 
     addi $t0, $t0, 1
     add $s1, $s1, $t6
     j CheckLoop
      
CheckLoopVertD: 
     beq $t0, 4, p1WinExit
     slt $t4, $s1, $t5
     beq $t4, $zero, noVwin
     lb $t3, grid($s1)
     bne $t3, $t2, noVwin
     addi $t0, $t0, 1
     add $s1, $s1, $t6
     j CheckLoopVertD
    
CheckLoopVertU:
     beq $t0, 4, p1WinExit
     slt $t4, $t5, $s1
     beq $t4, $zero, noVwin
     lb $t3, grid($s1)
     bne $t3, $t2, noVwin
     addi $t0, $t0, 1
     add $s1, $s1, $t6
     j CheckLoopVertU
    
noHLwin:
     lw $ra, ($sp)
     addu $sp, $sp, 4 
     jr $ra
        
noVwin:
     lw $ra, ($sp)
     addu $sp, $sp, 4 
     jr $ra
          
p1WinExit:
     lb $t7, p2
     beq $t7, $t2, p2WinExit
     la $a0, p1Win
     li $v0, 4
     syscall   
     la $a0, newGame
     li $v0, 4
     syscall
     li $v0, 5
     syscall   
     bne $v0, $zero, resetBoard
     li $v0, 10
     syscall
 
p2WinExit:
     la $a0, p2Win
     li $v0, 4
     syscall  
     la $a0, newGame
     li $v0, 4
     syscall
     li $v0, 5
     syscall 
     bne $v0, $zero, resetBoard   
     li $v0, 10
     syscall