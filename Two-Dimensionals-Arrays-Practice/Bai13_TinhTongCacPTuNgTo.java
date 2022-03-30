import java.util.Scanner;

/**
 * Bài 13
 * Tính tổng các phần tử nguyên tố có trong mảng các số được tạo ngẫu nhiên trong đoạn [-50, 50]
 */

public class Bai13_TinhTongCacPTuNgTo {
    
    final static byte MAX = 50; 
    final static byte MIN = -50; 

    //Hàm nhập n 
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    //Hàm tạo mảng ngẫu nhiên 
    public static int[][] taoMang(int rows, int cols) {
        int a[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = MIN + (int) + (Math.random() * ((MAX - MIN) + 1));
            }
        }
        return a; 
    }

    //Hàm xuất mảng 
    public static void xuatMang(int a[][], int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    //Hàm kiểm tra một số có phải là số nguyên tố hay không 
    public static boolean kTraSoNguyenTo(int x) {
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

    //Hàm tính tổng các số nguyên tố trong mảng 
    public static int tinhTongSoNguyenTo(int a[][], int rows, int cols) {
        int tong = 0; 
        boolean flag; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flag = kTraSoNguyenTo(a[i][j]);
                if (flag) {
                    tong += a[i][j];
                }
            }
        }
        return tong;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số dòng cho mảng: ");
        int rows = nhapN(scan);
        System.out.print("Nhập số cột cho mảng: ");
        int cols = nhapN(scan);
        int a[][] = taoMang(rows, cols);
        xuatMang(a, rows, cols);
        int tong = tinhTongSoNguyenTo(a, rows, cols);
        if (tong == 0) {
            System.out.println("Mảng không có số nguyên tố nào");
        } else {
            System.out.println("Tổng các phần tử nguyên tố trong mảng 2 chiều là: " + tong);
        }
    }
}


