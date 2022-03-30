import java.util.Scanner;

/**
 * Bài 12
 * tìm phần tử chẵn cuối cùng các số được tạo ngẫu nhiên trong đoạn [-50, 50]
 */
public class Bai12_TimPTuChanCuoiCung {
    
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

    //Hàm tìm phần tử chẵn cuối cùng 
    public static void timPTuChanCuoiCung(int a[][], int rows, int cols) {
        int chanCuoiCung = a[rows -1][cols - 1];
        int dongCuoi = rows - 1;
        int cotCuoi = cols - 1; 
        boolean flag = false; 
        for (int i = dongCuoi; i >= 0; i--) {
            for (int j = cotCuoi; j >= 0; j--) {
                if (a[i][j] % 2 == 0) {
                    chanCuoiCung = a[i][j];
                    dongCuoi = i;
                    cotCuoi = j;
                    flag = true;
                    break; 
                }
            }
            if (flag) { //để thoát khỏi vòng for i, vì bài yêu cầu chỉ in 1 phần tử chẵn cuối cùng 
                break; 
            } 
        }
        if (flag) {
            System.out.println("Phần tử chẵn cuối cùng trong mảng tại vị trí a[" + dongCuoi + "][" + cotCuoi + "] = " + chanCuoiCung);
        } else {
            System.out.println("Mảng không có phần tử chẵn nào");
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
        timPTuChanCuoiCung(a, rows, cols);
    }
}


