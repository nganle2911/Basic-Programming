import java.util.Scanner;

/**
 * Exercise 2
 * Calculate R(n) = √n + √(n-1) + √(n-2) + ... + √1 
 */
public class Exercise2 {
    
    //Enter n > 0
    public static int enterN(Scanner scan) {
        int n; 
        do {
            System.out.print("Enter n > 0: ");
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    public static double calculateR(int n) {
        if (n == 1) {
            return Math.sqrt(1);
        }
        return (float) Math.sqrt(n + calculateR(n-1));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = enterN(scan);
        System.out.print(" \nThe result is: ");
        System.out.printf("%.2f", calculateR(n));
        System.out.println("\n");
    }
}
