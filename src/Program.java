import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

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
                if (line.isEmpty()) {
                    continue;
                }
                String[] tokens = line.split(" ");
                System.out.println(Arrays.toString(tokens));
                if (tokens[0].equals("%%")) {
                    faz1 = false; //jump to faz2
                } else if (tokens[0].equals("int")) {
                    if (tokens.length == 4) {
                        Variable variable1 = new Variable(tokens[1], Integer.parseInt(tokens[3]));
                    } else {
                        Variable variable2 = new Variable(tokens[0], tokens[1]);
                    }
                } else if (tokens[0].equals("float")) {
                    if (tokens.length == 4) {
                        Variable variable3 = new Variable(tokens[1], Float.parseFloat(tokens[3]));
                    } else {
                        Variable variable4 = new Variable(tokens[0], tokens[1]);
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
