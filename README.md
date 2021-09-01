# Simple-Compiler
Final Project for the second semester. This is a simple compiler that executes common commands from the Hypothetical language X that will be explained below.
The compiler must receive a text file containing the program written in the X language and execute it by interpreting it.The program in the X language consists of 2 parts, which are separated by a line containing %%.

1) The first part is for defining program variables. This section can contain no definition of any variables.Each variable is defined in one line. The definition of each variable includes the identifier of the variable type and
A variable name that is separated by one or more spaces. The variables of the variable type are int and
float. The variable name is also a valid identifier (based on the rules of the Java language). The initial value of a variable, as
The automaton is zero unless, in its definition, its initial value is declared, in which case the assignment operator with
The initial value of the variable is used.

2) The second part of the program contains the program commands. Each command generates and returns a value. Each command must be in an individual row of
The program.The types of commands that the interpreter is able to execute are as follows:

a) Addition command: It has two operands. Each of its two operands can be a numeric constant or a variable.

b) Subtraction command: It has two operands. Each of its two operands can be a numeric constant or a variable.

c) Multiplication command: It has two operands. Each of its two operands can be a numeric constant or a variable.

d) Split command: has two operands. Each of its two operands can be a numeric constant or a variable. Command
Divides the value of the left operand by the value of its right operand and the result as the output value.
Returns.

e) Print command: takes an operand. This command prints the value of its operand in the output.
 
f)Assignment command: Has two operands. The right operand is a literal integer, a variable
, or an arithmetic expression. The left operand of the assignment command is a variable. The assignment command evaluate the right and then copy its value to the left operand. Also because every command must have a value
the output value of the assignment command is equal to the value of the operand on its right.

g) For command : This command is used to simulate the control structure of the loop, in a very limited way. Its general shape
It is as follows:

for(Number of loop repetitions)

command1

command2

...

end for

# Example:
int x = 10

int y = 30

int z

int w = 50

float sum

%%

sum = x + y

sum = sum + w

print sum

print helloWorld

for 3

print w

end for
