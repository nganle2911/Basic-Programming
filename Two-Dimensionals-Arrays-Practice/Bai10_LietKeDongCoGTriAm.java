import java.util.Scanner;

/**
 * Bài 10
 * Liệt kê các dòng có chứa giá trị âm trong ma trận các số được tạo ngẫu nhiên trong đoạn [-50, 50]
 */

public class Bai10_LietKeDongCoGTriAm {
    
    final static byte MAX = 50; 
    final static byte MIN = -50; 

    //Hàm nhập n là dòng và cột của mảng 2 chiều 
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    //Hàm tạo mảng ngẫu nhiên 
    public static int[][] taoMang(int row, int col) {
        int a[][] = new int[row][col]; 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = MIN + (int) (Math.random() * ((MAX - MIN) + 1)); 
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
            System.out.print("\n");
        }
    }

    //Hàm liệt kê các dòng có gía trị âm 
    public static void lietKeDongCoGTriAm(int a[][], int row, int col) {
        boolean flag = false; //chưa có dòng nào có giá trị âm 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] < 0) {
                    System.out.print(i + "\t");
                    flag = true; 
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("là những dòng có chứa giá trị âm trong mảng.");
        } else {
            System.out.println("Không có dòng nào có chứa giá trị âm trong mảng.");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số dòng cho mảng: ");
        int row = Integer.parseInt(scan.nextLine());
        System.out.print("Nhập số cột cho mảng: ");
        int col = Integer.parseInt(scan.nextLine());
        int a[][] = taoMang(row, col);
        xuatMang(a, row, col);
        System.out.println();
        lietKeDongCoGTriAm(a, row, col);
        scan.close();
    }
    
}


