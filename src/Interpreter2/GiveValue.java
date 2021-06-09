package Interpreter2;

public class GiveValue extends Statement {

    public GiveValue(String[] tokens) {
        execute(tokens);
    }

    //Methods ***********************************************************
    public static void initIntVariable(String[] tokens) {
        if (tokens.length == 4) {
            Variable variable1 = new Variable(tokens[1], Integer.parseInt(tokens[3]));
        } else {
            Variable variable2 = new Variable(tokens[0], tokens[1]);
        }
    }

    public static void initFloatVariable(String[] tokens) {
        if (tokens.length == 4) {
            Variable variable3 = new Variable(tokens[1], Float.parseFloat(tokens[3]));
        } else {
            Variable variable4 = new Variable(tokens[0], tokens[1]);
        }
    }

    public static void defineProcess(String[] tokens) {
        int intVar1 = 0, intVar2 = 0;
        float floatVar1 = 0, floatVar2 = 0;

        if (Variable.intVariables.containsKey(tokens[0]))
            intVar1 = Variable.intVariables.get(tokens[0]);
        else
            floatVar1 = Variable.floatVariables.get(tokens[0]);

        if (Variable.intVariables.containsKey(tokens[2]))
            intVar2 = Variable.intVariables.get(tokens[2]);
        else if (Variable.floatVariables.containsKey(tokens[2]))
            floatVar2 = Variable.floatVariables.get(tokens[2]);
        else
            floatVar2 = Float.parseFloat(tokens[2]);

        intVar1 = (int) (intVar2 + floatVar2);
        floatVar1 = intVar2 + floatVar2;

        if (Variable.intVariables.containsKey(tokens[0])) {
            Variable.intVariables.remove(tokens[0]);
            Variable.intVariables.put(tokens[0], intVar1);
        } else if (Variable.floatVariables.containsKey(tokens[0])) {
            Variable.floatVariables.remove(tokens[0]);
            Variable.floatVariables.put(tokens[0], floatVar1);
        }
    }

    @Override
    public void execute(String[]tokens) {
        switch (tokens[0]) {
            case "int":
                initIntVariable(tokens);
                break;
            case "float":
                initFloatVariable(tokens);
                break;
            default:
                defineProcess(tokens);
        }
    }
}
