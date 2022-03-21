import java.util.Scanner;

/**
 * Bai16
 * Tạo mảng một chiều n phần tử nguyên có giá trị nhập từ bàn phím
 * Xuất phần tử xuất hiện nhiều nhất, xuất hiện ít nhất tìm thấy đầu tiên 
 */
public class Bai16_DemPTuNhieuVaIt {
    
    //Hàm nhập n > 0
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine()); 
        } while (n < 1);
        return n; 
    }

    //Hàm nhập mảng với n phần tử 
    public static int[] nhapMang(int n, Scanner scan) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = Integer.parseInt(scan.nextLine());
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

    //Hàm đếm phần tử 
    public static int[] demPhanTu(int a[]) {
        int b[] = new int[a.length]; 
        for (int i = 0; i < a.length; i++) {
            b[i] = 0; 
            for (int j = 0; j < b.length; j++) {
                if (a[i] == a[j]) {
                    if (j < i) {
                        break; 
                    } else {
                        b[i]++; 
                    }
                }
            }
        }
        return b; 
    }

    //Hàm in phần tử xuất hiện nhiều nhất đầu tiên 
    public static void inSoPTuNhieuNhat(int a[]) {
        int b[] = demPhanTu(a);
        int pTuXHNhieuNhat = b[0];
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 0) {
                if (b[i] > pTuXHNhieuNhat) {
                    pTuXHNhieuNhat = b[i];
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] == pTuXHNhieuNhat) {
                System.out.println("Phần tử xuất hiện nhiều nhất đầu tiên: " + a[i] + " [" + pTuXHNhieuNhat + " lần]");
                break; 
            }
        }
    }

    //Hàm in phần tử xuất hiện ít nhất đầu tiên
    public static void inSoPTuItNhat(int a[]) {
        int b[] = demPhanTu(a);
        int pTuXHItNhat = b[0];
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 0) {
                if (b[i] < pTuXHItNhat) {
                    pTuXHItNhat = b[i];
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] == pTuXHItNhat) {
                System.out.println("Phần tử xuất hiện ít nhất đầu tiên: " + a[i] + " [" + pTuXHItNhat + " lần]");
                break; 
            }
        }
    }  

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập n > 0: ");
        int n = nhapN(scan);
        int a[] = nhapMang(n, scan);
        xuatMang(a);
        inSoPTuNhieuNhat(a);
        inSoPTuItNhat(a);
    }
}

