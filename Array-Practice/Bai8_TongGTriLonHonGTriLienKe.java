import java.util.Scanner;

/**
 * Bài 8
 * Tạo ngẫu nhiên mảng 1 chiều n phần tử nguyên có giá trị chứa trong đoạn [-1000, 1000]
 * Tính tổng các giá trị lớn hơn trị tuyệt đối của giá trị đứng liền sau nó trong mảng 1 chiều
 */

public class Bai8_TongGTriLonHonGTriLienKe {
    
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

    //Hàm tính tổng các giá trị lớn hơn trị tuyệt đối của giá trị đứng liền sau nó 
    public static int tinhTong(int a[]) {
        int tong = 0; 
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > Math.abs(a[i+1])) {
                tong += a[i]; 
            }
        }
        return tong; 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        xuatMang(a);
        int tong = tinhTong(a);
        if (tong == 0) {
            System.out.println("Không có giá trị nào lớn hơn trị tuyệt đối của giá trị đứng liền kề sau nó trong mảng này.");
        } else {
            System.out.println("Tổng của các giá trị lớn hơn trị tuyệt đối của giá trị đứng liền sau nó là: " + tong);
        }
    }
}
