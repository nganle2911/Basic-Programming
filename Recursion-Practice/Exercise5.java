import java.util.Scanner;

/**
 * Exercise 5
 * Calculate S(n) = 1/(1*2) + 1/(2*3) + ... + 1/n*(n-1)
 */
public class Exercise5 {
    
    //enter n >= 2 
    public static int enterN(Scanner scan) {
        int n; 
        do {
            System.out.print("Enter n >= 2: ");
            n = Integer.parseInt(scan.nextLine()); 
        } while (n < 2);
        return n; 
    }

    public static double sumOfFractions(int n) {
        if (n == 2) {
            return (float) 1/2; 
        }
        return (float) 1/(n*(n-1)) + sumOfFractions(n-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = enterN(scan);
        System.out.print(" \nThe result is: ");
        System.out.printf("%.2f", sumOfFractions(n));
        System.out.println("\n");
    }
}
