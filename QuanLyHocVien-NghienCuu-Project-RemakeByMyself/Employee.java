import java.util.Scanner;

/**
 * Mục đích: để quản lý những nghiệp vụ liên quan đến lớp Employee
 * Người tạo: Kim Ngân
 * Ngày tạo: 19/02/2022
 * Version: 1.0 
 */

public class Employee extends Person {
    //1.Attributes
    private float soNgayLamViec; 
    private float luongTheoNgay; 
    //2. Get, set 
    public float getSoNgayLamViec() {
        return soNgayLamViec;
    }
    public void setSoNgayLamViec(float soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }
    public float getLuongTheoNgay() {
        return luongTheoNgay;
    }
    public void setLuongTheoNgay(float luongTheoNgay) {
        this.luongTheoNgay = luongTheoNgay;
    }
    //3. Constructor
    public Employee() {
    }
    public Employee(String hoTen, String diaChi, String ma, String email, float soNgayLamViec, float luongTheoNgay) {
        super(hoTen, diaChi, ma, email);
        this.soNgayLamViec = soNgayLamViec;
        this.luongTheoNgay = luongTheoNgay;
    }
    //4. Input, output
    @Override
    public void nhap(Scanner scan) {
        super.nhap(scan);
        System.out.print("Nhập số ngày làm việc: ");
        this.soNgayLamViec = Float.parseFloat(scan.nextLine());

        System.out.print("Nhập lương theo ngày (đơn vị: nghìn VNĐ): ");
        this.luongTheoNgay = Float.parseFloat(scan.nextLine());
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("\t Số ngày làm việc: " + this.soNgayLamViec + 
                            "\t Lương theo ngày: " + this.luongTheoNgay);
    }
    //5. Business
}
