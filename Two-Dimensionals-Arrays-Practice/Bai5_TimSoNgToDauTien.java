import java.util.Scanner;
/**
 * Bài 5
 * tìm số nguyên tố đầu tiên. Mỗi phần tử được nhập ngẫu nhiên trong đoạn [-50, 50]
 */
public class Bai5_TimSoNgToDauTien {
    
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

    //Hàm kiểm tra có phải số nguyên tố không 
    public static boolean laSoNgTo(int n) {
        boolean flag = true; //là số nguyên tố 
        if (n < 2) {
            flag = false;
        } else if (n == 2) {
            flag = true; 
        } else {
            for (int i = 2; i < n - 1; i++) {
                if (n % i == 0) {
                    flag = false; 
                    break; 
                }
            }
        }
        return flag;
    }

    //Hàm tìm số nguyên tố đầu tiên
    public static void timSoNgToDauTien(int a[][], int rows, int cols) {
        boolean flag = false; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flag = laSoNgTo(a[i][j]);
                if (flag) {
                    System.out.println("Phần tử a[" + i + "][" + j + "] = " + a[i][j] + " là số nguyên tố đầu tiên trong mảng");
                    break; 
                } 
            }
            if (flag) {
                break; 
            }
        }
        if (!flag) { 
            System.out.println("Mảng này không có số nguyên tố");
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
        timSoNgToDauTien(a, rows, cols);
        /* int a[][] = {{20, 15}, {21, 18}};
        xuatMang(a, 2, 2);
        timSoNgToDauTien(a, 2, 2); */
    }
}


