import java.util.Scanner;

/**
 * Bài 4
 * Tìm số nguyên tố cuối cùng trong mảng 1 chiều các số nguyên 
 * Nếu mảng không có thì trả về -1 
 */
public class Ex4_FindTheLastPrimeNum {
    
    final static byte MAX = 100; 
    final static byte MIN = -100; 

    //Enter n > 0
    public static int enterN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine()); 
        } while (n < 1);
        return n; 
    }

    //Create an array 
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

    //To check if a number is a prime 
    public static boolean isAPrimeNum(int num) {
        boolean flag = true; //It's a prime number 
        if (num < 2) {
            flag = false; 
        } else if (num == 2) {
            flag = true; 
        } else {
            for (int i = 2; i < num - 1; i++) {
                if (num % i == 0) {
                    flag = false;
                    break; 
                }
            }
        }
        return flag; 
    }

    //To find the last prime number in the array 
    public static void findTheLastPrimeNum(int a[]) {
        boolean checkPrimeNum = false; 
        for (int i = a.length - 1; i >= 0; i--) {
            checkPrimeNum = isAPrimeNum(a[i]);
            if (checkPrimeNum) {
                System.out.println("The last prime number in this array is at: a[" + i + "] = " + a[i]);
                break;
            }
        }

        if (!checkPrimeNum) {
            System.out.println("-1 : not having any prime number in this array");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n > 0: ");
        int n = enterN(scan);
        int a[] = createArrayA(n);
        arrayOutput(a);
        findTheLastPrimeNum(a);
    }
}


