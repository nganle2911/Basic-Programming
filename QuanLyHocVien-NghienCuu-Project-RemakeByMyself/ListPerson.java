import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Mục đích: để quản lý những nghiệp vụ liên quan đến lớp ListPerson
 * Người tạo: Kim Ngân
 * Ngày tạo: 19/02/2022
 * Version: 1.0 
 */
public class ListPerson {
    //1. Attribute
    private ArrayList<Person> list; //đây chỉ là khai báo thuộc tính 
    //2. Get, set 
    public ArrayList<Person> getList() {
        return list;
    }

    public void setList(ArrayList<Person> list) {
        this.list = list;
    }
    //3. Constructor
    public ListPerson() {
        list = new ArrayList<Person>(); //khởi tạo list ở đây 
    }
    //4. Input, output
    private void inMenu() {
        System.out.println("1. Nhập Student ");
        System.out.println("2. Nhập Employee ");
        System.out.println("3. Nhập Customer ");
        System.out.println("0. Thoát");
        System.out.println("--------------------------------------------");
        System.out.println("Vui lòng chọn theo menu: ");
    }
    public void nhap(Scanner scan) {
        boolean flag = true; 
        do {
            inMenu();
            System.out.print("Mời chọn >> ");
            int chon = Integer.parseInt(scan.nextLine());
            Person person; //khởi tạo 1 object person ở đây
            switch (chon) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    person = new Student(); // khởi tạo object person trong lớp Student
                    person.nhap(scan); // nhap() function này nằm trong function nhap() của lớp Student
                    list.add(person);
                    break;
                case 2:
                    person = new Employee();
                    person.nhap(scan);
                    list.add(person);
                    break;
                case 3:
                    person = new Customer();
                    person.nhap(scan);
                    list.add(person);
                    break;
                default:
                    System.out.print("Chỉ được nhập số từ 0-3");
            }
        } while (flag);
    }
    public void xuat() {
        for (Person person : this.list) {
            person.xuat();
        }
    }
    //5. Business
    private void interChangeSort(ArrayList<Person> listPerson) {
        int i; 
        int j; 
        for (i = 0; i < listPerson.size() - 1; i++) {
            for (j = i + 1; j < listPerson.size(); j++) {
                Person person1 = listPerson.get(i);
                Person person2 = listPerson.get(j);
                if (person2.getHoTen().compareToIgnoreCase(person1.getHoTen()) < 0) {
                    Collections.swap(listPerson, i, j);
                }
            }
        }
    }
    public void sapXepThepTen() {
        interChangeSort(this.list);
    }
    public boolean xoaPersonTheoMa(String ma) {
        boolean deleted = false; 
        for (Person person : this.list) {
            if (person.getMa().equalsIgnoreCase(ma)) {
                this.list.remove(person);
                deleted = true;
                break;
            }
        }
        return deleted; 
    }

    public void dummyData() {
		Person person;
		person = new Student("long", "92 Tân định", "1", "abc@gmail.com", 8, 4, 9);
		this.list.add(person);

		person = new Student("hùng", "2 Nhà bè", "2", "daabc@gmail.com", 5, 10, 9);
		this.list.add(person);

		person = new Employee("Lan", "4 Phú Tân", "3", "fdaabc@gmail.com", 15, 20);
		this.list.add(person);

		person = new Employee("Việt", "3 Bến Tre", "4", "dgbc@gmail.com", 20, 20);
		this.list.add(person);

		person = new Employee("Ngà", "4 Tiền Giang", "5", "ddgbc@gmail.com", 30, 24);
		this.list.add(person);

		person = new Customer("An", "5 Đà Nẵng", "6", "ddgbc@gmail.com", "CyberLearn", 20, "Good");
		this.list.add(person);

		person = new Customer("Vùng", "8 Đà Nẵng", "7", "rdgbc@gmail.com", "CyberSoft", 25, "Very Good");
		this.list.add(person);

	}

}
