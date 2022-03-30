import java.util.Scanner;
/**
 * Bài 4
 * Tìm giá trị âm lớn nhất trong ma trận. Mỗi phần tử được nhập ngẫu nhiên trong đoạn [-50, 50]
 * B1: Cho maxAm = -50 (giá trị nhỏ nhất, theo đề bài)
 * B2: Nếu a[i][j] > maxAm -> gán maxAm = a[i][j] -> return maxAm 
 */

public class Bai4_TimGTriAmLonNhat {
    

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

    //Hàm tìm giá trị âm lớn nhất trong mảng 2 chiều 
    public static void timGiaTriAmLonNhat(int a[][], int rows, int cols) {
        int maxAm = MIN;
        int viTriDong = 0; 
        int viTriCot = 0; 
        boolean flag = false; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] > maxAm && a[i][j] < 0) {
                    maxAm = a[i][j];
                    viTriDong = i; 
                    viTriCot = j; 
                    flag = true;
                     
                }
            }
        }
        if (flag) {
            System.out.println("Giá trị âm lớn nhất trong mảng là: a[" + viTriDong + "][" + viTriCot + "] = " + maxAm);
        } else {
            System.out.println("Mảng không có giá trị âm");
        }
       
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số dòng cho mảng: ");
        int rows = nhapN(scan);
        System.out.print("Nhập số cột cho mảng: ");
        int cols = nhapN(scan);
        //int a[][] = {{1, 2}, {3, 4}}; 
        int a[][] = taoMang(4, 4);
        xuatMang(a, rows, cols);
        timGiaTriAmLonNhat(a, rows, cols);
        
    }
   
}


