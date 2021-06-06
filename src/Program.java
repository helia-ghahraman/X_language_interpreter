import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    static HashMap<String, Integer> intVariables = new HashMap<>();
    static HashMap<String, Float> floatVariables = new HashMap<>();
    static Integer lineNumber = 0;
    static Integer endLoopLineNumber = 0;
    //Main Method ... ********************************************************************
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("TextFiles//src5.txt");
        if (f.isDirectory()) {
            throw new IllegalArgumentException("there is a directory...");
        } else if (f.isFile()) {
            readFile(f);
        }

//        System.out.println(intVariables);
//        System.out.println(floatVariables);
//        System.out.println("***" + intVariables.get("sum"));

//        int & = 0;
//        System.out.println("****");
//        System.out.println(&);
    }

    //Other methods ... *******************************************************************
    private static void readFile(File f) throws FileNotFoundException {
        Boolean faz1 = true; //true -> faz1, false -> faz2
        Scanner sc = new Scanner(f);

        while (faz1) {
            String line = sc.nextLine();
            line.trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] tokens = line.split(" ");
//            System.out.println(Arrays.toString(tokens));
            if (tokens[0].equals("%%")) {
                faz1 = false; //jump to faz2
            } else if (tokens[0].equals("int")) {
                initIntVariable(tokens);
            } else if (tokens[0].equals("float")) {
                initFloatVariable(tokens);
            } else {
                throw new IllegalArgumentException("Illegal Data Type");
            }
        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] tokens = line.split(" ");
//            System.out.println(Arrays.toString(tokens));
            if (tokens.length == 5) {
                initAttributionProcess(tokens);
            } else if (tokens.length == 3) {
                defineProcess(tokens);
            } else if (tokens.length == 2) {
                initOthersProcess(tokens);
            }
        }
        sc.close();
    }

    private static void defineProcess(String[] tokens) {
        int intVar1 = 0, intVar2 = 0;
        float floatVar1 = 0, floatVar2 = 0;

        if (intVariables.containsKey(tokens[0]))
            intVar1 = intVariables.get(tokens[0]);
        else
            floatVar1 = floatVariables.get(tokens[0]);

        if (intVariables.containsKey(tokens[2]))
            intVar2 = intVariables.get(tokens[2]);
        else if (floatVariables.containsKey(tokens[2]))
            floatVar2 = floatVariables.get(tokens[2]);
        else
            floatVar2 = Float.parseFloat(tokens[2]);

        intVar1 = (int) (intVar2 + floatVar2);
        floatVar1 = intVar2 + floatVar2;

        if (intVariables.containsKey(tokens[0])) {
            intVariables.remove(tokens[0]);
            intVariables.put(tokens[0], intVar1);
        } else if (floatVariables.containsKey(tokens[0])) {
            floatVariables.remove(tokens[0]);
            floatVariables.put(tokens[0], floatVar1);
        }
    }

    private static void initOthersProcess(String[] tokens) {
        if (tokens[0].equals("for")) {
            //Todo write something here for Loop

        } else if (tokens[0].equals("print")) {
            printProcess(tokens);
        }
    }

    private static void printProcess(String[] tokens) {
        if (intVariables.containsKey(tokens[1]))
            System.out.println(intVariables.get(tokens[1]));

        else if (floatVariables.containsKey(tokens[1]))
            System.out.println(floatVariables.get(tokens[1]));
        else
            System.out.println(tokens[1]);
    }

    private static void initAttributionProcess(String[] tokens) {
        int intVar1 = 0, intVar2 = 0, intVar3 = 0;
        float floatVar1 = 0, floatVar2 = 0, floatVar3 = 0;


        if (intVariables.containsKey(tokens[0])) {
            intVar1 = intVariables.get(tokens[0]);
        } else {
            floatVar1 = floatVariables.get(tokens[0]);
        }

        if (intVariables.containsKey(tokens[2]))
            intVar2 = intVariables.get(tokens[2]);
        else if (floatVariables.containsKey(tokens[2]))
            floatVar2 = floatVariables.get(tokens[2]);
        else {
            floatVar2 = Float.parseFloat(tokens[2]);
        }

        if (intVariables.containsKey(tokens[4]))
            intVar3 = intVariables.get(tokens[4]);
        else if (floatVariables.containsKey(tokens[4]))
            floatVar3 = floatVariables.get(tokens[4]);
        else {
            floatVar3 = Float.parseFloat(tokens[4]);
        }


        if (tokens[3].equals("+")) {
            intVar1 = (int) (intVar2 + intVar3 + floatVar2 + floatVar3);
            floatVar1 = intVar2 + intVar3 + floatVar2 + floatVar3;

        } else if (tokens[3].equals("-")) {
            intVar1 = (int) (intVar2 - intVar3 + floatVar2 - floatVar3);
            floatVar1 = intVar2 - intVar3 + floatVar2 - floatVar3;

        } else if (tokens[3].equals("*")) {
            intVar1 = (int) ((intVar2 * intVar3) + (floatVar2 * floatVar3) + (intVar2 * floatVar3) + (floatVar2 * intVar3));
            floatVar1 = (intVar2 * intVar3) + (floatVar2 * floatVar3) + (intVar2 * floatVar3) + (floatVar2 * intVar3);

        } else if (tokens[3].equals("/")) {
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
        }

        if (intVariables.containsKey(tokens[0])) {
            intVariables.remove(tokens[0]);
            intVariables.put(tokens[0], intVar1);
        } else if (floatVariables.containsKey(tokens[0])) {
            floatVariables.remove(tokens[0]);
            floatVariables.put(tokens[0], floatVar1);
        }

    }

    private static void initFloatVariable(String[] tokens) {
        if (tokens.length == 4) {
            Variable variable3 = new Variable(tokens[1], Float.parseFloat(tokens[3]));
        } else {
            Variable variable4 = new Variable(tokens[0], tokens[1]);
        }
    }

    private static void initIntVariable(String[] tokens) {
        if (tokens.length == 4) {
            Variable variable1 = new Variable(tokens[1], Integer.parseInt(tokens[3]));
        } else {
            Variable variable2 = new Variable(tokens[0], tokens[1]);
        }
    }
}
