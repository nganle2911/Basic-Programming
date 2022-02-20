import java.util.Scanner;

/**
 * Mục đích: để quản lý những nghiệp vụ liên quan đến lớp Customer
 * Người tạo: Kim Ngân
 * Ngày tạo: 19/02/2022
 * Version: 1.0
 */

public class Customer extends Person {
    //1. Attributes
    private String tenCongTy;
    private float triGiaHoaDon;
    private String danhGia; 
    //2. Get, set 
    public String getTenCongTy() {
        return tenCongTy;
    }
    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }
    public float getTriGiaHoaDon() {
        return triGiaHoaDon;
    }
    public void setTriGiaHoaDon(float triGiaHoaDon) {
        this.triGiaHoaDon = triGiaHoaDon;
    }
    public String getDanhGia() {
        return danhGia;
    }
    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }
    //3. Constructor
    public Customer() {
    }
    public Customer(String hoTen, String diaChi, String ma, String email, String tenCongTy, float triGiaHoaDon,
            String danhGia) {
        super(hoTen, diaChi, ma, email);
        this.tenCongTy = tenCongTy;
        this.triGiaHoaDon = triGiaHoaDon;
        this.danhGia = danhGia;
    }
    //4. Input, output
    @Override
    public void nhap(Scanner scan) {
        super.nhap(scan);
        System.out.print("Nhập tên công ty: ");
        this.tenCongTy = scan.nextLine();

        System.out.print("Nhập trị giá hoá đơn: ");
        this.triGiaHoaDon = Float.parseFloat(scan.nextLine());

        System.out.print("Nhập đánh giá: ");
        this.danhGia = scan.nextLine();
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("\t Tên Công Ty: " + this.tenCongTy + 
                            "\t Trị giá hoá đơn: " + this.triGiaHoaDon + 
                            "\t Đánh giá: " + this.danhGia);
    }
    //5. Business
}
