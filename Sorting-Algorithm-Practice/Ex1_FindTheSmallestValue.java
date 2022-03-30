import java.util.Scanner;

/**
 * Bài 1
 * Tìm 1 vị trí mà giá trị tại vị trí đó là giá trị nhỏ nhất trong mảng 1 chiều các số thực 
 */

public class Ex1_FindTheSmallestValue {

    final static byte MAX = 100; 
    final static byte MIN = -100; 

    //Create n 
    public static int inputN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine()); 
        } while (n < 1);
        return n; 
    }

    //Array input 
    public static int[] createArray(int n) {
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = MIN + (int) + (Math.random() * ((MAX - MIN) + 1));
        }
        return array; 
    }

    //Array output 
    public static void arrayOutput(int[] array) {
        for (int item : array) {
            System.out.print(item + "\t");
        }
        System.out.print("\n");
    }

    //Find a position that has the smallest value in the array 
    public static void findTheSmallestValue(int[] array) {
        int minValue = array[0]; 
        int index = 0; 
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                index = i; 
            }
        }
        System.out.println("The position having the smallest value is at array[" + index + "] = " + minValue);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n > 0: ");
        int n = inputN(scan);
        int array[] = createArray(n); 
        arrayOutput(array);
        findTheSmallestValue(array);
    }
    
}
