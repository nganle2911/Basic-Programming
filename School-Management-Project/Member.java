import java.util.Scanner;

/**
 * Purpose: To manage information related to Member 
 * Who created: Kim Ngan
 * Date created: March 11st 2022
 * Version: 1.0
 */
public class Member implements InputOutput {

    //1. Attributes
    protected String name; 
    protected int yearOfBirth; 
    protected String placeOfBirth; 
    protected String address;

    //2. Getter, setter methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    //3. Constructor methods
    public Member() {

    }
    public Member(String name, int yearOfBirth, String placeOfBirth, String address) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.address = address;
    }

    //4. Input, output methods
    @Override
    public void input(Scanner scan) {
        System.out.print("Enter name: ");
        this.name = scan.nextLine();

        System.out.print("Enter year of birth: ");
        this.yearOfBirth = Integer.parseInt(scan.nextLine());

        System.out.print("Enter place of birth: ");
        this.placeOfBirth = scan.nextLine();

        System.out.print("Enter address: ");
        this.address = scan.nextLine(); 
    }

    @Override
    public void output() {
        System.out.print("Name: " + this.name + 
                            "\t Year of birth: " + this.yearOfBirth + 
                            "\t Place of birth: " + this.placeOfBirth + 
                            "\t Address: " + this.address);        
    }
    
    //5. Business methods 
    

    
}