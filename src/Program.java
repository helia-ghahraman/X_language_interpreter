import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Program {
    static HashMap<String, Integer> intVariables = new HashMap<>();
    static HashMap<String, Float> floatVariables = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        Boolean faz1 = true; //true -> faz1, false -> faz2
        File f = new File("TextFiles//src1.txt");
        Scanner sc = new Scanner(f);
        if (f.isDirectory()) {
            throw new IllegalArgumentException("there is a directory...");
        } else if (f.isFile()) {
            while (faz1) {
                String line = sc.nextLine();
                String[] tokens = line.split(" ");
                System.out.println(Arrays.toString(tokens));
                if (tokens[0].equals("%%")) {
                    faz1 = false; //jump to faz2
                } else if (intVariables.containsKey(tokens[1]) || floatVariables.containsKey(tokens[1])) {
                    throw new IllegalArgumentException("Duplicate Variables name!");
                } else if (tokens[0].equals("int")) {
                    if (tokens.length == 4) {
                        intVariables.put(tokens[1], Integer.parseInt(tokens[3]));
                    } else {
                        intVariables.put(tokens[1], 0);
                    }
                } else if (tokens[1].equals("float")) {
                    if (tokens.length == 4) {
                        floatVariables.put(tokens[1], Float.parseFloat(tokens[3]));
                    } else {
                        floatVariables.put(tokens[1], (float) 0.0);
                    }

                } else {
                    throw new IllegalArgumentException("Illegal Data Type");
                }

            }
//            while (sc.hasNextLine()){}
        }
        System.out.println(intVariables);
        System.out.println(floatVariables);

    }
}
