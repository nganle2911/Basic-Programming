import java.util.Scanner;

/**
 * Bài 7
 * Kiểm tra một cột ma trận có giảm dần hay không. Các phần tử được nhập từ bàn phím
 */

public class Bai7_KTraCotGiamDan {
    
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

    //Hàm kiểm tra cột giảm dần 
    public static void kTraCotGiamDan(int a[][], int rows, int cols, int cotGiamDan) {
        boolean flag = true; //cột đang kiểm tra là cột giảm dần 
        for (int i = 0; i < rows - 1 ; i++) {
            if (a[i][cotGiamDan] < a[i+1][cotGiamDan]) {
                flag = false;
                break; 
            }
        }

        if (flag) {
            System.out.println("Cột " + cotGiamDan + " là cột giảm dần.");
        } else {
            System.out.println("Cột " + cotGiamDan + " không phải cột giảm dần.");
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
        System.out.print("Nhập số cột bạn muốn kiểm tra: ");
        int cotGiamDan = Integer.parseInt(scan.nextLine());
        kTraCotGiamDan(a, rows, cols, cotGiamDan);

    }
}

 