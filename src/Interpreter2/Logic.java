package Interpreter2;

import java.io.IOException;
import java.util.ArrayList;

public class Logic extends Statement {
    static ArrayList<String> codes = null;

    public Logic(String[] tokens) throws IOException {
        execute(tokens);
    }

    //Methods *****************************************


    public static void initAttributionProcess(String[] tokens) {
        float var1 = 0, var2 = 0, var3 = 0;

        if (Variable.intVariables.containsKey(tokens[0])) {
            var1 = (float) Variable.intVariables.get(tokens[0]);
        } else if (Variable.floatVariables.containsKey(tokens[0])) {
            var1 = Variable.floatVariables.get(tokens[0]);
        } else {
            throw new IllegalArgumentException("Wrong Variable name!");
        }

        if (Variable.intVariables.containsKey(tokens[2])) {
            var2 = (float) Variable.intVariables.get(tokens[2]);
        } else if (Variable.floatVariables.containsKey(tokens[2])) {
            var2 = Variable.floatVariables.get(tokens[2]);
        } else {
            var2 = Float.parseFloat(tokens[2]);
        }

        if (Variable.intVariables.containsKey(tokens[4])) {
            var3 = (float) Variable.intVariables.get(tokens[4]);
        } else if (Variable.floatVariables.containsKey(tokens[4])) {
            var3 = Variable.floatVariables.get(tokens[4]);
        } else {
            var3 = Float.parseFloat(tokens[4]);
        }

        switch (tokens[3]) {
            case "+":
                var1 = var2 + var3;
                break;
            case "-":
                var1 = var2 - var3;
                break;
            case "*":
                var1 = var2 * var3;
                break;
            case "/":
                var1 = var2 / var3;
                break;
        }

        if (Variable.intVariables.containsKey(tokens[0])) {
            Variable.intVariables.remove(tokens[0]);
            int intVar1 = (int) var1;
            Variable.intVariables.put(tokens[0], intVar1);
        } else if (Variable.floatVariables.containsKey(tokens[0])) {
            Variable.floatVariables.remove(tokens[0]);
            Variable.floatVariables.put(tokens[0], var1);
        }

    }

    public void initOthersProcess(String[] tokens) throws IOException {
        if (tokens[0].equals("for")) {
            codes = new ArrayList();
            int start = Program.lineNumber;
            int finish = search(start, codes);
            System.out.println("start: " + start);
            System.out.println("finish: " + finish);
            Loop loop = new Loop(tokens, start, finish, codes);
        } else if (tokens[0].equals("print")) {
            Print print = new Print(tokens);
        }
    }

    @Override
    public void execute(String[] tokens) throws IOException {
        if (tokens.length == 5) {
            initAttributionProcess(tokens);
        } else if (tokens.length == 2) {
            initOthersProcess(tokens);
        }
    }


    private int search(int start, ArrayList codes) throws IOException {
        String line = null;
        int forCounter = 0;
        int endCounter = 0;
        int conuter = start;
        boolean sw = true;
        String[] array = null;
        while (sw) {
            line = Program.getLine(conuter, Program.path);
            array = line.split(" ");

            if (array[0].equals("for")) {
                forCounter++;
            } else if (array[0].equals("end") && (endCounter < forCounter)) {
                endCounter++;
            } else if (array[0].equals("end") && (endCounter == forCounter)) {
                sw = false;
                return (conuter - 1);
            }

            codes.add(line);
            conuter++;
        }
        return 0;
    }
}
