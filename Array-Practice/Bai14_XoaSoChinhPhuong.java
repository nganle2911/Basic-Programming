import java.util.Scanner;

/**
 * Bài 14
 * xoá tất cả số chính phương trong mảng
 */

public class Bai14_XoaSoChinhPhuong {
    
    final static int MAX = 100; 
    final static int MIN = -100; 

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

    //Hàm kiểm tra xem số đó có phải số chính phương hay không 
    public static boolean soChinhPhuong(int x) {
        boolean flag = false; //không phải số chính phương
        int i = 1; 
        while (i <= x) {
            if (Math.pow(i, 2) == x) {
                flag = true; 
                break;
            }
            i++; 
        }
        return flag; 
    }

    //Hàm đếm xem có bao nhiêu số chính phương trong mảng 
    public static int demSoChinhPhuong(int a[]) {
        int dem = 0; 
        boolean flag = false; 
        for (int item : a) {
            flag = soChinhPhuong(item);
            if (flag) {
                dem++; 
            }
        }
        return dem; 
    }

    //Hàm xoá các số chính phương trong mảng 
    public static int[] xoaSoChinhPhuong(int a[]) {
        //boolean flag = true;
        int dem = demSoChinhPhuong(a);
        int b[] = new int[a.length - dem];
        if (b.length == a.length) {
            System.out.println("Mảng không có số chính phương nào cần xoá");
        }
        int i = 0; 
        for (int item : a) {
            boolean flag = soChinhPhuong(item);
            if (!flag) {
                b[i] = item;
                System.out.print(item + "\t");
                i++;
            }     
        }
        a = b; 
        return a; 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        //int a[] = {7, 9, 15, 49, 8, 10, 25};
        xuatMang(a);
        xoaSoChinhPhuong(a);
    }
}

