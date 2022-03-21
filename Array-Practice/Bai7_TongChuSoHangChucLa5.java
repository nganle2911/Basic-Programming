import java.util.Scanner;

/**
 * Bài 7
 * Tính tổng các chữ số có chữ số hàng chục là 5 trong mảng 1 chiều các số nguyên 
 */
public class Bai7_TongChuSoHangChucLa5 {
    
    final static short MAX = 1000;
    final static short MIN = -1000;

    //Hàm nhập n > 0 
    public static int enterN(Scanner scan) {
        int n; 
        do {
            n = Integer.parseInt(scan.nextLine());
        } while (n < 1);
        return n; 
    }

    //Hàm tạo mảng ngẫu nhiên 
    public static int[] createArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
        }
        return a;
    }

    //Hàm xuất mảng  
    public static void outputArray(int a[]) {
        for (int item : a) {
            System.out.print(item + "\t");
        }
        System.out.println("\n");
    }

    //Tính tổng các giá trị có chữ số hàng chục là 5 trong mảng 
    //Lần 1 chia cho 10, lần 2 chia dư cho 10 và xét xem phần dư có bằng 5 hay không, nếu có thì hợp lệ 
    public static int sumOfValidValues(int a[]) {
        int sum = 0;
        for (int item : a) {
            int tenDigit = item / 10; 
            int surplus = tenDigit % 10; 
            if (Math.abs(surplus) == 5) {
                sum += item; 
            }
        }
        return sum; 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập n > 0: ");
        int n = enterN(scan);
        int a[] = createArray(n);
        //int a[] = {154, -53, 52}; 
        outputArray(a);
        int sum = sumOfValidValues(a); 
        System.out.println("Tổng các giá trị có chữ số hàng chục là 5 : " + sum);
    }  
}
