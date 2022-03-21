import java.util.Scanner;

/**
 * Bai3_LietKeSoChanTrongDoan
 * Tạo ngẫu nhiên mảng một chiều n phần tử nguyên (n chẵn) có giá trị chứa trong đoạn [-100, 100]. 
 * Liệt kê các số chẵn trong mảng 1 chiều các số nguyên thuộc đoạn [x, y] cho trước (x, y là số nguyên)
 */

public class Bai3_LietKeSoChanTrongDoan {

    final static byte MIN = -100;
    final static byte MAX = 100; 

    //Hàm nhập n > 0 và n chẵn
    public static int nhapN(Scanner scan) {
        int n;
        do {
            System.out.print("Nhập n > 0 và n là số chẵn: ");
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1 || n % 2 != 0);
        return n;
    }

    //Hàm tạo mảng ngẫu nhiên
    public static int[] taoMang(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = MIN + (int) (Math.random() * ((MAX - MIN) +1));
        }
        return a;
    }

    //Hàm xuất mảng 
    public static void xuatMang(int a[]) {
        for (int item : a) {
            System.out.print(item + "\t" );
        }
        System.out.println("\n");
    }

    //Hàm liệt kê các phần tử chẵn thuộc đoạn [x, y]
    public static void lietKeSoChanTrongDoan(int a[], Scanner scan) { 

        System.out.print("Nhập giá trị x dưới: ");
        int x = Integer.parseInt(scan.nextLine());

        System.out.print("Nhập giá trị y trên: ");
        int y = Integer.parseInt(scan.nextLine());

        boolean flag = false; 
        for (int item : a) {     
            if (item >= x && item <= y) {
                if (item % 2 == 0) {
                    System.out.print(item + "\t");
                    flag = true; 
                }
            }  
        }
        if (!flag) {
            System.out.println("Không có phần tử chẵn nào trong đoạn [" + x + ", " + y + "]");
        }
        
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        xuatMang(a);
        lietKeSoChanTrongDoan(a, scan);   
    }
}

