package Interpreter2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    static Integer lineNumber = 0;
    static String path = null;
    static ArrayList<String> codes = null;
    //Main Method ... ********************************************************************
    public static void main(String[] args) throws IOException {
        path = "TextFiles//src1.txt";
        File file = new File(path);
        if (file.isDirectory()) {
            throw new IllegalArgumentException("there is a directory...");
        } else if (file.isFile()) {
            readFile(file);
        }
    }
    //Other methods ... *******************************************************************
    public static void readFile(File f) throws IOException {
        Boolean faz1 = true; //true -> faz1, false -> faz2
        try {
            Scanner sc = new Scanner(f);
            while (faz1) {
                String line = sc.nextLine();
                lineNumber++;
                line.trim();
                if (line.isEmpty()) continue;
                String[] tokens = line.split(" ");
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
            //start faz2
            while (sc.hasNextLine()) {
                String line = null;
                line = sc.nextLine();
                lineNumber++;
                if (sc.hasNextLine() && line.isEmpty())continue;
                String[] tokens = line.split(" ");
                if (tokens[0].equals("for"))gotoEnd(path,sc);
                makeTokens(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void makeTokens(String line) throws IOException {
        String[] tokens = line.split(" ");
        switch (tokens.length) {
            case 5:
                Logic logic = new Logic(tokens);
                break;
            case 2:
                initOthersProcess(tokens);
                break;
            case 3:
                GiveValue giveValue = new GiveValue(tokens);
                break;
        }
    }

    public static void initOthersProcess(String[] tokens) throws IOException {
        if (tokens[0].equals("for")) {
            codes = new ArrayList();
            int start = Program.lineNumber;
            int finish = search(start, codes);
            Program.lineNumber=finish+1;
            System.out.println("start: " + start);
            System.out.println("finish: " + finish);
            Loop loop = new Loop(tokens, start, finish, codes);
        } else if (tokens[0].equals("print")) {
            Print print = new Print(tokens);
        }
    }

    private static int search(int start, ArrayList codes) throws IOException {
        String line = null;
        int forCounter = 0;
        int endCounter = 0;
        int conuter = start+1;
        boolean sw = true;
        String[] array = null;
        while (sw) {
            line = Program.getLine(conuter, Program.path);
            array = line.split(" ");
            if (array[0].equals("for")) forCounter++;
            else if (array[0].equals("end") && (endCounter < forCounter)) endCounter++;
            else if (array[0].equals("end") && (endCounter == forCounter)) return (conuter - 1);

            codes.add(line);
            conuter++;
        }
        return 0;
    }
    public static String getLine(int lineNum, String path) throws IOException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        for (int i = 0; i < lineNum - 1; i++) {
            bufferedReader.readLine();
        }
        line = bufferedReader.readLine();
        return line;
    }
    public static void gotoEnd(String path, Scanner sc) throws IOException {
        String line=null;
        int forCount=1;
        int endCount=0;
        String[]tokens = null;
        while (sc.hasNextLine()){
            line=sc.nextLine();
            tokens = line.split(" ");
            if (tokens[0].equals("for")) forCount++;
            if (tokens[0].equals("end"))endCount++;
            if (endCount>=forCount)break;
            //System.out.println("line: "+line);
        }
    }
}
