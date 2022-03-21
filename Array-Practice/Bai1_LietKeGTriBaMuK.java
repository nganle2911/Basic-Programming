import java.util.Scanner;
/**
 * Bài 1
 * Cho mảng 1 chiều số nguyên
 * Hãy liệt kê các giá trị trong mảng có dạng 3^k
 * Nếu mảng không có giá trị đó thì trả về 0 
 */
public class Bai1_LietKeGTriBaMuK {

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

    //Create a random array having n items
    public static int[] createArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
        }
        return a;
    }

    //Ouput the array 
    public static void outputArray(int a[]) {
        for (int item : a) {
            System.out.print(item + "\t");
        }
        System.out.println("\n");
    }

    //Check if a number is as 3 power k 
    public static boolean checkNumAs3PowerK(int num) {
        boolean flag = false; //this num is not a num of 3^k 
        if (num < 2) {
            flag = false;
            return flag;  
        } 
        do {
            if ((num % 3) != 0) {
                flag = false;
                break; 
            } else {
                num /= 3; 
                flag = true; 
            }
        } while (num > 1);
        return flag;
    }

    //List the values as 3 power k 
    public static void listValuesAs3PowerK(int a[]) {
        boolean is3PowerK = false; //this flag is used to check if a number is 3^k 
        boolean flag = false; //this flag is used to check if having any values of 3^k in the array, if not, print 0  
        for (int i = 0; i < a.length; i++) {
            is3PowerK = checkNumAs3PowerK(a[i]);
            if (is3PowerK) {
                System.out.print(a[i] + "\t");
                flag = true; 
            }
        }
        if (!flag) {
            System.out.println("0 - not having any values as 3 power k in this array");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n > 0: ");
        int n = enterN(scan);
        int a[] = createArray(n);
        //int a[] = {61, -9, -27, 27, 81, 15};
        outputArray(a);
        System.out.println("The values as 3 power k are: ");
        listValuesAs3PowerK(a);
        
    }

}

