import java.util.Scanner;
/**
 * Bài 2
 * Tính tổng các phần tử chẵn trong mảng 2 chiều các số nguyên. Mỗi phần tử được nhập ngẫu nhiên trong đoạn [-50, 50]
 */
public class Bai2_TinhTongPTuChan {
    
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

    //Tính tổng các phần tử chẵn trong mảng 
    public static int tinhTongPTuChan(int a[][], int rows, int cols) {
        int tong = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] % 2 == 0) {
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
        int tong = tinhTongPTuChan(a, rows, cols);
        System.out.println("Tổng các phần tử chẵn trong mảng 2 chiều là: " + tong);
    }
}

 
