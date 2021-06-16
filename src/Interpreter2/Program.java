package Interpreter2;

import java.io.*;
import java.util.Scanner;

public class Program {
    static Integer lineNumber = 0;
    static String path = null;

    //Main Method ... ********************************************************************
    public static void main(String[] args) throws IOException {
        path = "TextFiles//src6.txt";
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
//                String line = getLine(lineNumber, path);
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
//                line = getLine(lineNumber, path);
                lineNumber++;
                if (sc.hasNextLine() && line.isEmpty()) continue;
                makeTokens(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void makeTokens(String line) throws IOException {
        String[] tokens = line.split(" ");
        lineNumber++;
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

    public static String getLine(int lineNum, String path) throws IOException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        for (int i = 0; i < lineNum - 1; i++) {
            bufferedReader.readLine();
        }
        line = bufferedReader.readLine();
        return line;
    }
}
