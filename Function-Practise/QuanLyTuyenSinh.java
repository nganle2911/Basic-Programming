import java.util.Scanner;

public class QuanLyTuyenSinh {
    //Định nghĩa hằng số
    //static final float KHU_VUC_A = 2; -> câu này khai báo biến kiểu float là ko đúng 
    static final byte KHU_VUC_A = 2; 
    //static final float KHU_VUC_B = 1;
    static final byte KHU_VUC_B = 1;
    static final float KHU_VUC_C = 0.5f;

    static final float DOI_TUONG_1 = 2.5f;
    static final float DOI_TUONG_2 = 1.5f;
    //static final float DOI_TUONG_3 = 1;
    static final byte DOI_TUONG_3 = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float mon1 = nhapMonThi_1(scan);
        float mon2 = nhapMonThi_2(scan);
        float mon3 = nhapMonThi_3(scan);
        String khuVuc = chonKhuVuc(scan);
        int doiTuong = chonDoiTuong(scan);
        float diemKhuVuc = theoKhuVuc(khuVuc);
        float diemDoiTuong = theoDoiTuong(doiTuong);
        float diemTongKet = mon1 + mon2 + mon3 + diemKhuVuc + diemDoiTuong;
        float diemChuan = nhapDiemChuan(scan);

        //Điều kiện trúng tuyển
        if (diemTongKet < diemChuan) {
            System.out.println("Thí sinh không trúng tuyển vì không đạt đủ điểm chuẩn, với tổng điểm là: " + diemTongKet);
        } else {
            if (mon1 == 0) {
                System.out.println("Thí sinh không trúng tuyển vì môn 1 bị điểm liệt, với tổng điểm là: " + diemTongKet);
            } else if (mon2 == 0) {
                System.out.println("Thí sinh không trúng tuyển vì môn 2 bị điểm liệt, với tổng điểm là: " + diemTongKet);
            } else if (mon3 == 0) {
                System.out.println("Thí sinh không trúng tuyển vì môn 3 bị điểm liệt, với tổng điểm là: " + diemTongKet);
            } else {
                System.out.println("Thí sinh trúng tuyển với tổng điểm là: " + diemTongKet);
            }
        }
    }

    //Hàm nhập điểm chuẩn của hội đồng
    public static float nhapDiemChuan(Scanner scan) {
        float diemChuan;
        System.out.println("Vui lòng nhập điểm chuẩn: ");
        diemChuan = Float.parseFloat(scan.nextLine());
        return diemChuan; 
    }

    //Hàm nhập 3 môn thi   
    public static float nhapMonThi_1(Scanner scan) {
        float monThi; 
        System.out.println("Vui lòng nhập môn thi số 1: ");
        monThi = Float.parseFloat(scan.nextLine());
        return monThi; 
    }

    public static float nhapMonThi_2(Scanner scan) {
        float monThi; 
        System.out.println("Vui lòng nhập môn thi số 2: ");
        monThi = Float.parseFloat(scan.nextLine());
        return monThi; 
    }

    public static float nhapMonThi_3(Scanner scan) {
        float monThi; 
        System.out.println("Vui lòng nhập môn thi số 3: ");
        monThi = Float.parseFloat(scan.nextLine());
        return monThi; 
    }

    //Hàm nhập khu vực ưu tiên 
    public static String chonKhuVuc(Scanner scan) {
        String khuVuc;
        System.out.println("A. Khu vực A");
        System.out.println("B. Khu vực B");
        System.out.println("C. Khu vực C");
        System.out.println("X. Không thuộc khu vực ưu tiên");
        System.out.println("Vui lòng chọn khu vực phù hợp: ");
        khuVuc = scan.nextLine();
        return khuVuc;
    }

    //Hàm nhập đối tượng ưu tiên
    public static int chonDoiTuong(Scanner scan) {
        int doiTuong;
        System.out.println("1. Đối tượng 1");
        System.out.println("2. Đối tượng 2");
        System.out.println("3. Đối tượng 3");
        System.out.println("0. Không thuộc đối tượng ưu tiên");
        System.out.println("Vui lòng chọn đối tượng phù hợp: ");
        doiTuong = Integer.parseInt(scan.nextLine());
        return doiTuong; 
    }

    //Hàm điểm ưu tiên theo khu vực 
    public static float theoKhuVuc (String khuVuc) {
        float diemUuTien = 0; 
        if (khuVuc.equals("A")){
            diemUuTien = KHU_VUC_A;
        } else if (khuVuc.equals("B")) {
            diemUuTien = KHU_VUC_B;
        } else if (khuVuc.equals("C")) {
            diemUuTien = KHU_VUC_C;
        } else {
            diemUuTien = 0;
        } 
        return diemUuTien;
    }

    //Hàm điểm ưu tiên theo đối tượng 
    public static float theoDoiTuong(int doiTuong) {
        float diemUuTien = 0;
        if (doiTuong == 1) {
            diemUuTien = DOI_TUONG_1;
        } else if (doiTuong == 2) {
            diemUuTien = DOI_TUONG_2;
        } else if (doiTuong == 3) {
            diemUuTien = DOI_TUONG_3;
        } else {
            diemUuTien = 0;
        }
        return diemUuTien; 
    }
}

/*  NHẬN XÉT CỦA GIẢNG VIÊN
    Lưu ý: Các bài tập nộp chỉ làm 1 project và mỗi bài là 1 class bên trong, không được tách ra từng project để làm. 
    Tên class phải trùng với tên file thì mới run được.
    
    Hằng số có giá trị 2 mà khai báo biến kiểu float là không hợp lý, ở đây nên khai báo biến kiểu byte thì hợp lý hơn
    Còn lại thì bài giải đúng
    ---
    MY NOTES
    Không cần code lại bài này, chỉ cần chữa lại phần khai báo biến cho phù hợp ở phía trên
 */
