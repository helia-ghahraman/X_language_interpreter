package Interpreter2;

public class Process extends Choose {
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

}
