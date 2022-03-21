import java.util.Scanner;

/**
 * Bài 10
 * Tạo ngẫu nhiên mảng 1 chiều n phần tử nguyên có giá trị trong đoạn [-1000, 1000]
 * Tính trung bình cộng các giá trị lớn hơn giá trị x do người dùng nhập vào 
 */

public class Bai10_TBCongGTriLonHonX {
    
    final static short MAX = 1000;
    final static short MIN = -1000; 

    //Hàm nhập n > 0 (n là phần tử của mảng)
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            System.out.print("Nhập n > 0: ");
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1); 
        return n; 
    }

    //Hàm nhập x 
    public static int nhapX(Scanner scan) {
        int x; 
        System.out.print("Nhập vào một số nguyên x: ");
        x = Integer.parseInt(scan.nextLine());
        return x; 
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

    //Hàm tính trung bình cộng các giá trị lớn hơn giá trị x
    public static void tinhTBCongGTriLonHonX(int a[], int x) {
        int tong = 0; 
        int dem = 0; //dùng để đếm xem có bao nhiêu giá trị hợp lệ -> để tính trung bình cộng 
        float tbCong = 0; 

        for (int item : a) {
            if (item > x) {
                tong += item;
                dem++; 
            }
        }
        
        if (tong == 0 || dem == 0) {
            System.out.println("Không có giá trị nào trong mảng lớn hơn x, với x = " + x);
        } else {
            tbCong = (float) tong / (float) dem;
            System.out.println("Trung bình cộng các giá trị lớn hơn x, với x = " + x + " là: " + tbCong);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        //int a[] = {15, -20, 19, 50, -65};
        xuatMang(a);
        int x = nhapX(scan);
        tinhTBCongGTriLonHonX(a, x);
    }
}


