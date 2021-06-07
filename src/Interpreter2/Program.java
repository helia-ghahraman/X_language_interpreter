package Interpreter2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program extends Choose {
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
                Logic.initIntVariable(tokens);
            } else if (tokens[0].equals("float")) {
                Logic.initFloatVariable(tokens);
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
                Logic.initAttributionProcess(tokens);
            } else if (tokens.length == 3) {
                Process.defineProcess(tokens);
            } else if (tokens.length == 2) {
                Logic.initOthersProcess(tokens);
            }
        }
        sc.close();
    }

}
