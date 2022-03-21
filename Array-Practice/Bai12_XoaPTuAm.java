import java.util.Scanner;

/**
 * Bài 12
 * Xoá tất cả các số âm trong mảng 
 */

public class Bai12_XoaPTuAm {
    
    final static int MAX = 1000; 
    final static int MIN = -1000; 

    //Hàm nhập n > 0 
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            System.out.print("Nhập n > 0: ");
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
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

    //Hàm đếm có bao nhiêu giá trị âm trong mảng 
    public static int demSoAm(int a[]) {
        int dem = 0; 
        for (int item : a) {
            if (item < 0) {
                dem++; 
            }
        }
        return dem; 
    }

    //Hàm xoá các giá trị âm trong mảng 
    public static int[] xoaPTuAm(int a[]) {
        int dem = demSoAm(a);
        int b[] = new int[a.length - dem];
        int i = 0; 
        if (dem == a.length) {
            System.out.println("Tất cả các phần tử trong mảng đều là số âm.");
        } else {
            for (int item : a) {
                if (item > 0) {
                    b[i] = item;
                    System.out.print(b[i] + "\t");
                    i++; 
                }
            }
        }
        a = b; 
        return a; 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        //int a[] = {-15, 3, 8, -25, -2};
        xuatMang(a);
        xoaPTuAm(a);
    }

}


