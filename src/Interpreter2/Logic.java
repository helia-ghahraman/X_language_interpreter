package Interpreter2;

public class Logic extends Statement {

    public Logic(String[] tokens) {
        execute(tokens);
    }

    //Methods *****************************************

    public static void initAttributionProcess(String[] tokens) {

        int intVar1 = 0, intVar2 = 0, intVar3 = 0;
        float floatVar1 = 0, floatVar2 = 0, floatVar3 = 0;


        if (Variable.intVariables.containsKey(tokens[0])) {
            intVar1 = Variable.intVariables.get(tokens[0]);
        } else {
            floatVar1 = Variable.floatVariables.get(tokens[0]);
        }

        if (Variable.intVariables.containsKey(tokens[2]))
            intVar2 = Variable.intVariables.get(tokens[2]);
        else if (Variable.floatVariables.containsKey(tokens[2]))
            floatVar2 = Variable.floatVariables.get(tokens[2]);
        else {
            floatVar2 = Float.parseFloat(tokens[2]);
        }

        if (Variable.intVariables.containsKey(tokens[4]))
            intVar3 = Variable.intVariables.get(tokens[4]);
        else if (Variable.floatVariables.containsKey(tokens[4]))
            floatVar3 = Variable.floatVariables.get(tokens[4]);
        else {
            floatVar3 = Float.parseFloat(tokens[4]);
        }

        switch (tokens[3]) {
            case "+":
                intVar1 = (int) (intVar2 + intVar3 + floatVar2 + floatVar3);
                floatVar1 = intVar2 + intVar3 + floatVar2 + floatVar3;
                break;
            case "-":
                intVar1 = (int) (intVar2 - intVar3 + floatVar2 - floatVar3);
                floatVar1 = intVar2 - intVar3 + floatVar2 - floatVar3;
                break;
            case "*":
                intVar1 = (int) ((intVar2 * intVar3) + (floatVar2 * floatVar3) + (intVar2 * floatVar3) + (floatVar2 * intVar3));
                floatVar1 = (intVar2 * intVar3) + (floatVar2 * floatVar3) + (intVar2 * floatVar3) + (floatVar2 * intVar3);
                break;
            case "/":

                if ((intVar2 != 0) && (intVar3 != 0)) {
                    intVar1 = intVar2 / intVar3;
                    floatVar1 = intVar1 / intVar2;
                } else if ((floatVar2 != 0) && (floatVar3 != 0)) {
                    intVar1 = (int) (floatVar2 / floatVar3);
                    floatVar1 = floatVar2 / floatVar3;
                } else if ((intVar2 != 0) && (floatVar3 != 0)) {
                    intVar1 = (int) (intVar2 / floatVar3);
                    floatVar1 = intVar2 / floatVar3;
                } else if ((floatVar2 != 0) && (intVar3 != 0)) {
                    intVar1 = (int) (floatVar2 / intVar3);
                    floatVar1 = floatVar2 / intVar3;
                }
                break;
        }

        if (Variable.intVariables.containsKey(tokens[0])) {
            Variable.intVariables.remove(tokens[0]);
            Variable.intVariables.put(tokens[0], intVar1);
        } else if (Variable.floatVariables.containsKey(tokens[0])) {
            Variable.floatVariables.remove(tokens[0]);
            Variable.floatVariables.put(tokens[0], floatVar1);
        }

    }

    public static void initOthersProcess(String[] tokens) {
        if (tokens[0].equals("for")) {
            Loop loop = new Loop(tokens);
        } else if (tokens[0].equals("print")) {
            Print print = new Print(tokens);
        }
    }


    @Override
    public void execute(String[] tokens) {
        if (tokens.length == 5) {
            initAttributionProcess(tokens);
        } else if (tokens.length == 2) {
            initOthersProcess(tokens);
        }
    }
}
