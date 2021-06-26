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
        path = "TextFiles//src6.txt";
        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("File does not exist!");
        } else {
            if (file.isDirectory()) {
                throw new IllegalArgumentException("there is a directory...");
            } else if (file.isFile()) {
                readFile(file);
            }
        }
    }

    //Other methods ... *******************************************************************
    public static void readFile(File f) throws IOException {
        Boolean faz1 = true; //true -> faz1, false -> faz2
        Scanner sc = new Scanner(f);
        try {
            while (faz1) {
                String line = sc.nextLine();
                lineNumber++;
                line = line.trim();
                if (line.isEmpty()) continue;
                line = line.replaceAll(" +", " ");
                String[] tokens = line.split(" ");
                if (tokens[0].equals("%%")) {
                    faz1 = false; //jump to faz2
                } else {
                    GiveValue giveValue = new GiveValue(tokens);
                }
            }
            //start faz2
            while (sc.hasNextLine()) {
                String line = null;
                line = sc.nextLine();
                lineNumber++;
                if (sc.hasNextLine() && line.isEmpty()) continue;
                line = line.trim();
                line = line.replaceAll(" +", " ");
                String[] tokens = line.split(" ");
                if (tokens[0].equals("for")) gotoEnd(sc);
                makeTokens(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static void makeTokens(String line) throws IOException {
        line = line.trim();
        line = line.replaceAll(" +", " ");
        String[] tokens = line.split(" ");
        switch (tokens.length) {
            case 5:
                Logic logic = new Logic(tokens);
                break;
            case 2:
                choose(tokens);
                break;
            case 3:
                GiveValue giveValue = new GiveValue(tokens);
                break;
            default:
//                throw new IllegalArgumentException("lines length is not valid (at line: " + lineNumber + ") " + "--- The program is Stopped.");
                System.err.println("lines length is not valid (at line: " + lineNumber + ") " + "--- The program is Stopped.");
        }
    }

    public static int choose(String[] tokens) throws IOException {
        String pattern = "[1-9]+[0]*";
        if (tokens[0].equals("for")) {
            if (tokens[1].matches(pattern)) {
                codes = new ArrayList();
                int start = Program.lineNumber;
                int finish = search(start, codes);
                Program.lineNumber = finish + 1;
                System.out.println("start: " + start);
                System.out.println("finish: " + finish);
                Loop loop = new Loop(tokens, start, finish, codes);
            } else {
//               throw new IllegalArgumentException("Loop counter is NOT valid (at line" + lineNumber+ ")");
                System.err.println("Loop counter is NOT valid (at line: " + lineNumber + ") " + "--- The program is Stopped.");
            }
        } else if (tokens[0].equals("print")) {
            Print print = new Print(tokens);
            return print.getCharNumber();
        } else {
            throw new IllegalArgumentException("Line does not make sense (" + "at line: " + lineNumber + ")");
        }
        return 0;
    }

    private static int search(int start, ArrayList codes) throws IOException {
        String line = null;
        int forCounter = 0;
        int endCounter = 0;
        int counter = start + 1;
        boolean sw = true;
        String[] array = null;
        while (sw) {
            line = Program.getLine(counter);
            line = line.trim();
            line = line.replaceAll(" +", " ");
            array = line.split(" ");
            if (array[0].equals("for"))
                forCounter++;
            else if (array[0].equals("end") && (endCounter < forCounter))
                endCounter++;
            else if (array[0].equals("end") && (endCounter == forCounter))
                return (counter - 1);
            codes.add(line);
            counter++;

            //Todo if "end fore" was missing
//            if ((forCounter > endCounter) && line == null){
////                System.err.println("Loop does not have an 'end for'");
////                throw new IllegalArgumentException("Loop does not have an 'end for'");
//            }
        }
        return 0;
    }

    public static String getLine(int lineNum) throws IOException {
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            for (int i = 0; i < lineNum - 1; i++) {
                bufferedReader.readLine();
            }
            line = bufferedReader.readLine();
            return line;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void gotoEnd(Scanner sc) {
        String line = null;
        int forCount = 1;
        int endCount = 0;
        String[] tokens = null;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            line = line.trim();
            line = line.replaceAll(" +", " ");
            tokens = line.split(" ");
            if (tokens[0].equals("for")) forCount++;
            if (tokens[0].equals("end")) endCount++;
            if (endCount >= forCount) break;
        }
    }
}
