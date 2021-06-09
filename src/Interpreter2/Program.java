package Interpreter2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
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
    }

    //Other methods ... *******************************************************************
    public static void readFile(File f)  {
        Boolean faz1 = true; //true -> faz1, false -> faz2
        try {
            Scanner sc = new Scanner(f);
            while (faz1) {
                String line = sc.nextLine();
                line.trim();
                if (line.isEmpty()) continue;
                String[] tokens = line.split(" ");
//            System.out.println(Arrays.toString(tokens));
                switch (tokens[0]) {
                    case "%%":
                        faz1 = false; //jump to faz2
                        break;
                    case "int":
                    case "float":
                        GiveValue giveValue = new GiveValue(tokens);
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal Data Type");
                }
            }
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isEmpty()) continue;
                String[] tokens = line.split(" ");
//            System.out.println(Arrays.toString(tokens));
                switch (tokens.length) {
                    case 5:
                    case 2:
                        Logic logic = new Logic(tokens);
                        break;
                    case 3:
                        GiveValue giveValue = new GiveValue(tokens);
                        break;
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
