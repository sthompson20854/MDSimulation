import java.io.*;
import java.util.*;

public class Driver0 {
    public static double[][] array;
    public static int dimension1, dimension2;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Project 0.");
        System.out.println("What is the name of the data file? ");
        //String file = input.nextLine();
        readFile("/Users/steventhompson/Desktop/input.txt");
    }

    public static void readFile(String file) {
        try {
            Scanner sc = new Scanner(new File(file));
            dimension1 = 206;
            dimension2 = 9;
            array = new double[dimension1][dimension2];
            System.out.println("test2");
            while (sc.hasNext()) {
                for (int row = 0; row < dimension1; row++) {
                    System.out.println("test3");
                    for (int column = 0; column < dimension2; column++) {
                        array[row][column] = sc.nextDouble();
                        System.out.println("test4");
                        System.out.println(array[row][column]);
                    }
                    
                    System.out.println("test");
                }

            }
            sc.close();
        }

        catch (Exception e) {
            System.out
            .println("Error: file not found or insufficient     requirements.");
        }
    }
}