import java.util.Scanner;

/**
 * Bài 14
 * Tìm giá trị xuất hiện nhiều nhất 
 * Các số được tạo ngẫu nhiên trong đoạn [-50, 50]
 */
public class Bai14_TimGTriXHNhieuNhat {

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

    //Hàm chuyển mảng 2 chiều thành mảng 1 chiều 
    public static int[] chuyenMang2Thanh1(int a[][], int row, int col) {
        int b[] = new int[row * col];
        int index = 0; //index của mảng b 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) { 
                b[index] = a[i][j]; 
                index++; 
            }
        }
        return b; 
    }

    //Hàm xuất mảng b - mảng 1 chiều 
    public static void xuatMang1Chieu(int b[]) {
        for (int item : b) {
            System.out.print(item + "\t");
        }
        System.out.println("\n"); 
    }

    //Hàm đếm số phần tử xuất hiện trong mảng b - mảng 1 chiều 
    public static int[] demPTu(int b[]) {
        int c[] = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            c[i] = 0;
            for (int j = 0; j < c.length; j++) {
                if (b[i] == b[j]) {
                    if (j < i) {
                        break;
                    } else {
                        c[i]++; 
                    }
                }
            }
        }
        return c; 
    }

    //hàm tìm giá trị xuất hiện nhiều nhất trong mảng 
    public static void timGTriXHNhieuNhat(int c[], int b[]) {
        int gTriXHNhieuNhat = c[0]; 
        for (int i = 0; i < c.length; i++) {
            if (c[i] > gTriXHNhieuNhat) {
                gTriXHNhieuNhat = c[i]; 
            }
        }

        System.out.println("Các giá trị xuất hiện nhiều nhất trong mảng ma trận là: ");
        for (int i = 0; i < b.length; i++) {
            if (c[i] == gTriXHNhieuNhat) {
                System.out.println(b[i] + "(" + gTriXHNhieuNhat + " lần)");
            }
        }
    }
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số dòng cho mảng: ");
        int row = nhapN(scan);
        System.out.print("Nhập số cột cho mảng: ");
        int col = nhapN(scan); 
        int a[][] = taoMang(row, col);
        //int a[][] = {{1, 7, 9, 5}, {2, 1, 3, 1}};
        xuatMang(a, row, col);
        System.out.println("Chuyển mảng 2 chiều thành mảng 1 chiều");
        int b[] = chuyenMang2Thanh1(a, row, col);
        xuatMang1Chieu(b);
        System.out.println("Số lần xuất hiện của các phần tử trong mảng 1 chiều");
        int c[] = demPTu(b); 
        xuatMang1Chieu(c);
        timGTriXHNhieuNhat(c, b);  
    }
}

