import java.util.Scanner;

/**
 * Bài 2
 * Cho mảng 1 chiều các số nguyên có nhiều hơn 2 giá trị 
 * Viết hàm liệt kê các cặp giá trị gần nhau nhất 
 */

public class Bai2_LietKeCapGTriGanNhau {

    final static byte MAX = 100;
    final static byte MIN = -100; 

    //Hàm nhập n > 2 
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            System.out.print("Nhập n > 2: ");
            n = Integer.parseInt(scan.nextLine());
        } while (n < 3);
        return n; 
    }

    //Hàm tạo mảng ngẫu nhiên  
    public static int[] taoMang(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1)); 
        }
        return a; 
    }

    //Hàm xuất mảng 
    public static void xuatMang(int a[]) {
        for (int item : a) {
            System.out.print(item + "\t");
        }
        System.out.println("\n");
    }

    //Tìm khoảng cách ngắn nhất giữa các giá trị 
    public static int closestDistanceOfValues(int a[]) {
        int closestDistance = Math.abs(a[0] - a[1]);
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (Math.abs(a[i] - a[j]) < closestDistance) {
                    closestDistance = Math.abs(a[i] - a[j]);
                }
            }
        }
        return closestDistance;
    }

    //Liệt kê các cặp có giá trị gần nhau nhất trong mảng  
    public static void listCouplesOfClosestValues(int a[]) {
        int closestDistance = closestDistanceOfValues(a);
        System.out.println("Các cặp giá trị gần nhau nhất là: ");
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (Math.abs(a[i] - a[j]) == closestDistance) {
                    System.out.println("a[" + i + "], a[" + j + "] : " + "(" + a[i] + ", " + a[j] + ")");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        xuatMang(a);
        listCouplesOfClosestValues(a);
    }
}
