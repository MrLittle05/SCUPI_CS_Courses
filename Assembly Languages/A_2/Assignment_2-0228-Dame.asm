.data
matrix: .word 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12  
success: .asciiz "Success"
fail: .asciiz "Fail"

.text
.globl main
main:
    la $a0, matrix         # Load base address of matrix into $a0
    li $a1, 1              
    li $a2, 2              
    li $a3, 4              

    jal calc_elem_add      
   
    move $t0, $v0       
    li $t1, 24
    add $t1, $t1 ,$a0     
    bne $t0, $t1, error    # Goto error label if values do not match

    la $a0, success
    li $v0, 4              # System call code for print string
    syscall

    li $v0, 11             # System call code for print character
    li $a0, 10             # ASCII code for newline character: 10
    syscall            

    move 	$a0, $t0	
    li $v0, 1
    syscall   

    li $v0, 11           
    li $a0, 10        
    syscall            

    move $a0, $t1
    li $v0, 1
    syscall   

    li $v0, 10
    syscall

error:
    la $a0, fail
    li $v0, 4            
    syscall

    li $v0, 11            
    li $a0, 10             
    syscall            

    move $a0, $t0		
    li $v0, 1
    syscall   

    li $v0, 11            
    li $a0, 10          
    syscall            

    move $a0, $t1
    li $v0, 1
    syscall   

    li $v0, 10
    syscall


calc_elem_add:
  mult	$a1, $a3	
  mflo  $v0		
  add		$v0, $v0, $a2
  sll   $v0, $v0, 2
  add   $v0, $a0, $v0
  jr		$ra			