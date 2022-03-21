import java.util.Scanner;

/**
 * Bài 6
 * Tạo ngẫu nhiên mảng một chiều n phần tử nguyên có giá trị chứa trong đoạn [-1000, 1000]. 
 * Tính tổng các giá trị dương trong mảng 1 chiều các số thực 
 */

public class Bai6_TinhTongGTriDuong {
    
    //Constants 
    final static short MAX = 1000;
    final static short MIN = -1000; 

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

    //Hàm tính tổng giá trị dương trong mảng 
    public static int tinhTongGTriDuong(int a[]) {
        int tong = 0; 
        for (int item : a) {
            if (item > 0) {
                tong += item; 
            }
        }
        return tong; 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        xuatMang(a);
        int tong = tinhTongGTriDuong(a);
        if (tong == 0) {
            System.out.println("Không có giá trị dương trong mảng này.");
        } else {
            System.out.println("Tổng các giá trị dương trong mảng là: " + tong);

        }
    }
}


