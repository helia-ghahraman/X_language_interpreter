import java.io.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("TextFiles//src1.txt");
        Scanner sc = new Scanner(f);
        if (f.isDirectory()) {
            throw new IllegalArgumentException("there is a directory...");
        } else if (f.isFile()) {

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());

            }
        }

    }
}
