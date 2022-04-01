import java.util.Scanner;

/**
 * Exercise 7
 * Calculate S(n) = 1 + 1/(1+2) + 1/(1+2+3) + ... + 1/(1+2+...+n)
 */

public class Exercise7 {
    
    //Enter n > 0
    public static int enterN(Scanner scan) {
        int n;
        do {
            System.out.print("Enter n > 0: ");
            n = Integer.parseInt(scan.nextLine()); 
        } while (n < 1);
        return n; 
    }

    //Sum of all numbers from 1 to n 
    public static int sumOfNumsFrom1ToN(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfNumsFrom1ToN(n-1); 
    }

    //Calculate S(n)
    public static double calculateSum(int n) {
        if (n == 1) {
            return 1;
        }
        return (float) 1/(sumOfNumsFrom1ToN(n)) + calculateSum(n - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = enterN(scan);
        System.out.print("\nThe result is: ");
        System.out.printf("%.2f", calculateSum(n));
        System.out.println("\n");
    }
}
