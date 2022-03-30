import java.util.Scanner;

/**
 * Bài 1
 * Tìm số chẵn đầu tiên trong ma trận 2 chiều. Mỗi phần tử được nhập ngẫu nhiên trong đoạn [-50, 50]

 */
public class Bai1_TimSoChanDauTien {

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

    //Hàm tìm số chẵn đầu tiên trong ma trận 
    public static void timSoChanDauTien(int a[][], int rows, int cols) {
        boolean flag = false; 
        for (int i = 0; i < rows; i++) {
            int j; 
            for (j = 0; j < cols; j++) {
                if (a[i][j] % 2 == 0) {
                    flag = true; 
                    break;
                } 
            }
            if (flag) {
                System.out.println("Số chẵn đầu tiên tại vị trí a[" + i + "][" + j + "] = " + a[i][j]);
                break;
            } 
        }
        if (!flag) {
            System.out.println("Mảng không có số chẵn nào");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số dòng cho mảng: ");
        int rows = nhapN(scan);
        System.out.print("Nhập số cột cho mảng: ");
        int cols = nhapN(scan);
        int a[][] = taoMang(rows, cols);
        //int a[][] = nhapMang(rows, cols, scan); 
        xuatMang(a, rows, cols);
        timSoChanDauTien(a, rows, cols);

    }
}
