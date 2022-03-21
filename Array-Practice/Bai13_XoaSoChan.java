import java.util.Scanner;

/**
 * Bài 13
 * Xoá tất cả các số chẵn trong mảng 
 */

public class Bai13_XoaSoChan {
    
    final static int MAX = 1000; 
    final static int MIN = -1000; 

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

    //Hàm đếm số chẵn trong mảng 
    public static int demSoChan(int a[]) {
        int dem = 0; 
        for (int item : a) {
            if (item % 2 == 0) {
                dem++;
            }
        }
        return dem; 
    }

    //Hàm xoá các số chẵn trong mảng 
    public static int[] xoaSoChan(int a[]) {
        int dem = demSoChan(a);
        int b[] = new int[a.length - dem];
        int i = 0; 
        for (int item : a) {
            if (item % 2 != 0) {
                b[i] = item; 
                System.out.print(b[i] + "\t");
                i++; 
            }
        }
        a = b; 
        return a; 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        xuatMang(a);
        xoaSoChan(a); 
    }
}
