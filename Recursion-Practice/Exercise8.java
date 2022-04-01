import java.util.Scanner;

/**
 * Exercise 8 
 * Count the number of digits of the positive integer n 
 */
public class Exercise8 {

    //Enter n is a positive integer number
    public static int enterN(Scanner scan) {
        int n; 
        do {
            System.out.print("Enter n > 0: ");
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    //Count the number of digits 
    public static int countDigits(int n) {
        if (n < 10) {
            return 1;
        }
        return 1 + countDigits(n/10); 
    }
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = enterN(scan);
        System.out.print("\nThe result is: ");
        System.out.println(countDigits(n));
    }
    
}