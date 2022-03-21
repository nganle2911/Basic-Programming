import java.util.Scanner;

/**
 * Bài 9
 * Tạo ngẫu nhiên mảng 1 chiều n phần tử nguyên có giá trị trong đoạn [-1000, 1000]
 * Tính trung bình cộng các số nguyên tố trong mảng 1 chiều các số nguyên  
 */

public class Bai9_TBCongSoNguyenTo {
    
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

    //Hàm kiểm tra một số có phải là số nguyên tố 
    public static boolean soNguyenTo(int x) {
        boolean flag = true; //là số nguyên tố
        if (x < 2) {
            flag = false; 
        } else if (x == 2) {
            flag = true; 
        } else {
            for (int i = 2; i < x - 1; i++) {
                if (x % i == 0) {
                    flag = false;
                    break; 
                }
            } 
        }
        return flag; 
    }

    //Hàm tính trung bình cộng các số nguyên tố trong mảng 1 chiều 
    public static void tinhTBCongSoNgTo(int a[]) {
        boolean flag = false; 
        int tong = 0; 
        int dem = 0; //dùng để đếm có bao nhiêu số nguyên tố trong mảng này -> để tính trung bình cộng 
        float tbCong = 0; 
        for (int item : a) {
            flag = soNguyenTo(item); 
            if (flag) {
                tong += item; 
                dem++; 
            }
        }
        if (dem == 0 || tong == 0) {
            System.out.println("Mảng không có số nguyên tố nào.");
        } else {
            tbCong = (float) tong / (float) dem;
            System.out.println("Trung bình cộng các số nguyên tố trong mảng là: " + tbCong);
        } 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        //int a[] = {4, 8, 2, -5, -17, 17};
        xuatMang(a);
        tinhTBCongSoNgTo(a);
    }
}


