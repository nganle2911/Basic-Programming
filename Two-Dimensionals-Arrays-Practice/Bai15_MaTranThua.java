import java.util.Scanner;

/**
 * Bài 15
 * Ma trận thưa là ma trận có số phần tử có giá trị bằng 0 nhiều hơn số phần tử khác 0
 * Viết chương trình thực hiện các công việc: 
 * Nhập m, n là số dòng và số cột của ma trận 2 chiều A từ bàn phím 
 * Nhập giá trị các phần tử của ma trận A từ bàn phím
 * Kiểm tra và thông báo lên màn hình ma trận vừa nhập là ma trận thưa hay mà trận không thưa 
 */
public class Bai15_MaTranThua {
    
    //Hàm nhập n là số dòng và số cột 
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
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
            for (int j = 0; j < col; j++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    //Hàm kiểm tra xem ma trận thưa hay không 
    public static void kiemTraMaTranThua(int a[][], int row, int col) {
        int demBang0 = 0; //dùng để đếm giá trị bằng 0 trong mảng  
        int demKhac0 = 0; //dùng để đếm giá trị khác 0 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == 0) {
                    demBang0++; 
                } else {
                    demKhac0++; 
                }
            }
        }
        
        if (demBang0 > demKhac0) {
            System.out.println("Ma trận này là ma trận thưa");
        } else {
            System.out.println("Ma trận này là ma trận không thưa");
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số dòng cho mảng: ");
        int row = nhapN(scan);
        System.out.print("Nhập số cột cho mảng: ");
        int col = nhapN(scan);
        int a[][] = nhapMang(row, col, scan);
        xuatMang(a, row, col);
        kiemTraMaTranThua(a, row, col);
    }
}

