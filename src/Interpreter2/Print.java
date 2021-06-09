package Interpreter2;

public class Print extends Statement {
    public Print(String[] tokens) {
        execute(tokens);
    }

    //*********************************************************
    @Override
    public void execute(String[] tokens) {
        if (Variable.intVariables.containsKey(tokens[1]))
            System.out.println(Variable.intVariables.get(tokens[1]));

        else if (Variable.floatVariables.containsKey(tokens[1]))
            System.out.println(Variable.floatVariables.get(tokens[1]));
        else
            System.out.println(tokens[1]);
    }

}
