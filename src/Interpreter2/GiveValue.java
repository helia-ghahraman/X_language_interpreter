package Interpreter2;

public class GiveValue extends Statement {

    public GiveValue(String[] tokens) {
        execute(tokens);
    }

    //Methods ***********************************************************
    public static void initIntVariable(String[] tokens) {
        if (tokens.length == 4) {
            if (Variable.intVariables.containsKey(tokens[3])) {
                Variable variable3 = new Variable(tokens[1], Variable.intVariables.get(tokens[3]));
                //Todo add try & catch
            } else {
                Variable variable3 = new Variable(tokens[1], Integer.parseInt(tokens[3]));
            }
        } else {
            Variable variable2 = new Variable(tokens[0], tokens[1]);
        }
    }

    public static void initFloatVariable(String[] tokens) {
        if (tokens.length == 4) {
            if (Variable.floatVariables.containsKey(tokens[3])) {
                Variable variable3 = new Variable(tokens[1], Variable.floatVariables.get(tokens[3]));
                //Todo add try & catch
            } else {
                Variable variable3 = new Variable(tokens[1], Float.parseFloat(tokens[3]));
            }
        } else {
            Variable variable4 = new Variable(tokens[0], tokens[1]);
        }
    }

    public static void defineProcess(String[] tokens) {
        float floatVar1 = 0, floatVar2 = 0;

        try {
            if (Variable.intVariables.containsKey(tokens[0]))
                floatVar1 = Variable.intVariables.get(tokens[0]);
            else if (Variable.floatVariables.containsKey(tokens[0]))
                floatVar1 = Variable.floatVariables.get(tokens[0]);


            if (Variable.intVariables.containsKey(tokens[2]))
                floatVar2 = Variable.intVariables.get(tokens[2]);
            else if (Variable.floatVariables.containsKey(tokens[2]))
                floatVar2 = Variable.floatVariables.get(tokens[2]);
            else
                floatVar2 = Float.parseFloat(tokens[2]);

            //Todo add try & catch

            floatVar1 = floatVar2;

            if (Variable.intVariables.containsKey(tokens[0])) {
                Variable.intVariables.remove(tokens[0]);
                Variable.intVariables.put(tokens[0], (int) floatVar1);
            } else if (Variable.floatVariables.containsKey(tokens[0])) {
                Variable.floatVariables.remove(tokens[0]);
                Variable.floatVariables.put(tokens[0], floatVar1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void execute(String[] tokens) {
        switch (tokens[0]) {
            case "int":
                initIntVariable(tokens);
                break;
            case "float":
                initFloatVariable(tokens);
                break;
            default:
                defineProcess(tokens);
                break;
        }
    }
}