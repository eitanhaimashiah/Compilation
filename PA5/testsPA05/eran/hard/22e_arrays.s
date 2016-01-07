.title	"22e_arrays.ic"

# global declarations
.global __ic_main

# data section
.data
.align 4

_DV_MainClass:	.long 

.int 6
str0:	.string "a = -3"
.int 10
str1:	.string "new int[a]"
.int 57
str2:	.string "Runtime error: Array allocation with negative array size!"
.int 34
str3:	.string "Should not print this or get here."

# text (code) section
.text

# -------------------
.align 4
__ic_main:
push %ebp	# prologue
mov %esp, %ebp
sub $16, %esp

mov $3, %eax	# Move 3,R1
mov %eax, -4(%ebp)

mov $0, %eax	# Move 0,R2
mov %eax, -8(%ebp)

mov -8(%ebp), %eax	# Sub R1,R2
Sub -4(%ebp), %eax
mov %eax, -8(%ebp)

mov -8(%ebp), %eax	# Move R2,R1
mov %eax, -4(%ebp)

mov -4(%ebp), %eax	# Move R1,var1_a
mov %eax, -16(%ebp)

mov $str0, %eax	# Move str0,R2
mov %eax, -8(%ebp)

# Library __println(R2),Rdummy
mov -8(%ebp), %eax
push %eax
call __println
add $4, %esp

mov $str1, %eax	# Move str1,R2
mov %eax, -8(%ebp)

# Library __println(R2),Rdummy
mov -8(%ebp), %eax
push %eax
call __println
add $4, %esp

mov -16(%ebp), %eax	# Move var1_a,R1
mov %eax, -4(%ebp)

mov -4(%ebp), %eax	# Mul 4,R1
mov $4, %ebx
mul %ebx
mov %eax, -4(%ebp)

mov -4(%ebp), %eax	# Compare 0,R1
cmp $0, %eax

JGE _end_label1

mov $str2, %eax	# Move str2,R1
mov %eax, -4(%ebp)

# Library __print(R1),Rdummy
mov -4(%ebp), %eax
push %eax
call __print
add $4, %esp

JMP _PROGRAM_END

_end_label1:

# Library __allocateArray(R1),R1
mov -4(%ebp), %eax
push %eax
call __allocateArray
add $4, %esp
mov %eax, -4(%ebp)

mov -4(%ebp), %eax	# Move R1,var2_arr
mov %eax, -12(%ebp)

mov $str3, %eax	# Move str3,R2
mov %eax, -8(%ebp)

# Library __println(R2),Rdummy
mov -8(%ebp), %eax
push %eax
call __println
add $4, %esp

_PROGRAM_END:

# Library __exit(0),Rdummy
mov $0, %eax
push %eax
call __exit
add $4, %esp

