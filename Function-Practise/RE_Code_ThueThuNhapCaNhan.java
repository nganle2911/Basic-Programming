import java.util.Scanner;

public class RE_Code_ThueThuNhapCaNhan {
    
    //Định nghĩa hằng số 
    //Phần thuế suất phải chịu 
    static final float THUE_SUAT_DEN_60 = 0.05f;
    static final float THUE_SUAT_60_DEN_120 = 0.1f;
    static final float THUE_SUAT_120_DEN_216 = 0.15f;
    static final float THUE_SUAT_216_DEN_384 = 0.2f;
    static final float THUE_SUAT_384_DEN_624 = 0.25f;
    static final float THUE_SUAT_624_DEN_960 = 0.3f;
    static final float THUE_SUAT_TREN_960 = 0.35f;

    //Phần chênh lệch giữa các hạn mức thuế quy định
    static final byte DEN_60 = 60; 
    static final byte TREN_60_DEN_120 = 60;
    static final byte TREN_120_DEN_216 = 96;
    static final short TREN_216_DEN_384 = 168;
    static final short TREN_384_DEN_624 = 240;
    static final short TREN_624_DEN_960 = 336;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String hoTen = nhapHoTen(scan);
        float tongThuNhap = nhapTongThuNhap(scan);
        int soNguoi = nhapNguoiPhuThuoc(scan);
        float thuNhapChiuThue = tinhThuNhapChiuThue(tongThuNhap, soNguoi);
        float thuePhaiNop = tinhThuePhaiNop(thuNhapChiuThue);
        System.out.println("Cá nhân " + hoTen + " có tổng thu nhập là: " + tongThuNhap + " triệu đồng.");
        System.out.println("Thu nhập chịu thuế là: " + thuNhapChiuThue + " triệu đồng và số thuế phải nộp là: " + thuePhaiNop + " triệu đồng.");
    }

    //Hàm nhập họ tên cá nhân 
    public static String nhapHoTen(Scanner scan) {
        String hoTen;
        System.out.println("Nhập tên người nộp thuế: ");
        hoTen = scan.nextLine();
        return hoTen; 
    }

    //Hàm nhập tổng thu nhập năm 
    public static float nhapTongThuNhap(Scanner scan) {
        float tongThuNhap;
        System.out.println("Vui lòng nhập tổng thu nhập năm của bạn (đơn vị triệu đồng): ");
        tongThuNhap = Float.parseFloat(scan.nextLine());
        return tongThuNhap;
    }

    //Hàm nhập số người phụ thuộc 
    public static int nhapNguoiPhuThuoc(Scanner scan) {
        int soNguoi;
        System.out.println("Vui lòng nhập số người phụ thuộc: ");
        soNguoi = Integer.parseInt(scan.nextLine());
        return soNguoi; 
    }

    //Hàm tính thu nhập chịu thuế
    public static float tinhThuNhapChiuThue(float tongThuNhap, int nguoiPhuThuoc) {
        float thuNhapChiuThue; 
        thuNhapChiuThue = tongThuNhap - 4 - (nguoiPhuThuoc * 1.6f);
        return thuNhapChiuThue;
    }

    //Hàm tính thuế phải nộp 
    public static float tinhThuePhaiNop(float thuNhapChiuThue) {
        float soThuePhaiNop; 

        if ((thuNhapChiuThue - DEN_60) <= 0) {
            return soThuePhaiNop = thuNhapChiuThue * THUE_SUAT_DEN_60;
        } else {
            soThuePhaiNop = DEN_60 * THUE_SUAT_DEN_60; 
            thuNhapChiuThue = thuNhapChiuThue - DEN_60; 
        }

        //Khoang 60 - 120 
        if ((thuNhapChiuThue - TREN_60_DEN_120) <= 0) {
            return soThuePhaiNop = soThuePhaiNop + (thuNhapChiuThue * THUE_SUAT_60_DEN_120);
        } else {
            soThuePhaiNop = soThuePhaiNop + (TREN_60_DEN_120 * THUE_SUAT_60_DEN_120); 
            thuNhapChiuThue = thuNhapChiuThue - TREN_60_DEN_120;
        }

        //Khoang 120 - 216 
        if ((thuNhapChiuThue - TREN_120_DEN_216) <= 0) {
            return soThuePhaiNop = soThuePhaiNop + (thuNhapChiuThue * THUE_SUAT_120_DEN_216);
        } else {
            soThuePhaiNop = soThuePhaiNop + (TREN_120_DEN_216 * THUE_SUAT_120_DEN_216);
            thuNhapChiuThue = thuNhapChiuThue - TREN_120_DEN_216;
        }

        //Khoang 216 - 384
        if ((thuNhapChiuThue - TREN_216_DEN_384) <= 0) {
            return soThuePhaiNop = soThuePhaiNop + (thuNhapChiuThue * THUE_SUAT_216_DEN_384);
        } else {
            soThuePhaiNop = soThuePhaiNop + (TREN_216_DEN_384 * THUE_SUAT_216_DEN_384);
            thuNhapChiuThue = thuNhapChiuThue - TREN_216_DEN_384; 
        }

        //Khoang 384 - 624
        if ((thuNhapChiuThue - TREN_384_DEN_624) <= 0) {
            return soThuePhaiNop = soThuePhaiNop + (thuNhapChiuThue * THUE_SUAT_384_DEN_624);
        } else {
            soThuePhaiNop = soThuePhaiNop + (TREN_384_DEN_624 * THUE_SUAT_384_DEN_624);
            thuNhapChiuThue = thuNhapChiuThue - TREN_384_DEN_624;
        }

        //Khoang 624 - 960
        if ((thuNhapChiuThue - TREN_624_DEN_960) <= 0) {
            return soThuePhaiNop = soThuePhaiNop + (thuNhapChiuThue * THUE_SUAT_624_DEN_960);
        } else {
            soThuePhaiNop = soThuePhaiNop + (TREN_624_DEN_960 * THUE_SUAT_624_DEN_960);
            thuNhapChiuThue = thuNhapChiuThue - TREN_624_DEN_960;
        }

        //Tren 960
        if (thuNhapChiuThue <= 0) {
            return soThuePhaiNop; 
        } else {
            soThuePhaiNop = soThuePhaiNop + (thuNhapChiuThue * THUE_SUAT_TREN_960);
        }
        
        return soThuePhaiNop; 
    }

}

//Đã code lại thành công, có tham khảo bài giải của thầy 
