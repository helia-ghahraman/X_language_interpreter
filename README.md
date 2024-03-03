# X Language Interpreter

Welcome to the X Language Interpreter! This project serves as a straightforward compiler that executes common commands in the hypothetical language X, as detailed below.

## Usage

To utilize the compiler, provide a text file containing the X language program. The program is divided into two parts, separated by a line containing "%%".

### 1) Variable Definition
Define program variables in this section. Each variable is defined on a separate line, with the identifier of the variable type and variable name separated by one or more spaces. Variable types include `int` and `float`, and each variable follows the rules of a valid identifier in the Java language. Optionally, you can assign an initial value to a variable during its definition.

### 2) Program Commands
The second part contains program commands, each generating and returning a value. Each command must be on an individual line. The interpreter supports the following command types:

- **Addition Command:** Takes two operands, which can be numeric constants or variables.
  
- **Subtraction Command:** Similar to the addition command, it subtracts one operand from another.
  
- **Multiplication Command:** Multiplies two operands, which can be numeric constants or variables.
  
- **Division Command:** Divides the value of the left operand by the value of the right operand, returning the result.
  
- **Print Command:** Prints the value of its operand to the output.
  
- **Assignment Command:** Assigns a value to a variable. The right operand can be a literal integer, a variable, or an arithmetic expression. The output value of the assignment command is equal to the value of the operand on its right.
  
- **For Command:** Simulates a limited loop control structure. Specify the number of loop repetitions and include commands within the loop. End the loop section with `end for`.

## Example

```x
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
```
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
