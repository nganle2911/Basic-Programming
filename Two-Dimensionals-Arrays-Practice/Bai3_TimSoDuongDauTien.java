import java.util.Scanner;
/**
 * Bài 3
 * Tìm số dương đầu tiên trong ma trận. Mỗi phần tử được nhập ngẫu nhiên trong đoạn [-50, 50]
 */
public class Bai3_TimSoDuongDauTien {
        
    final static byte MIN = -50;
    final static byte MAX = 50; 

    //Hàm nhập n
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    //Hàm tạo mảng 2 chiều ngẫu nhiên 
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

    //Hàm tìm số dương đầu tiên trong mảng 
    public static void timSoDuongDauTien(int a[][], int rows, int cols) {
        boolean flag = false; 
        for (int i = 0; i < rows; i++) {
            int j; 
            for (j = 0; j < cols; j++) {
                if (a[i][j] > 0) {
                    flag = true; 
                    break;
                }
            }
            if (flag) {
                System.out.println("Số dương đầu tiên trong mảng 2 chiều tại vị trí a[" + i + "][" + j + "] = " + a[i][j]);
                break;
            }
        }
        if (!flag) {
            System.out.println("Mảng không có số dương nào.");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số dòng cho mảng: ");
        int rows = nhapN(scan);
        System.out.print("Nhập số cột cho mảng: ");
        int cols = nhapN(scan);
        int a[][] = taoMang(rows, cols);
        xuatMang(a, rows, cols);
        timSoDuongDauTien(a, rows, cols);
    }
}


