import java.util.Scanner;

/**
 * Exercise 3
 * Calculate S(n) = 1 + 1/2 + 1/3 + ... + 1/n 
 */
public class Exercise3 {

    //Enter n > 0
    public static int enterN(Scanner scan) {
        int n; 
        do {
            System.out.print("Enter n > 0: ");
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    public static float sumOfFractions(int n) {
        if (n == 1) {
            return 1;
        }
        return (float) 1/n + sumOfFractions(n-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = enterN(scan);
        System.out.print(" \nThe result is: ");
        System.out.printf("%.2f", sumOfFractions(n));
        System.out.println("\n");
        scan.close();
    }
    
}


