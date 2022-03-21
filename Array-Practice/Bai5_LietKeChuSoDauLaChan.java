import java.util.Scanner;

/**
 * Bài 5
 * Hãy liệt kê các giá trị trong mảng 1 chiều các số nguyên có chữ số đầu tiên là số chẵn 
 */

public class Bai5_LietKeChuSoDauLaChan {
    
    final static short MAX = 1000;
    final static short MIN = -1000; 

    //Hàm nhập n > 0 
    public static int nhapN(Scanner scan) {
        int n; 
        do {
            System.out.print("Nhâp n > 0: ");
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

    //Hàm kiểm tra giá trị có chữ số đầu tiên là số chẵn 
    public static boolean gTriCoChuSoDauChan(int x) {
        boolean flag = false; 
        while (x != 0) {
            flag = false; 
            if ((x % 10) % 2 == 0) {
                flag = true; 
            }
            x /= 10; 
        }
        return flag; 
    }

    //Hàm liệt kê các giá trị có chữ số đầu tiên là số chẵn 
    public static void lietKeGTriCoChuSoDauChan(int a[]) {
        boolean flag = false; //flag này thể hiện giá trị không chứa chữ số đầu tiên là số chẵn
        boolean flagCoGiaTri = false; //flag này kiểm tra xem có giá trị nào có chữ số đầu tiên là số chẵn đã được liệt kệ hay chưa, nếu không có giá trị nào được liệt kê, thì in không có giá trị nào được tìm thấy 
        for (int i = 0; i < a.length; i++) {
            flag = gTriCoChuSoDauChan(a[i]);
            if (flag) {
                System.out.print(a[i] + "\t");
                flagCoGiaTri = true; 
            }
        }
        if (!flagCoGiaTri) {
            System.out.println("Không tim thấy giá trị nào có chữ số đầu tiên là số chẵn.");
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = nhapN(scan);
        int a[] = taoMang(n);
        xuatMang(a);
        lietKeGTriCoChuSoDauChan(a);
    }
}

 
