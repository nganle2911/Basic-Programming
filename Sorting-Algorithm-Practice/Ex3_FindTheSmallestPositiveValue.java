import java.util.Scanner;

/**
 * Bài 3
 * Hãy tìm vị trí giá trị dương nhỏ nhất trong mảng 1 chiều các số thực.
 * Nếu mảng không có giá trị dương thì trả về -1 
 */
public class Ex3_FindTheSmallestPositiveValue {
    
    final static byte MAX = 100; 
    final static byte MIN = -100; 

    //Enter n 
    public static int enterN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine()); 
        } while (n < 1);
        return n; 
    }

    //Create an array a 
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

    //Find the smallest positive value in the array a 
    public static void findTheSmallestPositiveValue(int a[]) {
        int minPositiveValue = MAX; 
        boolean flag = false; 

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                if (a[i] < minPositiveValue) {
                    minPositiveValue = a[i];
                    flag = true;  
                }
            }
        }

        if (flag) {
            System.out.print("The smallest positive values in this array are at: ");

            //If there are many smallest positive values in the array, list them all 
            for (int i = 0; i < a.length; i++) {
                if (a[i] == minPositiveValue) {
                    System.out.print("a[" + i + "] = " + minPositiveValue + "\t");
                }
            }
        } else {
            System.out.println("-1 : means not having any positive value in this array");
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n > 0: ");
        int n = Integer.parseInt(scan.nextLine());
        int a[] = createArrayA(n);
        //int a[] = {-15, 0, -75, 2, -2, -52, 2, 0, -31}; 
        arrayOutput(a);
        findTheSmallestPositiveValue(a);
        scan.close();
    }
}


