import java.util.Scanner;

/**
 * Exercise 1
 * Calculate: sum of T(n) = 1/2 + 2/3 + 3/4 + ... + n/(n+1)
 */
public class Exercise1 {
    
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
        return (float) n/(n+1) + sumOfFractions(n-1); 
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
