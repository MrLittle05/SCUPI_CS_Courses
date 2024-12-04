.data
    .align 2
    a: .word 10          
    b: .word 5           
    c: .word 15          

    .align 1
    d: .half 3           
    e: .half 2           
    f: .half 7           

    .align 0
    g: .byte 4           
    h: .byte 2           
    i: .byte 6           


.text
.globl main
    main:
        lw $t0, c       
        lw $t1, b       
        sub $t2, $t0, $t1 
        sw $t2, a       
        la $a0, a        
        li $v0, 1      
        syscall        

        lh $t3, f        
        lh $t4, e        
        sub $t5, $t3, $t4 
        sh $t5, d        
        la $a0, d       
        li $v0, 1       
        syscall         

        lb $t6, i        
        lb $t7, h       
        sub $t8, $t6, $t7 
        sb $t8, g       
        la $a0, g        
        li $v0, 1     
        syscall        
   
        li $v0, 10       
        syscall          