import java.util.Scanner;

/**
 * Exercise 6
 * Calculate S(x,n) = x + x^2 + ... + x^n
 */
public class Exercise6 {
    
    //Enter x and n > 0 
    public static int enterNum(Scanner scan) {
        int num; 
        do {
            System.out.print("Enter a number > 0: ");
            num = Integer.parseInt(scan.nextLine()); 
        } while (num < 1);
        return num; 
    }

    //Calculate S(x,n)
    public static double calculateSumOfPower(int x, int n) {
        if (n == 1) {
            return x;
        }
        return Math.pow(x, n) + calculateSumOfPower(x, (n-1));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        System.out.println("Enter x > 0 - x is the base");
        int x = enterNum(scan);
        System.out.println("Enter n > 0 - n is the exponent");
        int n = enterNum(scan); 
        System.out.print(" \nThe result is: ");
        System.out.printf("%.0f", calculateSumOfPower(x, n));
        System.out.println("\n");
    }
}
