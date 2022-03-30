import java.util.Scanner;

/**
 * Bài 5
 * Hãy tìm giá trị trong mảng các số thực gần giá trị x nhất.
 * x nhập từ bàn phím 
 */
public class Ex5_FindTheClosestValueToX {

    final static byte MAX = 100; 
    final static byte MIN = -100; 

    //Enter n > 0 - the length of array 
    public static int enterN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine()); 
        } while (n < 1);
        return n; 
    }

    //Create an array with the length of n 
    public static int[] createArrayA(int n) {
        int a[] = new int[n]; 
        for (int i = 0; i < n; i++) {
            a[i] = MIN + (int) + (Math.random() * ((MAX - MIN) + 1));
        }
        return a;
    }
    
    //Array output 
    public static void arrayOutput(int a[]) {
        for (int item : a) {
            System.out.print(item + "\t");
        }
        System.out.println("\n");
    }

    //Find the closest value to X 
    public static void findTheClosestValueToX(int a[], int x) {
        int shortestDistance = Math.abs(MAX - MIN);
        int closestValue = 0; 
        int index = 0; 
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i] - x) < shortestDistance) {
                shortestDistance = Math.abs(a[i] - x);
                closestValue = a[i]; 
                index = i; 
            }
        }
        System.out.println("The closest value to X = " + x + " is: a[" + index + "] = " + closestValue);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n > 0 - n is the length of array: ");
        int n = enterN(scan);
        int a[] = createArrayA(n);
        arrayOutput(a);
        System.out.print("Enter x: ");
        int x = Integer.parseInt(scan.nextLine());
        findTheClosestValueToX(a, x);
    }
}


