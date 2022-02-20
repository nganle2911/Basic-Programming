import java.util.Scanner;

/**
 * Mục đích: để quản lý những nghiệp vụ liên quan đến lớp Student 
 * Người tạo: Kim Ngân
 * Ngày tạo: 19/02/2022
 * Version: 1.0 
 */
public class Student extends Person {
    //1. Attributes
    private float toan; 
    private float ly;
    private float hoa; 
    //2. Get, set 
    public float getToan() {
        return toan;
    }
    public void setToan(float toan) {
        this.toan = toan;
    }
    public float getLy() {
        return ly;
    }
    public void setLy(float ly) {
        this.ly = ly;
    }
    public float getHoa() {
        return hoa;
    }
    public void setHoa(float hoa) {
        this.hoa = hoa;
    }
    //3. Constructor 
    public Student() {
    }
    public Student(String hoTen, String diaChi, String ma, String email, float toan, float ly, float hoa) {
        super(hoTen, diaChi, ma, email);
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }
    //4. Input, output
    @Override
    public void nhap(Scanner scan) {
        super.nhap(scan); //sử dụng function nhap() của lớp Person
        System.out.print("Nhập điểm Toán: ");
        this.toan = Float.parseFloat(scan.nextLine());

        System.out.print("Nhập điểm Lý: ");
        this.ly = Float.parseFloat(scan.nextLine());

        System.out.print("Nhập điểm Hoá: ");
        this.hoa = Float.parseFloat(scan.nextLine());
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("\t Toán: " + this.toan +
                            "\t Lý: " + this.ly + 
                            "\t Hoá: " + this.hoa);
    }
    //5. Business 
}
