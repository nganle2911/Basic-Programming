import java.util.Scanner;

/**
 * Bài 16
 * Cho ma trận vuông bậc n (n nhập từ bàn phím) với các phần tử là các giá trị ngẫu nhiên trong đoạn [-100, 100]
 * Viết hàm xuất tất cả các đường chéo song song với đường chéo phụ, mỗi đường chéo trên một dòng 
 */

public class Bai16_XuatDuongCheoSongSong {

    final static byte MAX = 100; 
    final static byte MIN = -100; 

    //Hàm nhập n là số dòng và số cột 
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    //hàm tạo mảng ngẫu nhiên 
    public static int[][] taoMangA(int n) {
        int arrayA[][] = new int[n][n]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayA[i][j] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
            }
        }
        return arrayA; 
    }

    //Hàm xuất mảng 
    public static void xuatMangA(int arrayA[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arrayA[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Hàm xuất tất cả các đường chéo song song với đường chéo phụ 
    public static void xuatDuongCheo(int arrayA[][], int n) {
        int soDong; 
        //Vòng lặp này xuất nửa trên của đường chéo phụ (bao gồm đường chéo phụ)
        for (soDong = 0; soDong <= n - 1; soDong++) {
            for (int i = 0; i <= soDong; i++) {
                int j = soDong - i; 
                System.out.print(arrayA[i][j] + "\t");
            }
            System.out.print("\n");
        }
        
        //Vòng lặp này xuất nửa dưới của đường chéo phụ, (không bao gồm đường chéo phụ) 
        for (soDong = 1; soDong <= n - 1; soDong++) {
            for (int i = soDong; i <= n - 1; i++) {
                int j = n - 1 - i + soDong;
                System.out.print(arrayA[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập n > 1: ");
        int n = nhapN(scan);
        int arrayA[][] = taoMangA(n);
        //int arrayA[][] = {{-14, -16, -23}, {33, -39, 40}, {-25, 9, 34}}; 
        xuatMangA(arrayA, n);
        System.out.println();
        xuatDuongCheo(arrayA, n); 
    }
    
}

