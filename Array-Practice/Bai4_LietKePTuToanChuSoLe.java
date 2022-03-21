import java.util.Scanner;

/**
 * Tạo ngẫu nhiên mảng một chiều n phần tử nguyên có giá trị trong đoạn [-1000, 1000]
 * Liệt kê các giá trị có toàn chữ số lẻ trong mảng 1 chiều các số nguyên
 */
public class Bai4_LietKePTuToanChuSoLe {

    final static short MAX = 1000;
    final static short MIN = -1000;

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
            a[i] = MIN + (int) (Math.random() * ((MAX - MIN) +1));
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

    //Hàm kiểm tra 1 số có toàn chữ số lẻ 
    public static boolean kiemTraGTriCoToanSoLe(int x) {
        boolean flag = false;   
        do {
            if ((x % 10) % 2 != 0) {
                flag = true; 
                x /= 10; 
            } else {
                flag = false; 
                break; 
            }
        } while (x != 0);
        return flag;
    }

    //Hàm liệt kê các giá trị có toàn chữ số lẻ 
    public static void lietKeGTriToanSoLe(int a[]) {
        boolean flag = false; //Giá trị không có toàn chữ số lẻ  
        boolean flagSoLe = false; //flag này dùng để kiểm tra xem có giá trị nào trong mảng chứa toàn chữ số lẻ đã được liệt kê hay chưa, nếu không có giá trị nào được liệt kê, thì in ra không tìm thấy giá trị nào có toàn số lẻ trong mảng
        for (int i = 0; i < a.length; i++) {
            flag = kiemTraGTriCoToanSoLe(a[i]);
            if (flag) {
                System.out.print(a[i] + "\t");
                flagSoLe = true; 
            }  
        }
        if (!flagSoLe) {
            System.out.println("Không có giá trị nào có toàn chữ số lẻ trong mảng một chiều này.");
        } 
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        xuatMang(a);
        lietKeGTriToanSoLe(a);
    }
}
