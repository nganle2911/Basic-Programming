import java.util.Scanner;

/**
 * Bài 11
 * Liệt kê các cột tăng dần trong ma trận.
 * Các phần tử được nhập vào từ bàn phím 
 */
public class Bai11_LietKeCotTangDan {
    
    //Hàm nhập n > 2 là số dòng và số cột của mảng
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine());
        } while (n < 2);
        return n; 
    }

    //Hàm nhập mảng 
    public static int[][] nhapMang(int row, int col, Scanner scan) {
        int a[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("a[" + i + "][" + j + "] = ");
                a[i][j] = Integer.parseInt(scan.nextLine());
            }
        }
        return a; 
    }

    //Hàm xuất mảng 
    public static void xuatMang(int a[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Hàm liệt kê các cột tăng dần trong ma trận a 
    public static void lietKeCotTangDan(int a[][], int row, int col) {
        boolean flag = false; //chưa phải cột tăng dần 
        boolean flagCotTangDan = false; //flag này dùng để kiểm tra xem có cột nào tăng dần trong mảng hay không, nếu không có thì in "không có cột tăng dần"
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row - 1; i++) {
                if (a[i][j] < a[i+1][j]) {
                    flag = true; 
                } else {
                    flag = false;
                    break; 
                }
            }
            if (flag) {
                System.out.print(j + "\t");
                flagCotTangDan = true; 
            }
        }

        if (!flagCotTangDan) {
            System.out.println("Không có cột tăng dần nào trong mảng cần được liệt kê");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số dòng cho mảng: ");
        int row = nhapN(scan);
        System.out.print("Nhập số cột cho mảng: ");
        int col = nhapN(scan);
        int a[][] = nhapMang(row, col, scan);
        //int a[][] = {{-2, 6, 9, -3}, {3, 7, 10, 5}, {-1, 4, 22, -1}};
        xuatMang(a, row, col);
        System.out.print("Các cột tăng dần trong mảng là: ");
        lietKeCotTangDan(a, row, col);

    }
}

