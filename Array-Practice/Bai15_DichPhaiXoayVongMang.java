import java.util.Scanner;

/**
 * Bài 15
 * Tạo ngẫu nhiên mảng một chiều n phần tử nguyên có giá trị chứa trong đoạn [-100, 100] và xuất mảng 
 * Hãy dịch phải xoay vòng mảng k lần, k do người dùng nhập vào 
 */

public class Bai15_DichPhaiXoayVongMang {
    
    final static int MAX = 100; 
    final static int MIN = -100; 

    //Hàm nhập n > 0 
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            System.out.print("Nhập n > 0: ");
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    //Hàm tạo mảng ngẫu nhiên 
    public static int[] taoMang(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1)); 
        }
        return a; 
    }

    //Hàm xuất mảng 
    public static void xuatMang(int a[]) {
        for (int item : a) {
            System.out.print(item + "\t");
        }
        System.out.println("\n");
    }

    //Hàm dịch phải xoay vòng mảng k lần, k do người dùng nhập vào 
    public static int[] xoayVongMang(int a[], Scanner scan) {
        System.out.print("Nhập k là số lần cần dịch chuyển: ");
        int k = Integer.parseInt(scan.nextLine());
        //int b[] = new int[a.length];
        for (int i = 1; i <= k; i++) {
            int b[] = new int[a.length];
            for (int j = 1; j < b.length; j++) {
                b[0] = a[a.length - 1];
                b[j] = a[j-1];
            }
            a = b; 
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        //int a[] = {4, -33, 36, -4, 12, 72, -9, -87, 76, -40};
        xuatMang(a);
        a = xoayVongMang(a, scan);
        xuatMang(a);
    }
}


