import java.util.Scanner;

/**
 * Exercise 4
 * Calculate S(n) = 1/2 + 1/4 + 1/6 + ... + 1/2n
 */

public class Exercise4 {
    
    //Enter n > 0 
    public static int enterN(Scanner scan) {
        int n; 
        do {
            System.out.print("Enter n > 0: ");
            n = Integer.parseInt(scan.nextLine()); 
        } while (n < 1);
        return n; 
    }

    public static double sumOfFractions(int n) {
        if (n == 1) {
            return (float) 1/2;
        }

        return sumOfFractions(n - 1) + (float) 1 / (2 * n); 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = enterN(scan);
        System.out.print(" \nThe result is: ");
        System.out.printf("%.2f", sumOfFractions(n));
        System.out.println("\n");
    }
}
