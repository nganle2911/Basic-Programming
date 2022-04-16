import java.util.Calendar;
import java.util.Scanner;

/**
 * Purpose: To manage information related to Teacher class 
 * Who created: Kim Ngan
 * Date created: March 11st 2022 
 * Version: 1.0
 */
public class Teacher extends Member {
    
    //1. Attributes
    private int startYear; 
    private String major; 
    private int teachingYears; 

    //2. Getter, setter methods
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public int getTeachingYears() {
        return teachingYears;
    }
    
    //3. Constructor methods
    public Teacher() {

    }
    public Teacher(String name, int yearOfBirth, String placeOfBirth, String address, int startYear, String major) {
        super(name, yearOfBirth, placeOfBirth, address);
        this.startYear = startYear;
        this.major = major;
    }
    
    //4. Input, output methods
    @Override
    public void input(Scanner scan) {
        super.input(scan);
        System.out.print("Enter start year: ");
        this.startYear = Integer.parseInt(scan.nextLine());

        System.out.print("Enter major: ");
        this.major = scan.nextLine(); 
    }

    @Override
    public void output() {
        super.output();
        System.out.println("\t Start year: " + this.startYear + "\t Major: " + this.major + "\t Teaching years: " + this.teachingYears + " years");
    }

    //5. Business methods 
    public void calculateTeachingYears() {
        Calendar calendar = Calendar.getInstance(); 
        this.teachingYears = calendar.get(Calendar.YEAR) - this.startYear; 
    }
}
