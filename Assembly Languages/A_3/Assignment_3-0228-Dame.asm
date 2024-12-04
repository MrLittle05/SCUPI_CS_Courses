.data
newline: .asciiz "\n"

.text
.globl main
main:
    li $a0, 3              
    li $a1, 2                
    jal get_bit            
    move $a0, $v0            
    li $v0, 1                
    syscall                  

    li $v0, 4
    la $a0, newline          
    syscall              

    li $a0, 5               
    li $a1, 1               
    jal set_bit              
    move $a0, $v0        
    li $v0, 1             
    syscall                

    li $v0, 4
    la $a0, newline         
    syscall              

    li $a0, 7              
    li $a1, 2              
    jal reset_bit            
    move $a0, $v0           
    li $v0, 1              
    syscall                  

    li $v0, 10           
    syscall


get_bit:
    li $t0, 1                
    sllv $t0, $t0, $a1       
    and $v0, $a0, $t0        
    srlv $v0, $v0, $a1       
    jr $ra                 


set_bit:
    li $t0, 1                
    sllv $t0, $t0, $a1       
    or $v0, $a0, $t0        
    jr $ra              


reset_bit:
    li $t0, 1            
    sllv $t0, $t0, $a1      
    not $t0, $t0            
    and $v0, $a0, $t0        
    jr $ra                   