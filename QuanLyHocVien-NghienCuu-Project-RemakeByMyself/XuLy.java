import java.util.Scanner;

public class XuLy {
    
    private static void inMenu() {
        System.out.println("****************************************************");
        System.out.println("1. Thêm người vào");
        System.out.println("2. Xoá người theo mã");
        System.out.println("3. Sắp xếp người theo tên");
        System.out.println("4. Xuất danh sách");
        System.out.println("0. Thoát khỏi chương trình");
        System.out.println("****************************************************");
        System.out.println("Thực hiện: ");
    }

    private static void doMenu(Scanner scan) {
        boolean flag = true; 
        ListPerson objectListPerson = new ListPerson();
        objectListPerson.dummyData();
        
        do {
            inMenu();
            System.out.print("Mời chọn >> ");
            int chon = Integer.parseInt(scan.nextLine());
            switch (chon) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    objectListPerson.nhap(scan);
                    break;
                case 2:
                    System.out.print("Nhập mã cần xoá: ");
                    String chonMa = scan.nextLine();
                    boolean deleted = objectListPerson.xoaPersonTheoMa(chonMa);
                    if (deleted) {
                        System.out.println("Đã xoá thành công");
                    } else {
                        System.out.println("Chưa được xoá hoặc mã không có trong danh sách");
                    }
                    break;
                case 3:
                    objectListPerson.sapXepThepTen();
                    break;
                case 4:
                    objectListPerson.xuat();
                    break;
                default:
                    System.out.println("Chỉ chọn số từ 0-4");
            }
        } while (flag);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        doMenu(scan);
    }
}
