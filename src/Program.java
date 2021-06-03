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
        File f = new File("TextFiles//src1.txt");
        if (f.isDirectory()) {
            throw new IllegalArgumentException("there is a directory...");
        } else if (f.isFile()) {
            readFile(f);
        }
        System.out.println(intVariables);
        System.out.println(floatVariables);
    }

    //Other methods ... *******************************************************************
    private static void readFile(File f) throws FileNotFoundException {
        Boolean faz1 = true; //true -> faz1, false -> faz2
        Scanner sc = new Scanner(f);

        while (faz1) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] tokens = line.split(" ");
            System.out.println(Arrays.toString(tokens));
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
            System.out.println(Arrays.toString(tokens));
            if (tokens.length == 4) {
                initAttributionProcess(tokens);
            }
            if (tokens.length == 2) {
                initOthersProcess(tokens);
            }


        }


    }

    private static void initOthersProcess(String[] tokens) {
        if (tokens[0].equals("for")) {

        } else if (tokens[0].equals("print")) {

        }
    }

    private static void initAttributionProcess(String[] tokens) {
        if (tokens[3].equals("+")) {
        } else if (tokens[3].equals("-")) {

        } else if (tokens[3].equals("*")) {

        } else if (tokens[3].equals("/")) {

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

