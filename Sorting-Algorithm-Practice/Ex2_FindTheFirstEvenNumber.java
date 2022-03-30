import java.util.Scanner;

/**
 * Bài 2
 * Tìm vị trí của giá trị chẵn đầu tiên trong mảng 1 chiều các số nguyên
 * Nếu mảng không có giá trị chẵn thì sẽ trả về -1 
 */
public class Ex2_FindTheFirstEvenNumber {
    
    final static byte MAX = -100; 
    final static byte MIN = 100; 

    //Enter n 
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
    public static void arrayOutput(int[] a) {
        for (int item : a) {
            System.out.print(item + "\t");
        }
        System.out.println("\n");
    }

    //Find position that includes the first even value in the array a 
    public static void findTheFirstEvenNum(int[] a) {
        int evenNum = a[0]; 
        int indexEvenNum = 0; 
        boolean flag = false; //not an even number 
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                evenNum = a[i];
                indexEvenNum = i; 
                flag = true; 
                break; 
            }
        }
        if (flag) {
            System.out.println("The first even value is at a[" + indexEvenNum + "] = " + evenNum);
        } else {
            System.out.println("-1 : means not having any even value in the array a");
        } 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n > 0: ");
        int n = enterN(scan); 
        int a[] = createArrayA(n);
        arrayOutput(a);
        findTheFirstEvenNum(a);
    }
}

