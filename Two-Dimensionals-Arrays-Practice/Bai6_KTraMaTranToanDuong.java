import java.util.Scanner;

/**
 * Bài 6
 * Kiểm tra ma trận có toàn dương hay không. Các phần tử được nhập từ bàn phím
 */
public class Bai6_KTraMaTranToanDuong {
    
    //Hàm nhập n 
    public static int nhapN(Scanner scan) {
        int n;
        do {
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n;
    }

    //Hàm nhập mảng từ bàn phím 
    public static int[][] nhapMang(int rows, int cols, Scanner scan) {
        int a[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("a[" + i + "][" + j + "] = ");
                a[i][j] = Integer.parseInt(scan.nextLine());
            }
        }
        return a;
    }

    //Hàm xuất mảng vừa nhập 
    public static void xuatMang(int a[][], int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    //Hàm xét phần tử toàn dương 
    public static void kiemTraMaTran(int a[][], int rows, int cols) {
        boolean flag = true; //ma trận toàn dương 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] < 0) {
                    flag = false; 
                    break;
                } 
            }
            if (!flag) {
                break; 
            }
        }
        if (flag) {
            System.out.println("Mảng này toàn dương");
        } else {
            System.out.println("Mảng này không toàn dương");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số dòng cho mảng: ");
        int rows = nhapN(scan);
        System.out.print("Nhập số cột cho mảng: ");
        int cols = nhapN(scan);
        int a[][] = nhapMang(rows, cols, scan);
        xuatMang(a, rows, cols);
        kiemTraMaTran(a, rows, cols); 
    }
}

 
