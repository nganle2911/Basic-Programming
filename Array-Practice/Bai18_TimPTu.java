import java.util.Scanner;

/**
 * Bài 18
 * Viết chương trình thực hiện những yêu cầu sau:
 * Tạo mảng một chiều phần tử nguyên có giá trị nhập vào từ bàn phím
 * Tìm các phần tử có số lần xuất hiện là như nhau và nhiều nhất 
 */
public class Bai18_TimPTu {
    
    //Hàm nhập n 
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    //Hàm nhập giá trị cho mảng với n phần tử 
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

    //Hàm đếm số lần xuất hiện của mỗi phần tử 
    public static int[] demPhanTu(int a[]) {
        int b[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int j = 0; 
            for (j = 0; j< b.length; j++) {
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

    //Hàm tìm max - phần tử có số lần xuất hiện nhiều nhất 
    public static void inPTuXHNhieuNhat(int a[]) {
        int b[] = demPhanTu(a); 
        int pTuXHNhieuNhat = b[0]; 
        for (int i = 0; i < b.length; i++) {
            if (b[i] > pTuXHNhieuNhat) {
                pTuXHNhieuNhat = b[i]; 
            }
        }
        System.out.println("Các phần tử có số lần xuất hiện là như nhau và nhiều nhất là: ");
        for (int i = 0; i < b.length; i++) {
            if (b[i] == pTuXHNhieuNhat) {
                //System.out.println("Các phần tử có số lần xuất hiện là như nhau và nhiều nhất là: ");
                System.out.print(a[i] + "(" + pTuXHNhieuNhat + " lần) \t");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập n > 0: ");
        int n = nhapN(scan);
        int a[] = nhapMang(n, scan);
        xuatMang(a);
        inPTuXHNhieuNhat(a);
    }
}

