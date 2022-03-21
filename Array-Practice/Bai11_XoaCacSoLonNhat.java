import java.util.Scanner;

/**
 * Bài 11
 * Hãy xoá tất cả các số lớn nhất trong mảng các số thực 
 */

public class Bai11_XoaCacSoLonNhat {
    
    //Hàm nhập n > 0 
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            System.out.print("Nhập n > 0: ");
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    //Hàm nhập mảng có n phần tử 
    public static int[] nhapMang(int n, Scanner scan) {
        int a[] = new int[n]; 
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = Integer.parseInt(scan.nextLine());
        }
        return a; 
    }

    //hàm xuất mảng 
    public static void xuatMang(int a[]) {
        for (int item : a) {
            System.out.print(item + "\t");
        }
        System.out.println("\n");
    }

    //Hàm tìm số lớn nhất trong mảng a[]
    public static int timSoLonNhat(int a[]) {
        int max = a[0]; 
        for (int item : a) {
            if (item > max) {
                max = item; 
            }
        }
        return max; 
    }

    //Hàm đếm xem có bao nhiêu số max trong mảng 
    public static int demSoMax(int max, int a[]) {
        int dem = 0; 
        for (int item : a) {
            if (item == max) {
                dem++; 
            }
        }
        return dem; 
    }

    //Hàm xoá các giá trị lớn nhất trong mảng 
    public static int[] xoaGTriLonNhat(int a[]) {
        int max = timSoLonNhat(a);
        int dem = demSoMax(max, a);
        int b[] = new int[a.length - dem]; 
        int i = 0;
        for (int item : a) {
            if (item != max) {
                b[i] = item; 
                i++;
            }
        }
        a = b; 
        return a;  
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = nhapMang(n, scan);
        xuatMang(a);
        a = xoaGTriLonNhat(a);
        xuatMang(a);
    }
}


