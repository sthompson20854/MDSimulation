import java.io.*;
import java.util.*;

public class Driver0 {
    public static double[][] array;
    public static int dimension1, dimension2;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        readFile("/Users/steventhompson/Desktop/input.txt");
    }

    public static void readFile(String file) {
        try {
            Scanner sc = new Scanner(new File(file));
            dimension1 = sc.nextInt();
            dimension2 = 9;
            array = new double[dimension1][dimension2];
           
            while (sc.hasNext()) {
                for (int row = 0; row < dimension1; row++) {
                    
                    for (int column = 0; column < dimension2; column++) {
                        array[row][column] = sc.nextDouble();
                        
                        System.out.print(array[row][column] + " ");
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