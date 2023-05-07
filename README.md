# X_language_interpreter
Final Project for the second semester. This is a simple compiler that executes common commands from the Hypothetical language X that will be explained below.
The compiler must receive a text file containing the program written in the X language and execute it by interpreting it.The program in the X language consists of 2 parts, which are separated by a line containing %%.

1) The first part is for defining program variables. This section can contain no definition of any variables.Each variable is defined in one line. The definition of each variable includes the identifier of the variable type and
A variable name that is separated by one or more spaces. The variables type are int and
float. The variable name is also a valid identifier (based on the rules of the Java language). The initial value of a variable, as
The automaton is zero unless, in its definition, its initial value is declared, in which case the assignment operator with
The initial value of the variable is used.

2) The second part of the program contains the program commands. Each command generates and returns a value. Each command must be in an individual row of
The program.The types of commands that the interpreter is able to execute are as follows:

a) Addition command: It has two operands. Each of its two operands can be a numeric constant or a variable.

b) Subtraction command: It has two operands. Each of its two operands can be a numeric constant or a variable.

c) Multiplication command: It has two operands. Each of its two operands can be a numeric constant or a variable.

d) Division command: has two operands. Each of its two operands can be a numeric constant or a variable. Command
Divides the value of the left operand by the value of its right operand and the result as the output value.
Returns.

e) Print command: takes an operand. This command prints the value of its operand in the output.
 
f)Assignment command: Has two operands. The right operand is a literal integer, a variable
, or an arithmetic expression. The left operand of the assignment command is a variable. The assignment command evaluate the right and then copy its value to the left operand. Also because every command must have a value
the output value of the assignment command is equal to the value of the operand on its right.

g) For command : This command is used to simulate the control structure of the loop, in a very limited way. Its general shape
is as follows:

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
# Preview
How the program looks like:

![compiler](https://user-images.githubusercontent.com/76126890/131711251-8825abc6-ce3c-4775-b20a-24de851b10d7.png)

You can choose a file from your system and compile it!

![choose](https://user-images.githubusercontent.com/76126890/131711300-32d0d61c-24c9-4d2d-8710-0c1288042a9b.png)

OR you can write the code right away and compile(the file will be saved!):

![write](https://user-images.githubusercontent.com/76126890/131711655-13162014-fa6f-4588-a6aa-2e20792c0cc5.png)

Then the result will be shown:

![result](https://user-images.githubusercontent.com/76126890/131711919-2d6d781d-7aa9-4ebd-9aaa-ddc705f3e69f.png)
# About us
![about](https://user-images.githubusercontent.com/76126890/131711985-71b4d3e6-7949-4839-9441-ce928f9d031d.png)
